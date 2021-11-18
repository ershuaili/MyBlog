package com.myblog.controller;

import com.myblog.util.JwtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/11/18 下午 05:29 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@RestController
public class CheckTokenController {
    /**
     * 查询所有博客
     *
     * @return BlogList
     */
    @PostMapping("/checkToken")
    @CrossOrigin
    public Map<String, Object> validateToken(String token) {
        System.out.println(token);
        return JwtUtil.validateToken(token);
    }
}
