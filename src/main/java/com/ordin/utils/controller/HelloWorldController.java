package com.ordin.utils.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/hello", tags = "helloworld")
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @ApiOperation(value = "helloworld", notes = "helloworld")
    @GetMapping("/world")
    public String index(@ApiParam(value = "hello") @RequestParam(value = "id", required = false) String id) {
        return "HelloWorld";
    }
}
