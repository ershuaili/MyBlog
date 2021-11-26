package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Blog)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:58
 */
@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = -45593083012450490L;
    /**
     * 博客id
     */
    private Long articleId;
    /**
     * 博客标题
     */
    private String articleTitle;
    /**
     * 博客首图
     */
    private String articleFirstPicture;
    /**
     * 博客描述
     */
    private String articleDescription;
    /**
     * 博客内容
     */
    private String articleContent;
    /**
     * 博客创建时间
     */
    private Date articleCreateTime;
    /**
     * 博客更新时间
     */
    private Date articleUpdateTime;
    /**
     * 浏览次数
     */
    private Long articleVisitsCount;
    /**
     * 评论次数
     */
    private Long articleCommentCount;
    /**
     * 点赞次数
     */
    private Long articleLikeCount;

    /**
     * 与Type的关联查询 一个博客可以有多个分类
     */
    private List<Type> types;
}
