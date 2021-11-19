package com.myblog.controller;

import com.myblog.entity.User;
import com.myblog.service.UserService;
import com.myblog.util.JwtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/11/19 下午 06:38 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 用户token校验
     * @param token token
     * @return 用户信息
     */
    @PostMapping("/checkToken")
    @CrossOrigin
    public Map<String, Object> validateToken(String token) {
        System.out.println(token);
        return JwtUtil.validateToken(token);
    }

    /**
     * 通过用户实体插入用户
     * @param user 用户实体
     * @return 是否成功
     */
    @PostMapping("/insert")
    @CrossOrigin
    public boolean insert(User user){
        return userService.insert(user);
    }
}
