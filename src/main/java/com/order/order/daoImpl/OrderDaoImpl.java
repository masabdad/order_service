// OrderDaoImpl.java
package com.order.order.daoImpl;


import com.order.order.dao.OrderDao;
import com.order.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, product_id,product_name, quantity) VALUES (?, ?, ?,?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getProductId(),order.getProductName(), order.getQuantity());
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), userId);
    }
}
