package com.myblog.mapper;

import com.myblog.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
@Mapper
public interface MessageMapper {
    /**
     * 查询数据总数
     * @return 数据总数
     */
    int queryAllNumber();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Message> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 影响行数
     */
    int deleteById(Long messageId);

}

