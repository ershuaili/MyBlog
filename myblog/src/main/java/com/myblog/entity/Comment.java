package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:59
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -51625506275812881L;
    /**
     * 用户评论id
     */
    private Long commentId;
    /**
     * 用户评论id
     */
    private Long commentUserId;
    /**
     * 评论文章id
     */
    private Long commentArticleId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 用户评论时间
     */
    private Date commentCreateTime;
    /**
     * 父评论id
     */
    private Long parentCommentId;
}
