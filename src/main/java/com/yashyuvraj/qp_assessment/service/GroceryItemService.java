package com.yashyuvraj.qp_assessment.service;

import com.yashyuvraj.qp_assessment.entities.GroceryItem;
import com.yashyuvraj.qp_assessment.exceptions.ItemNotFoundException;
import com.yashyuvraj.qp_assessment.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem getItemById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));
    }

    public GroceryItem addItem(GroceryItem item) {
        System.out.println("adding item");
        return groceryItemRepository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        GroceryItem item = groceryItemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));

        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());
        return groceryItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        if (!groceryItemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item with id " + id + " not found");
        }
        groceryItemRepository.deleteById(id);
    }
}
