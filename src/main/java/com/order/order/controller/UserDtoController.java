package com.order.order.controller;

import com.order.order.model.UserDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

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
}

