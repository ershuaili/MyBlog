package com.myblog;

import com.myblog.mapper.PictureMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    private PictureMapper pictureService;

    @Test
    void contextLoads() {
        System.out.println(pictureService.queryAll());
    }

}
