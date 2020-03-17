package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetail;
import com.example.demo.repositery.UserRepositery;

@Service
public class UserService {

	org.jboss.logging.Logger logger=LoggerFactory.logger(UserService.class);
	
	@Autowired
	private UserRepositery userRepositery;

	@Autowired
	private MessageChannel output;

	@Async("taskExecutor")
	public CompletableFuture<UserDetail> saveUer(UserDetail userDetail) {
		UserDetail user=userRepositery.save(userDetail);
		logger.info("userdetails "+userDetail);
		output.send(MessageBuilder.withPayload(userDetail).build());
		logger.info("data is put inside kafka culster");
		return CompletableFuture.completedFuture(user);
	}
}
