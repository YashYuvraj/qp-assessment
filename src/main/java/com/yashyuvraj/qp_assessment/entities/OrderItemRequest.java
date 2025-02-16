package com.yashyuvraj.qp_assessment.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemRequest {
        @NotNull(message = "Grocery item ID is required")
        private Long groceryItemId;

        @Min(value = 1, message = "Quantity must be at least 1")
        private int quantity;

        public Long getGroceryItemId() { return groceryItemId; }
        public void setGroceryItemId(Long groceryItemId) { this.groceryItemId = groceryItemId; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
}
