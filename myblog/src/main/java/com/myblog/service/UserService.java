package com.myblog.service;

import com.myblog.entity.User;

import java.util.List;

/**
 * (MyUserDetails)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:01
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> queryAll();

    /**
     * 查询用户通过用户名
     * @param userNickname 用户名
     * @return 用户实体
     */
    User queryUserByNickname(String userNickname);

    /**
     * 新增用户
     *
     * @param user 用户对象
     * @return 影响行数
     */
    boolean insert(User user);
}
