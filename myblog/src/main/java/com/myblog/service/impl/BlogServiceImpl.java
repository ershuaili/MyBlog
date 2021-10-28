package com.myblog.service.impl;

import com.myblog.entity.Blog;
import com.myblog.mapper.BlogMapper;
import com.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Blog)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:58
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    @Override
    public Blog queryById(Long articleId) {
        return this.blogMapper.queryById(articleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Blog> queryAllByLimit(int offset, int limit) {
        return this.blogMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog insert(Blog blog) {
        this.blogMapper.insert(blog);
        return blog;
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog update(Blog blog) {
        this.blogMapper.update(blog);
        return this.queryById(blog.getArticleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long articleId) {
        return this.blogMapper.deleteById(articleId) > 0;
    }
}
