package com.order.order.service;


import com.order.order.model.Order;

import java.util.List;

public interface OrderService {
    String placeOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
}
