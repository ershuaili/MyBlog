package com.myblog.service.impl;

import com.myblog.entity.User;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * (MyUserDetails)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        //todo 查询是否有此用户名
        User user  = new User();
        user.setUserName("123");
        //todo 查询数据库中的密码
        user.setPassword(bCryptPasswordEncoder.encode("123"));
        //todo 查询数据库中的角色 , 必须加前缀 ROLE_
        user.setRole("ROLE_USER");
        //todo 可自定义异常进行处理
        if (ObjectUtils.isEmpty(user)){
            throw new RuntimeException("用户不存在");
        }
        System.out.println(user.getUserPassword());
        return user;
    }

}
