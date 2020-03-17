package com.example.demo.resources;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderDetails;
import com.example.demo.model.UserDetail;
import com.example.demo.service.OrderServices;

@RestController
@RequestMapping("/consumer")
public class UserConsumerResources {

	//UserDetail user;

	@Autowired
	OrderServices orderServices;

	//@StreamListener(Processor.INPUT)
	@Async("threadPoolexecutor")
	public void getUserFromKafka(UserDetail user) {
		System.out.println(user);
		//this.user=user;
	}

	@PostMapping(path = "/saveOrder")
	@StreamListener(Processor.INPUT)
	@Async("threadPoolexecutor")
	public /*@ResponseBody CompletableFuture<OrderDetails>*/void  createOrder(UserDetail user/* @RequestBody Order order */) throws InterruptedException, ExecutionException  {
		String orderBy=user.getFirstName()+user.getMiddleName()+user.getLastName();
		OrderDetails orderDetails=new OrderDetails("credit cared",orderBy,new Date(),new Date(), user.getId());
		CompletableFuture<OrderDetails> orderdetails2=orderServices.saveOrderDetails(orderDetails);
		System.out.println(orderdetails2.get());
		//return orderdetails2;
	}
	
   /* @PutMapping(path = "/updateOrder")
	@StreamListener(Processor.INPUT)
	@Async("threadPoolexecutor")
	public void updateOrder(UserDetail user) throws InterruptedException, ExecutionException {
		String orderBy=user.getFirstName()+user.getMiddleName()+user.getLastName();
		OrderDetails orderDetails=new OrderDetails(1,"credit cared",orderBy,new Date(),new Date(), user.getId());
		CompletableFuture<OrderDetails> orderdetails2=orderServices.saveOrderDetails(orderDetails);
		System.out.println(orderdetails2.get());
	} */
	
}