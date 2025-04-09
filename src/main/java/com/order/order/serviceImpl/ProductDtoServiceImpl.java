package com.order.order.serviceImpl;

import com.order.order.exceptions.ProductNotFoundException;
import com.order.order.model.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDtoServiceImpl {
    public ProductDto getProductById(Long productId) {
        try {
            return new RestTemplate().getForObject("http://localhost:8082/products/"+productId, ProductDto.class);
        } catch (Exception e) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
    }
}
