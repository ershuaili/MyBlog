package com.myblog.service;

import com.myblog.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:59
 */
public interface CommentService {

    /**
     * 通过博客查询评论信息
     * @param blogId 博客id
     * @return 评论信息列表
     */
    List<Comment> queryAllByBlogId(Long blogId);


    /**
     * 新增用户评论
     * @param comment 用户评论实体
     * @return boolean
     */
    boolean insertComment(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(Long messageId);
}
