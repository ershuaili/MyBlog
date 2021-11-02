package com.myblog.service.impl;

import com.myblog.entity.Picture;
import com.myblog.mapper.PictureMapper;
import com.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Picture)表服务实现类
 *
 * @author 李二帅
 * @since 2021-11-02 22:22:20
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    @Override
    public Picture queryById(Long pictureId) {
        return this.pictureMapper.queryById(pictureId);
    }

    /**
     * 查询所有对象
     *
     * @return 实例对象
     */
    @Override
    public List<Picture> queryAll() {
        return this.pictureMapper.queryAll();
    }
}
