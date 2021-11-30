package com.myblog;

import com.myblog.mapper.TypeMapper;
import com.myblog.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private CommentService commentService;

    @Test
    void test() {
        System.out.println(commentService.queryAllByBlogId(1L));
    }
}
