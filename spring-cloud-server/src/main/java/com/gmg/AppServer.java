package com.gmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 生产者服务
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppServer.class, args);
    }
}
