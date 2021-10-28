package com.myblog.service;

import com.myblog.entity.Blog;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:58
 */
public interface BlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    Blog queryById(Long articleId);

    /**
     * 查询所有博客
     *
     * @return BLogList
     */
    List<Blog> queryAll();
}
