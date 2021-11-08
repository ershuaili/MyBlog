package com.myblog.service;

import com.myblog.entity.User;

/**
 * (User)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:01
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 通过用户名获取用户信息
     * @param userNickname 用户名
     * @return 用户
     */
    User queryUserByNickname(String userNickname);
}
