package com.myblog.service;

import com.myblog.entity.Picture;

import java.util.List;

/**
 * (Picture)表服务接口
 *
 * @author 李二帅
 * @date 2021-11-02 22:22:20
 */
public interface PictureService {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    Picture queryById(Long pictureId);

    /**
     * 查询所有对象
     *
     * @return 实例对象
     */
    List<Picture> queryAll();

}
