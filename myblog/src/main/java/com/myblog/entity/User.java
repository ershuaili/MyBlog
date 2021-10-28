package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Data
public class User implements Serializable {
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
}
