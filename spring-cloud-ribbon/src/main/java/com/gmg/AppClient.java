package com.gmg;

import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 	服务消费端!
 */

//@EnableCircuitBreaker	//开启断路器功能
@EnableHystrix
//@EnableHystrixDashboard	//监控面板
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

	@Bean
	public IRule ribbonRule(){
		return new RandomRule();
	}
	//AbstractLoadBalancer
	// BaseLoadBalancer  choseServer //挑选一个具体的微服务实例  addServer markServerDown
	// getReachableServers//获取可用的微服务实例  getAllServers 获取所有的微服务实例
	// DynamicServerListLoadBalancer 对BaseLoadBalancer的拓展
	// ZoneAffinityServerListFilter 区域感知的方式实现服务的过滤
	// AbstractLoadBalancerRule 负载均衡策略类
	// RandomRule 随机选择一个服务实例  在全部的服务实例个数中获取一个随机数，在拿这个随机数获取可用的服务
	// RoundRobinRule 先行轮询的方式选择一个实例  如果一直选择不到sever超过10次，那么就会尝试结束
     // RetryRule 重试机制的实例选择功能 默认使用了RoundRobinRule实例，选择到返回，若选择不到根据设置的阈值（maxRetryMillis[500]+当前时间戳），当超过当前阈值，则返回null。
	// WeightedResponseTimeRule 更具权重挑选实例  权重=总的响应时间-实例的平均响应时间    平均时间越短 权重区间越大，被选到的概率越大
	//生成一个[0,最大权重值]的随机数，如果当前实例的权重值大于随机数，拿当前实例的索引值去获取当前实例

}
