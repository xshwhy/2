package com.iotmars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xsh
 * @date: 2020/11/27 17:25
 */
@MapperScan(value = "com.iotmars.mapper")
@SpringBootApplication
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class,args);
    }
}
