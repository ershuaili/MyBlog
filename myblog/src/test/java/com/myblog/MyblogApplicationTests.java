package com.myblog;

import com.myblog.entity.User;
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
        User user = userService.queryUserByNickname("1");
        System.out.println(JwtUtil.generateToken(user));
    }
    @Test
    void token(){
        System.out.println(JwtUtil.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmlja25hbWUiOiIxIiwidXNlclJpZ2h0cyI6IlVTRVIiLCJpYXQiOjE2MzcxNTYwNDEsImV4cCI6MTYzNzI0MjQ0MX0.DA6R9FVIjRuOCrrqroOTI8SWDgJd7AN5_dZdehoLGsw"));
    }

    @Test
    void password(){
        System.out.println(bCryptPasswordEncoder.encode("阿衰"));
    }
}
