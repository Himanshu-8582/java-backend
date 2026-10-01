package com.example.TransactionalProperties.repository;

import com.example.TransactionalProperties.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
