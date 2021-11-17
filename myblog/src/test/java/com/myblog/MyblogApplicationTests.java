package com.myblog;

import com.myblog.service.UserService;
import com.myblog.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(JwtUtil.generateToken("123","admin"));
    }
    @Test
    void token(){
        System.out.println(JwtUtil.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6IjEyMyIsInVzZXJSaWdodHMiOiJhZG1pbiIsImlhdCI6MTYzNzE0MjAyOSwiZXhwIjoxNjM3MjI4NDI5fQ.-fsGDPyd8FpCKCqT5SfXluMM7UVp7a8tjhFoqx67CRQ"));
    }

}
