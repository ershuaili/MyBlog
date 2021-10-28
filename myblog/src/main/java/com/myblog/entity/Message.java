package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Message)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -15563570359888857L;
    /**
     * 留言id
     */
    private Long messageId;
    /**
     * 留言者id
     */
    private Long messageUserId;
    /**
     * 留言内容
     */
    private String messageContent;
    /**
     * 留言创建时间
     */
    private Date messageCreateTime;
}
