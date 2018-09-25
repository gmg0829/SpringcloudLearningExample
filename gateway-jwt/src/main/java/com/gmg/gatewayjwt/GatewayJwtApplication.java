package com.gmg.gatewayjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class GatewayJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayJwtApplication.class, args);
	}
}
