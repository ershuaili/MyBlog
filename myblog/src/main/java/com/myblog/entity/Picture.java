package com.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Picture)实体类
 *
 * @author 李二帅
 * @since 2021-11-02 22:22:20
 */
@Data
public class Picture implements Serializable {
    private static final long serialVersionUID = 316591405937855073L;
    /**
     * 照片id
     */
    private Long pictureId;
    /**
     * 照片地址
     */
    private String pictureAddress;
    /**
     * 照片描述
     */
    private String pictureDescription;
}
