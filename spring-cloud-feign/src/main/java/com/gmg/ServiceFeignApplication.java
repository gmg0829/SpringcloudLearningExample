package com.gmg;

import com.netflix.loadbalancer.IRule;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ServiceFeignApplication {

	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {

		SpringApplication.run(ServiceFeignApplication.class, args);

	}
}
