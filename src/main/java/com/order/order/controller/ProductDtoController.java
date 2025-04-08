package com.order.order.controller;

import com.order.order.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductDtoController {
    private final RestTemplate restTemplate = new RestTemplate();

    public ProductDto getProductById(Long productId) {
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("http://localhost:8082/products/{id}" + productId, ProductDto.class);
        return response.getBody();
    }
}
