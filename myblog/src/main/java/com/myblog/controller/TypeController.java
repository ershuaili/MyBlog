package com.myblog.controller;

import com.myblog.entity.Type;
import com.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 查询所有分类信息
     * @return 分类列表
     */
    @GetMapping("/queryAll")
    public List<Type> queryAll() {
        return typeService.queryAll();
    }

    /**
     * 通过分类名获取分类信息
     * @param typeName 分类名
     * @return 分类信息
     */
    @GetMapping("/queryByTypeName")
    public Type queryByTypeName(String typeName) {
        return typeService.queryByTypeName(typeName);
    }
}
