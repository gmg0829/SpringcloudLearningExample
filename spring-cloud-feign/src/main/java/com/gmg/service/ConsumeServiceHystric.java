package com.gmg.service;

import org.springframework.stereotype.Component;


@Component
public class ConsumeServiceHystric implements ConsumeService {
    @Override
    public String sayHi() {
        return "服务不通，请重试";
    }
}
