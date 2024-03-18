package org.log.travel.log_travel_project.service.oauth;

import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.Enum.Role;
import org.log.travel.log_travel_project.repository.entity.Users;
import org.log.travel.log_travel_project.web.dto.OAuthAttributes;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OauthService {

    public OAuthAttributes of(String registrationId, String userNameAttributeName,
                              Map<String,Object> attributes){
        if("naver".equals(registrationId)){
            return ofNaver("id",attributes);
        }
        return ofGoogle(userNameAttributeName,attributes);
    }

    public OAuthAttributes ofGoogle(String userNameAttributeName, Map<String,Object> attributes){
        return OAuthAttributes.builder().name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName).build();
    }

    public OAuthAttributes ofNaver(String userNameAttributeName, Map<String,Object> attributes){
        Map<String,Object> response = attributes.containsKey("response")? (Map<String,Object>) attributes.get("response") : Collections.emptyMap();
        return OAuthAttributes.builder().name((String) response.get("name")).email((String) response.get("email"))
                .picture((String) response.get("profile_image")).attributes(response)
                .nameAttributeKey(userNameAttributeName).build();
    }

    public Users toEntity(String name, String email,String picture){
        return Users.builder().name(name)
                .email(email).imageUrl(picture).role(Role.GUEST).
        build();
    }



}
