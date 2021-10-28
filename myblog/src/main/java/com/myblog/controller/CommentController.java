package com.myblog.controller;

import com.myblog.entity.Comment;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Comment)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:59
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Autowired
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Comment selectOne(Long id) {
        return this.commentService.queryById(id);
    }

}
