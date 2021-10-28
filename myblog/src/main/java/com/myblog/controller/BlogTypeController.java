package com.myblog.controller;

import com.myblog.entity.BlogType;
import com.myblog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (BlogType)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:59
 */
@RestController
@RequestMapping("blogType")
public class BlogTypeController {
    /**
     * 服务对象
     */
    @Autowired
    private BlogTypeService blogTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BlogType selectOne(Long id) {
        return this.blogTypeService.queryById(id);
    }

}
