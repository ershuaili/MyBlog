package com.myblog.controller;

import com.myblog.entity.Blog;
import com.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Blog)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:58
 */
@RestController
@RequestMapping("blog")
public class BlogController {
    /**
     * 服务对象
     */
    @Autowired
    private BlogService blogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @CrossOrigin
    public Blog selectOne(Long id) {
        return this.blogService.queryById(id);
    }

    /**
     * 查询所有博客
     *
     * @return BlogList
     */
    @GetMapping("selectAll")
    @CrossOrigin
    public List<Blog> selectAll() {
        return this.blogService.queryAll();
    }
}