package com.order.order.controller;


import com.order.order.model.ProductDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDtoController {

    private final ProductClient productClient;

    public ProductDtoController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @RolesAllowed({"client_user", "client_admin"})
    public ProductDto getProductById(Long productId) {
        return productClient.getProductById(productId);
    }
}
