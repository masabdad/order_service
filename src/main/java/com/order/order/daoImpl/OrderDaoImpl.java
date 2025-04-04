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

    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, product_id, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getProductId(), order.getQuantity());
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), userId);
    }
}
