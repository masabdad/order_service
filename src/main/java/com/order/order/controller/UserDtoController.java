package com.order.order.controller;

import com.order.order.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
@RestController
public class UserDtoController {
    private final RestTemplate restTemplate = new RestTemplate();

    public UserDto getUserById(Long userId) {
        ResponseEntity<UserDto> response = restTemplate.getForEntity("http://localhost:8081/users/" + userId, UserDto.class);
        return response.getBody();
    }
}

