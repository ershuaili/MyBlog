package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Message)实体类
 *
 * @author 李二帅
 * @since 2021-11-21 12:21:38
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -70109370525687895L;
    /**
    * 留言id
    */
    private Long messageId;
    /**
    * 留言者用户名
    */
    private String messageUserNickname;
    /**
    * 留言内容
    */
    private String messageContent;
    /**
    * 留言创建时间
    */
    private Date messageCreateTime;
    /**
     * 表连接关联查询 User
     */
    private User user;
}
