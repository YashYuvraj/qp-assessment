package com.yashyuvraj.qp_assessment.entities;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequest {

    @NotNull(message = "User ID is required")
    private String userId;
    @NotEmpty(message = "At least one item is required")
    private List<OrderItemRequest> items;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public List<OrderItemRequest> getItems() { return items; }
    public void setItemIds(List<OrderItemRequest> items) { this.items = items; }
}
