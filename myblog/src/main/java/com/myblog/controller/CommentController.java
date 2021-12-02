package com.myblog.controller;

import com.myblog.entity.Comment;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 根据博客信息查询博客所有评论
     *
     * @param blogId 博客id
     * @return 评论列表
     */
    @GetMapping("/queryAllByBlogId")
    public List<Comment> queryAllByBlogId(Long blogId) {
        return commentService.queryAllByBlogId(blogId);
    }

    @PostMapping("/insert")
    public boolean insertComment(Comment comment) {
        return commentService.insertComment(comment);
    }
}
