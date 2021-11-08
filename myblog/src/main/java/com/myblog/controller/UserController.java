package com.myblog.controller;

import com.myblog.entity.User;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @PostMapping("/login")
    @CrossOrigin
    public String login(User user) {
        System.out.println(user);
        User userByNickname = userService.queryUserByNickname(user.getUserNickname());
        System.out.println(userByNickname);
        if (userByNickname != null) {
            return "200";
        }else {
            return "400";
        }
    }

}
