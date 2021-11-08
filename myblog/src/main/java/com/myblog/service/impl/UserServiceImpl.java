package com.myblog.service.impl;

import com.myblog.entity.User;
import com.myblog.mapper.UserMapper;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long userId) {
        return this.userMapper.queryById(userId);
    }

    @Override
    public User queryUserByNickname(String userNickname) {
        return this.userMapper.queryUserByNickname(userNickname);
    }

}
