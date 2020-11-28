package com.iotmars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xsh
 * @date: 2020/11/27 16:36
 */
@MapperScan(value = "com.iotmars.mapper")
@SpringBootApplication
public class OauthSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthSourceApplication.class,args);
    }
}
