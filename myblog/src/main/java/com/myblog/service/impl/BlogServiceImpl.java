package com.myblog.service.impl;

import com.myblog.entity.Blog;
import com.myblog.mapper.BlogMapper;
import com.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
     * 查询所有博客
     *
     * @return BLogList
     */
    @Override
    public List<Blog> queryAll() {
        return this.blogMapper.queryAll();
    }

    /**
     * 获取网站公共信息
     *
     * @return 集合
     */
    @Override
    public Map<String, Object> queryCommonMessage() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("BlogCount",this.blogMapper.queryAllCount());
        map.put("ViewsCount",this.blogMapper.queryAllVisits());
        return map;
    }

    /**
     * 分页查询博客信息
     *
     * @param page 页数
     * @return 博客信息列表
     */
    @Override
    public List<Blog> queryAllByLimit(int page) {
        int limit = 5;
        int offset = page * limit - limit;
        // 分页大小
        return this.blogMapper.queryAllByLimit(offset, limit);
    }

}
