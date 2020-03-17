package com.example.demo.resources;

import java.util.concurrent.CompletableFuture;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetail;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(path ="/user")
public class UserResources {
	
	org.jboss.logging.Logger logger=LoggerFactory.logger(UserResources.class);
	@Autowired
	private UserService userService;

	@PostMapping(path="/saveUser")
	@Async("taskExecutor")
	public @ResponseBody CompletableFuture<UserDetail> user(@RequestBody UserDetail user) {
		logger.info("user resources class");
		CompletableFuture<UserDetail> userDetail=userService.saveUer(user); 
		logger.info("user resources"+userDetail);
		return userDetail;
	}
	
}
