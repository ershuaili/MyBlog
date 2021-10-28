package com.myblog.service;

import com.myblog.entity.BlogType;

import java.util.List;

/**
 * (BlogType)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:59
 */
public interface BlogTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BlogType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BlogType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    BlogType insert(BlogType blogType);

    /**
     * 修改数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    BlogType update(BlogType blogType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
