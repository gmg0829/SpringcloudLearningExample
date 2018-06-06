package com.example.apolloclient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication
@Configuration
@EnableApolloConfig
public class ApolloclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloclientApplication.class, args);
	}
}
