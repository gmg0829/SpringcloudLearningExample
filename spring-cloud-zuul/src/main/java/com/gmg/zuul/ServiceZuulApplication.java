package com.gmg.zuul;

import com.gmg.zuul.filter.RateLimitZuulFilter;
import com.gmg.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 服务限流
 *
 */
//开启Zuul功能
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication{
	
    public static void main( String[] args ){
    	
    	SpringApplication.run(ServiceZuulApplication.class, args);
    }


   //控制黑白名单
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
   //限流过滤器
    @Bean
    public RateLimitZuulFilter rateLimitZuulFilter() {
        return new RateLimitZuulFilter();
    }
}
