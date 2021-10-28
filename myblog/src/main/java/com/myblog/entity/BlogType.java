package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (BlogType)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:59
 */
@Data
public class BlogType implements Serializable {
    private static final long serialVersionUID = -92991119921108898L;
    /**
     * 博客分类id
     */
    private Long id;
    /**
     * 博客id
     */
    private Long blogId;
    /**
     * 分类id
     */
    private Long typeId;
}
