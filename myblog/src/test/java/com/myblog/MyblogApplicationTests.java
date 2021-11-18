package com.myblog;

import com.myblog.service.UserService;
import com.myblog.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        // System.out.println(authentication.getAuthorities());
        // User user = userService.queryUserByNickname("1");
        // System.out.println(jwtUtil.generateToken("1"));
        // System.out.println(JwtUtil.generateToken("1"));
    }

    // 签发token
    @Test
    void generateToken(){
        System.out.println(JwtUtil.generateToken("test", "ADMIN"));
    }
    // 验证token
    @Test
    void validateToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImFhYWEiLCJ1c2VyUmlnaHRzIjoiQURNSU4iLCJpYXQiOjE2MzcyNDY3MzYsImV4cCI6MTYzNzMzMzEzNn0.LN2n5-llEd9oNxa6zpUeUwGmwNeH_--vIUMvJlhgWjM";
        System.out.println(JwtUtil.validateToken(token));
    }

    @Test
    void token() {
        String token = JwtUtil.generateToken("a","admin");
        // Claims claims = JwtUtil.checkJwt("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6IumYv-ihsCIsInVzZXJSaWdodHMiOiJBRE1JTiIsImlhdCI6MTYzNzIzMTgyMSwiZXhwIjoxNjM3MzE4MjIxfQ.6cYI1SjZO8Q2VQ7-Kc_D42N3zt9kCkFwD6Ou8qruByw");
        // System.out.println(claims);
    }

    @Test
    void password(){
        System.out.println(bCryptPasswordEncoder.encode("阿衰"));
    }
}
