package com.example.demo;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableBinding(Processor.class)
@EnableAsync
public class UserDetailsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsConsumerApplication.class, args);
	}
	
	@Bean(name = "threadPoolexecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor threadPoolexecutor=new ThreadPoolTaskExecutor();
		threadPoolexecutor.setCorePoolSize(2);
		threadPoolexecutor.setMaxPoolSize(2);
		threadPoolexecutor.setQueueCapacity(50);
		threadPoolexecutor.setThreadNamePrefix("order-thread");
		threadPoolexecutor.initialize();
		return threadPoolexecutor;
	}
}
