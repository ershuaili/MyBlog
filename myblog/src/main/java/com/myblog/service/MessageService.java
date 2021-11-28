package com.myblog.service;

import com.myblog.entity.Message;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
public interface MessageService {

    /**
     * 查询所有留言数据
     * @return 留言数据集合
     */
    List<Message> queryAll();

    /**
     * 查询数据总数
     * @return 数据总数
     */
    int queryAllNumber();

    /**
     * 分页查询数据
     * @param page 查询页数
     * @return 对象列表
     */
    List<Message> queryAllByLimit(int page);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message insert(Message message);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(Long messageId);

}
