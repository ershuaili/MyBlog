package com.myblog.service.impl;

import com.myblog.entity.Comment;
import com.myblog.mapper.CommentMapper;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * (Comment)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:59
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public Map<String, Object> test(Long blogId) {
        List<Comment> comments = this.commentMapper.queryAllByBlogId(blogId);

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("comment", this.commentMapper.queryAllByBlogId(blogId));
        return map;
    }

    /**
     * 通过博客查询评论信息
     *
     * @param blogId 博客id
     * @return 评论信息列表
     */
    @Override
    public List<Comment> queryAllByBlogId(Long blogId) {
        return this.commentMapper.queryAllByBlogId(blogId);
    }

    /**
     * 查询某一个评论的所有子评论
     *
     * @param commentId 父评论id
     * @return 评论信息列表
     */
    @Override
    public List<Comment> queryChildrenComment(Long commentId) {
        return this.commentMapper.queryChildrenComment(commentId);
    }

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long messageId) {
        return this.commentMapper.deleteById(messageId);
    }
}
