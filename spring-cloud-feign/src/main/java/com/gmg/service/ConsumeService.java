package com.gmg.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-server",fallback = ConsumeServiceHystric.class)
public interface ConsumeService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHi();
}
