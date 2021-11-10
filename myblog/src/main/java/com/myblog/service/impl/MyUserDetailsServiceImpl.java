package com.myblog.service.impl;

import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>描述: [] </p>
 * <p>创建时间: 2021/11/10 下午 04:10 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("执行登录");
        com.myblog.entity.User user = userService.queryUserByNickname(userName);
        if (user == null) {
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
            return new User(user.getUserNickname(), new BCryptPasswordEncoder().encode(user.getUserPassword()), auth);
        }
    }
}
