package com.yashyuvraj.qp_assessment.controller;

import com.yashyuvraj.qp_assessment.entities.GroceryItem;
import com.yashyuvraj.qp_assessment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/grocery")
public class GroceryItemController {
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public GroceryItem getItemById(@PathVariable Long id) {
        return groceryItemService.getItemById(id);
    }

    @PostMapping
    public GroceryItem addItem(@RequestBody GroceryItem item) {
        return groceryItemService.addItem(item);
    }

    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return groceryItemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
    }
}
