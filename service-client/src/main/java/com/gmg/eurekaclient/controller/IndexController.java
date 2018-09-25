package com.gmg.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/9/25  14:22
 */
@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
