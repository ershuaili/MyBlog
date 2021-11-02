package com.myblog.controller;

import com.myblog.entity.Picture;
import com.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Picture)表控制层
 *
 * @author 李二帅
 * @date 2021-11-02 22:22:19
 */
@RestController
@RequestMapping("picture")
public class PictureController {
    /**
     * 服务对象
     */
    @Autowired
    private PictureService pictureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @CrossOrigin
    public Picture selectOne(Long id) {
        return this.pictureService.queryById(id);
    }

    /**
     * 查询所有照片对象
     *
     * @return 所有照片对象
     */
    @GetMapping("selectAll")
    @CrossOrigin
    public List<Picture> selectAll() {
        return this.pictureService.queryAll();
    }
}
