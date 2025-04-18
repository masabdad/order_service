package com.order.order.config;

import com.order.order.exceptions.TokenNotFoundException;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = getCurrentAccessToken();
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }

    public static String getCurrentAccessToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtauthenticationtoken) {
            return jwtauthenticationtoken.getToken().getTokenValue();
        }
        throw new TokenNotFoundException("Failed to extract token from context");
    }
}
