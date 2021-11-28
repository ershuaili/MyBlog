package com.myblog;

import com.myblog.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private TypeMapper typeMapper;

    @Test
    void test() {
        System.out.println(typeMapper.queryAll());
    }
}
