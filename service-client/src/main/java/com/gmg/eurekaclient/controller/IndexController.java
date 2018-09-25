package com.gmg.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = "/v1")
    public String v1() {
        return "v1";
    }

    @GetMapping(value = "/v2")
    public String v2() {
        return "v2";
    }
}
