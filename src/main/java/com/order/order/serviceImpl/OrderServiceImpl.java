package com.order.order.serviceImpl;
import com.order.order.controller.ProductDtoController;
import com.order.order.controller.UserDtoController;
import com.order.order.dao.OrderDao;
import com.order.order.exceptions.ProductNotFoundException;
import com.order.order.exceptions.UserNotFoundException;
import com.order.order.model.Order;
import com.order.order.model.ProductDto;
import com.order.order.model.UserDto;
import com.order.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDtoController userDtoServiceImpl;

    @Autowired
    private ProductDtoController productClientServiceImpl;

    @Override
    public String placeOrder(Order order) {
        try {
            UserDto user = userDtoServiceImpl.getUserById(order.getUserId());
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + order.getUserId());
            }
            ProductDto product = productClientServiceImpl.getProductById(order.getProductId());
            if (product == null || product.getStock() < order.getQuantity()) {
                throw new ProductNotFoundException("Product is not available in requested quantity");
            }
            if (!product.getId().equals(order.getProductId())) {
                throw new ProductNotFoundException("Product mismatch for the order");
            }
            if (!user.getId().equals(order.getUserId())) {
                throw new UserNotFoundException("User mismatch for the order");
            }
            orderDao.saveOrder(order);
            return "Order placed successfully!";
        } catch (UserNotFoundException | ProductNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to place order: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        try {
            UserDto user = userDtoServiceImpl.getUserById(userId);
            if (user == null) throw new UserNotFoundException("User not found with ID: " + userId);

            return orderDao.getOrdersByUserId(userId);
        } catch (UserNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new UserNotFoundException("Failed to retrieve orders: " + e.getMessage());
        }
    }
}
