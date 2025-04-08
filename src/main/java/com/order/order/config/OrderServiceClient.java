package com.order.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<?> getOrdersForProduct(Long productId) {
        String url = "http://localhost:8082/orders/product/" + productId;
        return restTemplate.getForObject(url, List.class);
    }
}
