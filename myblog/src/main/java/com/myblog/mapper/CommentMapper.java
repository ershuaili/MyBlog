package com.myblog.mapper;

import com.myblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-10-28 12:27:59
 */
@Mapper
public interface CommentMapper {

    /**
     * 通过博客查询评论信息
     * @param blogId 博客id
     * @return 评论信息列表
     */
    List<Comment> queryAllByBlogId(Long blogId);

    /**
     * 根据父评论查询所有子评论信息
     * @param parentId 父评论id
     * @return 信息列表
     */
    List<Comment> queryParentCommentById(Long parentId);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(Long messageId);
}

