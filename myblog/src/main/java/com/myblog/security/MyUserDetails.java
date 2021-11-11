package com.myblog.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <p>描述: [实现了UserDetails接口，只留必需的属性，也可添加自己需要的属性] </p>
 * <p>创建时间: 2021/11/11 下午 04:58 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
@Component
public class MyUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 登录用户名
     */
    private String userNickname;
    /**
     * 登录密码
     */
    private String userPassword;

    private Collection<? extends GrantedAuthority> authorities;

    public void setUserNickname(String username) {
        this.userNickname = username;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userNickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}