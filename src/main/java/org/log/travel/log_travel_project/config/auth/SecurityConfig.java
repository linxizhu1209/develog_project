package org.log.travel.log_travel_project.config.auth;

import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.csrf((csrf)->csrf.disable())
                .headers((headers)->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(auth->auth.requestMatchers("/**","/css/**","/img/**","/js/**","/font/**","/h2-console/**").permitAll()
//                        .requestMatchers("/v1/**").hasRole(Role.GUEST.name())
                        .anyRequest().authenticated())
                .logout((logout)->logout.logoutSuccessUrl("/"))
                .oauth2Login((oauth2)->oauth2.userInfoEndpoint(userInfoEndPoint->
                        userInfoEndPoint.userService(customOAuth2UserService)).defaultSuccessUrl("/",true).permitAll());
        return http.build();



    }


}
