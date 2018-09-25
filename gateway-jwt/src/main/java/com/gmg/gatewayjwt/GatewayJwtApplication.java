package com.gmg.gatewayjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayJwtApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				//basic proxy
				.route(r ->r.path("/jd")
						.uri("http://jd.com:80/").id("jd_route")
				).build();
	}
	public static void main(String[] args) {
		SpringApplication.run(GatewayJwtApplication.class, args);
	}
}
