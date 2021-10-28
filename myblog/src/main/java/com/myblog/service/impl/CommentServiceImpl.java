package com.myblog.service.impl;

import com.myblog.entity.Comment;
import com.myblog.mapper.CommentMapper;
import com.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Long commentId) {
        return this.commentMapper.queryById(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentMapper.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentMapper.update(comment);
        return this.queryById(comment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long commentId) {
        return this.commentMapper.deleteById(commentId) > 0;
    }
}
