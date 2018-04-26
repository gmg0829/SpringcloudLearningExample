package com.gmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 	服务消费端!
 */

@EnableCircuitBreaker	//开启断路器功能
@EnableHystrixDashboard	//监控面板
@EnableDiscoveryClient //开启自动装配
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class AppClient 
{

	
    public static void main( String[] args )
    {
		SpringApplication.run(AppClient.class, args);
    }

	/*
	 * 注入服务消费模板并开启负载均衡
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
