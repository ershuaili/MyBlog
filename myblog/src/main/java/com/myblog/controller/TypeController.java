package com.myblog.controller;

import com.myblog.entity.Type;
import com.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Type)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Autowired
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Type selectOne(Long id) {
        return this.typeService.queryById(id);
    }

}
