package com.gmg.eurekaclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("测试集成Swagger")
public class IndexController {

    @ApiOperation(value = "v1", notes = "v1测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",  value = "字符串name", required = true, dataType = "String")
    })
    @GetMapping(value = "/v1")
    public String v1(String name) {
        return name;
    }

    @GetMapping(value = "/v2")
    public String v2() {
        return "v2";
    }
}
