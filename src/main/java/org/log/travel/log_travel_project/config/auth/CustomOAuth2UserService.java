package org.log.travel.log_travel_project.config.auth;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.UserRepository;
import org.log.travel.log_travel_project.repository.entity.Users;
import org.log.travel.log_travel_project.service.oauth.OauthService;
import org.log.travel.log_travel_project.web.dto.OAuthAttributes;
import org.log.travel.log_travel_project.web.dto.SessionUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;
    private final OauthService oauthService;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        /**
         *  1. registrationId -> 현재 로그인 진행중인 서비스를 구분하는 코드(구글이냐 네이버냐)
         *  2. UserNameAttributeName -> OAuth2 로그인 진행시 키가 되는 필드값
         */

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        /**
         * OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
         */
        OAuthAttributes attributes = oauthService.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Users user = saveOrUpdate(attributes);

        /**
         * SessionUser란 ?
         * 세션에 사용자 정보를 저장하기 위한 dto클래스
         */

        httpSession.setAttribute("user",new SessionUser(user.getName(),user.getEmail(),user.getImageUrl()));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }
    private Users saveOrUpdate(OAuthAttributes attributes){
    Users user = userRepository.findByEmail(attributes.getEmail())
            .map(entity->entity.update(attributes.getName()
                    , attributes.getPicture())).orElse(oauthService.toEntity(attributes.getName(),attributes.getEmail(),attributes.getPicture()));
    return userRepository.save(user);
        }
    }

