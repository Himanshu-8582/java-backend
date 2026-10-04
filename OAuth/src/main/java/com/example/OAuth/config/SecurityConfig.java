package com.example.OAuth.config;

import com.example.OAuth.service.CustomOidcUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, CustomOidcUserService customOidcUserService){
        httpSecurity.authorizeHttpRequests(
                auth->
                        auth.requestMatchers("/")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2Login(oauth->
                        oauth.userInfoEndpoint(userInfo->
                                userInfo.oidcUserService(customOidcUserService)
                        )
                                .defaultSuccessUrl("/profile",true)
                );
        return httpSecurity.build();
    }
}
