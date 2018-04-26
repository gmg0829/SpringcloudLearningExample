package com.gmg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author	作者：gmg
 *@date	创建时间：2018年3月14日 下午5:52:44
 *@version	版本： 1.0
 *说明：服务端api
 */
@RestController
public class HelloController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
    public String sayHello(){
        return "hello spring-cloud-server";
    }

    @RequestMapping(value="/hi",method=RequestMethod.GET)
    public String sayHi(){
        return "hi spring-cloud-server";
    }

}
