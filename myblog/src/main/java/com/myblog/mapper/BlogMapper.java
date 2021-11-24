package com.myblog.mapper;

import com.myblog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:58
 */
@Mapper
public interface BlogMapper {
    /**
     * 查询博客总数
     * @return 博客总数
     */
    int queryAllCount();
    /**
     * 查询浏览总数
     * @return 浏览数
     */
    int queryAllVisits();
    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    Blog queryById(Long articleId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Blog> queryAll();

    /**
     * 分页查新博客信息
     * @param offset 分页起始位置
     * @param limit 每页条数
     * @return 博客信息
     */
    List<Blog> queryAllByLimit(int offset,int limit);
}

