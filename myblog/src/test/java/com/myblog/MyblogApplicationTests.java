package com.myblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {

    @Test
    void contextLoads() {
        boolean a = true, b = false;
        if (a || b) {
            System.out.println("真");
        } else {
            System.out.println("假");
        }
    }

}
