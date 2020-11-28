package com.iotmars.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: xsh
 * @date: 2020/11/26 17:13
 */
@Controller
public class TestController {

    @Secured("ROLE_PRODUCT")
    @GetMapping(value = "/product/findAll")
    public String test() {
        return "product-list";
    }


}
