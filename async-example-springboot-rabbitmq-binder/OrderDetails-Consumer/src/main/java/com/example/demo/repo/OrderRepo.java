package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderDetails;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Integer>{

}
