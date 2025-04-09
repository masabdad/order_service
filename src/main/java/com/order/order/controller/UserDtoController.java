package com.order.order.controller;

import com.order.order.model.UserDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
@RestController
public class UserDtoController {

    private final UserClient userClient;

    public UserDtoController(UserClient userClient) {
        this.userClient = userClient;
    }

    @RolesAllowed({"client_user", "client_admin"})
    public UserDto getUserById(Long userId) {
        return userClient.getUserById(userId);
    }
//    private final RestTemplate restTemplate = new RestTemplate();
//
//
//    @RolesAllowed({"client_user","client_admin"})
//    public UserDto getUserById(Long userId) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(getCurrentAccessToken());
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<UserDto> response = restTemplate.exchange(
//                "http://localhost:8081/users/" + userId,
//                HttpMethod.GET,
//                entity,
//                UserDto.class
//        );
//
//        return response.getBody();
//    }
//    public String getCurrentAccessToken() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof JwtAuthenticationToken jwtAuthToken) {
//            return jwtAuthToken.getToken().getTokenValue();
//        }
//        throw new RuntimeException("Failed to extract token from context");
//    }


}

