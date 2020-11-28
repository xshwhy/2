package com.iotmars.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2020/11/26 17:13
 */
@RestController
public class TestController {

    @Secured("ROLE_PRODUCT")
    @GetMapping(value = "/product/findAll")
    public String test() {
        return "列表查询!";
    }


}
