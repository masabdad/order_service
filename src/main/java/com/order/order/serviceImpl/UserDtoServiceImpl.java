package com.order.order.serviceImpl;

import com.order.order.exceptions.UserNotFoundException;
import com.order.order.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDtoServiceImpl {
    public UserDto getUserById(Long userId) {
        try {
            return new RestTemplate().getForObject("http://localhost:8081/users/" + userId, UserDto.class);
        } catch (Exception e) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
    }
}
