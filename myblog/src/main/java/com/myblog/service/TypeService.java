package com.myblog.service;

import com.myblog.entity.Type;

import java.util.List;

/**
 * (Type)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
public interface TypeService {

    /**
     * 查询所有数据
     * @return 数据集合
     */
    List<Type> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Type queryById(Long typeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Type> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    Type insert(Type type);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    Type update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long typeId);
}
