package com.yashyuvraj.qp_assessment.repository;

import com.yashyuvraj.qp_assessment.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
