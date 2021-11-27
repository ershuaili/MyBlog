package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Type)实体类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Data
public class Type implements Serializable {
    private static final long serialVersionUID = 233239097354708292L;
    /**
     * 分类id
     */
    private Long typeId;
    /**
     * 分类名称
     */
    private String typeName;
    /**
     * 分类内容
     */
    private String typeContent;
    /**
     * 分类创建时间
     */
    private Date typeCreateTime;

    /**
     * 一个分类可以有多个博客
     */
    private List<Blog> blogs;
}
