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






//package com.order.order.controller;
//
//import com.order.order.model.ProductDto;
//import com.order.order.model.UserDto;
//import jakarta.annotation.security.RolesAllowed;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class ProductDtoController {
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @RolesAllowed({"client_user", "client_admin"})
//    public ProductDto getProductById(Long productId) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(getCurrentAccessToken()); // Get current token from security context
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<ProductDto> response = restTemplate.exchange(
//                "http://localhost:8082/products/" + productId,
//                HttpMethod.GET,
//                entity,
//                ProductDto.class
//        );
//        return response.getBody();
//    }
//
//    public String getCurrentAccessToken() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof JwtAuthenticationToken jwtAuthToken) {
//            return jwtAuthToken.getToken().getTokenValue();
//        }
//        throw new RuntimeException("Failed to extract token from context");
//    }
//}
