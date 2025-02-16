package com.yashyuvraj.qp_assessment.service;

import com.yashyuvraj.qp_assessment.entities.*;
import com.yashyuvraj.qp_assessment.exceptions.ItemNotFoundException;
import com.yashyuvraj.qp_assessment.repository.GroceryItemRepository;
import com.yashyuvraj.qp_assessment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order placeOrder(OrderRequest orderRequest) {
            // Create a new order
            Order order = new Order();
            order.setUserId(orderRequest.getUserId());

            List<OrderItem> orderItems = new ArrayList<>();
            double totalPrice = 0;

            for (OrderItemRequest itemRequest : orderRequest.getItems()) {
                // Fetch grocery item
                GroceryItem groceryItem = groceryItemRepository.findById(itemRequest.getGroceryItemId())
                        .orElseThrow(() -> new RuntimeException("Grocery item not found"));

                // Create OrderItem
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setGroceryItem(groceryItem);
                orderItem.setQuantity(itemRequest.getQuantity());

                // Calculate total price
                totalPrice += groceryItem.getPrice() * itemRequest.getQuantity();

                orderItems.add(orderItem);
            }

            order.setTotalPrice(totalPrice);
            order.setOrderItems(orderItems);

            // Save order and order items
            return orderRepository.save(order);
    }
}
