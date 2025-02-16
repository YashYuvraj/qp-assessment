package com.yashyuvraj.qp_assessment.controller;

import com.yashyuvraj.qp_assessment.entities.GroceryItem;
import com.yashyuvraj.qp_assessment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/grocery")
public class UserGroceryController {
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAvailableItems() {
        return groceryItemService.getAllItems();
    }
}
