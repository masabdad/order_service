package com.order.order.dao;

import com.order.order.model.Order;

import java.util.List;

public interface OrderDao {
    void saveOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
}
