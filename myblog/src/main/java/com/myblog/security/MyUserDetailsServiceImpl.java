package com.myblog.security;

import com.myblog.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private UserService userService;

    /**
     * 用户登录验证
     * 根据传进来的用户账号进行用户信息的构建
     * @param userName 用户名
     * @return MyUserDetails
     * @throws UsernameNotFoundException 用户名不存在
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(userName);
        System.out.println("执行登录");
        com.myblog.entity.User user = userService.queryUserByNickname(userName);
        MyUserDetails myUserDetail = new MyUserDetails();
        if (user == null) {
            System.out.println("用户名不存在");
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            myUserDetail.setUserNickname(userName);
            myUserDetail.setUserPassword(user.getUserPassword());
            List<GrantedAuthority> authorities =new ArrayList<>();
            myUserDetail.setAuthorities(authorities);
            return myUserDetail;
        }
    }
}
