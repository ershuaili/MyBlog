package com.myblog.service.impl;

import com.myblog.entity.Type;
import com.myblog.mapper.TypeMapper;
import com.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Type)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询所有分类信息
     *
     * @return 分类列表
     */
    @Override
    public List<Type> queryAll() {
        return this.typeMapper.queryAll();
    }

    /**
     * 查询分类信息通过 分类名称
     *
     * @param typeName 分类名称
     * @return 分类信息
     */
    @Override
    public Type queryByTypeName(String typeName) {
        return this.typeMapper.queryByTypeName(typeName);
    }
}
