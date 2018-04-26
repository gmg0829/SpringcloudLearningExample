package com.gmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类：注册中心2
 *
 */
//开启eureka服务
@EnableEurekaServer
@SpringBootApplication
public class AppEurekaServer2 
{
    public static void main( String[] args )
    {

        SpringApplication.run(AppEurekaServer2.class, args);
    }
}
