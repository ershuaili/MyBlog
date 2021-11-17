package com.myblog.service.impl;

import com.myblog.entity.User;
import com.myblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * (MyUserDetails)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:01
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    /**
     * 从数据库查询用户
     * @param username 用户名
     * @return 用户
     * @throws UsernameNotFoundException 用户名未找到
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("查询用户: " + username);
        User user = userService.queryUserByNickname(username);
        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在");
            throw new RuntimeException("用户不存在");
        } else {
            return user;
        }
    }
}
