package com.yashyuvraj.qp_assessment.entities;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequest {

    @NotNull(message = "User ID is required")
    private String userId;
    @NotEmpty(message = "At least one item is required")
    private List<Long> itemIds;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public List<Long> getItemIds() { return itemIds; }
    public void setItemIds(List<Long> itemIds) { this.itemIds = itemIds; }
}
