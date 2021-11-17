package com.myblog.service.impl;

import com.myblog.entity.User;
import com.myblog.mapper.UserMapper;
import com.myblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/11/17 下午 08:37 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询用户通过用户名
     *
     * @param userNickname 用户名
     * @return 用户实体
     */
    @Override
    public User queryUserByNickname(String userNickname) {
        return this.userMapper.queryUserByNickname(userNickname);
    }

}
