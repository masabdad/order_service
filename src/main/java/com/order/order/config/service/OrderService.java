package com.order.order.config.service;

import com.order.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, product_name, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getProductName(), order.getQuantity());
    }

    public List<Order> getAllOrders() {
        return jdbcTemplate.query("SELECT * FROM orders", new BeanPropertyRowMapper<>(Order.class));
    }
}
