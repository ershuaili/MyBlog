package com.myblog.mapper;

import com.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:01
 */
@Mapper
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 查询用户通过用户名
     * @param userNickname 用户名
     * @return 用户实体
     */
    User queryUserByNickname(String userNickname);
}

