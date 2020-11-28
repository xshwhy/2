package com.iotmars;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootSecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String encode1 = encode.encode("123456");
        System.out.println(encode1);
    }

}
