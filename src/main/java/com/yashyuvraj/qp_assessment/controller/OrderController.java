package com.yashyuvraj.qp_assessment.controller;

import com.yashyuvraj.qp_assessment.entities.Order;
import com.yashyuvraj.qp_assessment.entities.OrderRequest;
import com.yashyuvraj.qp_assessment.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }
}
