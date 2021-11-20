package com.myblog.service.impl;

import com.myblog.entity.Message;
import com.myblog.mapper.MessageMapper;
import com.myblog.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author 李二帅
 * @since 2021-10-28 12:28:00
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(Long messageId) {
        return this.messageMapper.queryById(messageId);
    }

    /**
     * 分页查询数据
     *
     * @param page 查询页数
     * @return 对象列表
     */
    @Override
    public List<Message> queryAllByLimit(int page) {
        int limit = 5;
        int offset = page * limit - limit;
        // 分页大小
        return this.messageMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message insert(Message message) {
        this.messageMapper.insert(message);
        return message;
    }

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long messageId) {
        return this.messageMapper.deleteById(messageId) > 0;
    }
}
