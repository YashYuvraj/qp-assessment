package com.yashyuvraj.qp_assessment.service;

import com.yashyuvraj.qp_assessment.entities.GroceryItem;
import com.yashyuvraj.qp_assessment.entities.Order;
import com.yashyuvraj.qp_assessment.entities.OrderRequest;
import com.yashyuvraj.qp_assessment.exceptions.ItemNotFoundException;
import com.yashyuvraj.qp_assessment.repository.GroceryItemRepository;
import com.yashyuvraj.qp_assessment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        List<GroceryItem> items = groceryItemRepository.findAllById(orderRequest.getItemIds());
        if (items.isEmpty()) {
            throw new ItemNotFoundException("No items found for the given IDs");
        }

        double totalPrice = items.stream().mapToDouble(GroceryItem::getPrice).sum();
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setItems(items);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }
}
