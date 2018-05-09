package com.gmg.controller;

import javafx.util.converter.PercentageStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.sampler.PercentageBasedSampler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 *@author	作者：gmg
 *@date	创建时间：2018年3月14日 下午5:52:44
 *@version	版本： 1.0
 *说明：服务端api
 */
@RestController
public class HelloController {

    private final Logger logger= LoggerFactory.getLogger(getClass());
	@RequestMapping(value="/hello",method=RequestMethod.GET)
    public String sayHello(HttpServletRequest request){
	    logger.info("call service-server,TraceId={},SpanId={}",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
       // Span  //  request.getHeader() 头部信息
       // Sampler  抽样收集策略
        //PercentageBasedSampler 以百分比的方式配置和收集跟踪信息
	    return "hello spring-cloud-server";
    }

    @RequestMapping(value="/hi",method=RequestMethod.GET)
    public String sayHi(){
        return "hi spring-cloud-server";
    }

}
