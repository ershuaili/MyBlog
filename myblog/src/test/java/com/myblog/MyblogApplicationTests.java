package com.myblog;

import com.myblog.entity.Comment;
import com.myblog.mapper.CommentMapper;
import com.myblog.mapper.TypeMapper;
import com.myblog.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void test() {
        System.out.println(commentService.queryAllByBlogId(1L));
    }

    @Test
    void commentTest() {
        List<Comment> result = new ArrayList<>();
        List<Comment> comments = this.commentMapper.queryAllByBlogId(1L);
        for (Comment comment : comments) {
            // 查询该评论的所有子评论
            List<Comment> commentList = commentMapper.queryParentCommentById(comment.getCommentId());
            comment.setChildComments(commentList);
            result.add(comment);
        }
        System.out.println(result);

        // List<Comment> all = new ArrayList<>();
        // Map<Long, Comment> map = new HashMap<>();
        // List<Comment> result = new ArrayList<>();
        // for (Comment c : all) {
        //     if (c.parentId == null) {
        //         result.add(c);
        //     }
        //     map.put(c.commentId, c);
        // }
        // for (Comment c : all) {
        //     if (c.parentId != null) {
        //         Comment parent = map.get(c.parentId);
        //         if (parent.child == null) {
        //             parent.child = new ArrayList<>();
        //         }
        //         parent.child.add(c);
        //     }
        // }
    }
}
