package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderDetails;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderServices {

	@Autowired
	OrderRepo orderRepo;
	
	@Async("threadPoolexecutor")
	public CompletableFuture<OrderDetails> saveOrderDetails(OrderDetails orderDetails) {
		OrderDetails orderDetails2=orderRepo.save(orderDetails);
		return CompletableFuture.completedFuture(orderDetails2);
	}
	
	@Async("threadPoolexecutor")
	public CompletableFuture<OrderDetails> updateOrder(OrderDetails orderDetails){
		OrderDetails orderDetails2=orderRepo.saveAndFlush(orderDetails);
		return CompletableFuture.completedFuture(orderDetails2);
	}
}
