package com.order.order.controller;

import com.order.order.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Sample", url = "http://localhost:8081")  // Update with your User Service URL
public interface UserClient {

    @GetMapping("/users/get/{id}")
    UserDto getUserById(@PathVariable("id") Long userId);
}
