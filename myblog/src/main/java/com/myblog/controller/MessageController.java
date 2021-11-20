package com.myblog.controller;

import com.myblog.entity.Message;
import com.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Message)表控制层
 *
 * @author 李二帅
 * @date 2021-10-28 12:28:00
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageService messageService;

    /**
     * 分页查询数据
     * @param page 页数
     * @return 数据列表
     */
    @GetMapping("/queryMessageByLimit")
    public List<Message> queryMessageByLimit(Integer page){
        return this.messageService.queryAllByLimit(page);
    }
}
