package com.myblog.mapper;

import com.myblog.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
@Mapper
public interface TypeMapper {

    /**
     * 查询所有分类信息
     * @return 分类列表
     */
    List<Type> queryAll();

    /**
     * 查询分类信息通过 分类名称
     * @param typeName 分类名称
     * @return 分类信息
     */
    Type queryByTypeName(String typeName);

}

