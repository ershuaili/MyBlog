package com.myblog.service.impl;

import com.myblog.entity.BlogType;
import com.myblog.mapper.BlogTypeMapper;
import com.myblog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (BlogType)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:59
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeMapper blogTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BlogType queryById(Long id) {
        return this.blogTypeMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogType> queryAllByLimit(int offset, int limit) {
        return this.blogTypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    @Override
    public BlogType insert(BlogType blogType) {
        this.blogTypeMapper.insert(blogType);
        return blogType;
    }

    /**
     * 修改数据
     *
     * @param blogType 实例对象
     * @return 实例对象
     */
    @Override
    public BlogType update(BlogType blogType) {
        this.blogTypeMapper.update(blogType);
        return this.queryById(blogType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.blogTypeMapper.deleteById(id) > 0;
    }
}
