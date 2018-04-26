package com.gmg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmg on 2018/4/10.
 */
@RestController
@RequestMapping(value = "test")
public class WhiteListController {
    @RequestMapping(value = "/01")
    public String test01() {
        return "测试01在白名单";
    }
    @RequestMapping(value = "/02")
    public String test03() {
        return "测试02不在白名单";
    }

}
