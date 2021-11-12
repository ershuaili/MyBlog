package com.myblog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * (MyUserDetails)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Data
@NoArgsConstructor
public class User implements UserDetails {
    private static final long serialVersionUID = 364698759980551813L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户头像
     */
    private String userHeadPortrait;
    /**
     * 创建时间
     */
    private Date userCreateTime;
    /**
     * 用户权限
     */
    private String userRights;
    /**
     * 远程码
     */
    private String verCode;

    public User(HttpServletRequest request){
        this.userNickname = request.getParameter("username");
        this.userPassword = request.getParameter("password");
        this.verCode = request.getParameter("verCode");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(this::getRole);
        return auths;
    }

    public String getRole() {
        return userRights;
    }

    public void setRole(String role) {
        this.userRights = role;
    }

    public void setUserName(String username) {
        this.userNickname = username;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
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
