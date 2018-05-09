package com.gmg.controller;

import com.gmg.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 *@author	作者：gmg
 *@date	创建时间：2018年3月15日 上午11:34:36
 *@version	版本： 1.0
 *说明：此非必须，主要是方便测试，直观在网页中看到结果
 */

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;


    private final Logger logger=Logger.getLogger(getClass());
    @GetMapping("/consumer")
    public String hello() {
        logger.info("service-ribbon");
        return consumerService.consumer();
    }
}
