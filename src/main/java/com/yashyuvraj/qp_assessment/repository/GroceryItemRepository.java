package com.yashyuvraj.qp_assessment.repository;

import com.yashyuvraj.qp_assessment.entities.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem,Long> {
}
