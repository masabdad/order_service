package com.order.order.model;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
public class Order {
    @Id
    @Generated
    private Long id;
    private Long userId;
    private Long productId;
    private String productName;
    private int quantity;
    private LocalDateTime orderDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
//    Getter Setter

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
