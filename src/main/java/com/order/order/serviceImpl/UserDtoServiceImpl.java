package com.order.order.serviceImpl;

import com.order.order.exceptions.UserNotFoundException;
import com.order.order.model.UserDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDtoServiceImpl {
    @RolesAllowed( {"client_user","client_admin"})
    public UserDto getUserById(Long userId) {
        String url = "http://localhost:8081/users/get/" ;
        try {
            return new RestTemplate().getForObject(url+userId, UserDto.class);
        } catch (Exception e) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }
}
