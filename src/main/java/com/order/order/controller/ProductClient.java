package com.order.order.controller;

import com.order.order.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/products/get/{id}")
    ProductDto getProductById(@PathVariable("id") Long productId);
}
