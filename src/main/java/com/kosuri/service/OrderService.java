package com.kosuri.service;

import com.kosuri.entity.Customer;
import com.kosuri.entity.Order;
import com.kosuri.entity.Product;
import com.kosuri.repository.CustomerRepository;
import com.kosuri.repository.OrderRepository;
import com.kosuri.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        for (Order o : orders) {
            System.out.println("Product: " + o.getProduct());
        }
        return orders;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrder(Long id, Order updatedOrder) {

        Order existing = getOrderById(id);

        if (updatedOrder.getProduct() != null) {
            Product product = productRepository.findById(
                    updatedOrder.getProduct().getProductId()
            ).orElseThrow(() -> new RuntimeException("Product not found"));

            existing.setProduct(product);
        }

        if (updatedOrder.getCustomer() != null) {
            Customer customer = customerRepository.findById(
                    updatedOrder.getCustomer().getCustomerId()
            ).orElseThrow(() -> new RuntimeException("Customer not found"));

            existing.setCustomer(customer);
        }
        return orderRepository.save(existing);
    }
}
