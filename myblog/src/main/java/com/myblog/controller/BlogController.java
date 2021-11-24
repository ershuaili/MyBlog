package com.myblog.controller;

import com.myblog.entity.Blog;
import com.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public Blog selectOne(Long id) {
        return this.blogService.queryById(id);
    }

    /**
     * 分页查询博客信息
     * @return 博客列表
     */
    @GetMapping("/queryBlogByLimit")
    public List<Blog> queryAllByLimit(int page){
        return blogService.queryAllByLimit(page);
    }

    /**
     * 查询博客公共信息
     * @return map
     */
    @GetMapping("queryCommonMessage")
    public Map<String, Object> queryCommonMessage(){
        return blogService.queryCommonMessage();
    }
}
