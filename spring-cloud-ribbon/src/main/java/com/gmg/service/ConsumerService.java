package com.gmg.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/4/26  15:05
 */
@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        loadBalancerClient.choose("service-server");
        return restTemplate.getForEntity("http://service-server/hello", String.class).getBody();
    }
    public String fallback() {
        return "服务不通，请稍后重试！";
    }

}
