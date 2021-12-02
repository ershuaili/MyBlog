package com.myblog.service.impl;

import com.myblog.entity.Comment;
import com.myblog.mapper.CommentMapper;
import com.myblog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:27:59
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过博客查询评论信息
     *
     * @param blogId 博客id
     * @return 评论信息列表
     */
    @Override
    public List<Comment> queryAllByBlogId(Long blogId) {
        // 定义一个数组存储查询到的结果集
        List<Comment> result = new ArrayList<>();
        // 通过博客id查询所有父评论
        List<Comment> comments = this.commentMapper.queryAllByBlogId(blogId);
        for (Comment comment : comments) {
            // 查询该评论的所有子评论
            List<Comment> commentList = commentMapper.queryParentCommentById(comment.getCommentId());
            comment.setChildComments(commentList);
            result.add(comment);
        }
        return result;
    }

    /**
     * 新增用户评论
     *
     * @param comment 用户评论实体
     * @return boolean
     */
    @Override
    public boolean insertComment(Comment comment) {
        return this.commentMapper.insertComment(comment);
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
