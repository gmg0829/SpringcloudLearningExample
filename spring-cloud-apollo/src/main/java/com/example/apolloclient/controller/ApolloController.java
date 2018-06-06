package com.example.apolloclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/6/6  9:52
 */
@RestController
public class ApolloController {
   @Value("${test.msg}")
   private String msg;

   @RequestMapping("/index")
   public String index(){
       return msg;
   }

}
