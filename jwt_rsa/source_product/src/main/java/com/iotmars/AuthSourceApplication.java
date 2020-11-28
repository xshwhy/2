package com.iotmars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xsh
 * @date: 2020/11/27 15:23
 */
@MapperScan(value = "com.iotmars.mapper")
@SpringBootApplication
public class AuthSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthSourceApplication.class, args);
    }


}
