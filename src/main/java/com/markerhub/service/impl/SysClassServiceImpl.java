package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.vo.ClassVO;
import com.markerhub.mapper.SysClassMapper;
import com.markerhub.service.SysClassService;
import com.markerhub.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysClassService")
public class SysClassServiceImpl extends ServiceImpl<SysClassMapper, SysClassEntity> implements SysClassService {


    @Autowired
    private SysClassMapper classVOMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer limit = (Integer) params.get("limit");
        Integer pageNum = (Integer) params.get("page");
        Page<ClassVO> page = new Page<>(pageNum, limit);
        Object key = params.get("key");
        page = classVOMapper.pageAllClass(page, key);
        return new PageUtils(page);
    }


    @Override
    public List<SysClassEntity> getAllClass() {
        QueryWrapper<SysClassEntity> wrapper = new QueryWrapper().select("id", "name");
        wrapper.eq("statu", Integer.valueOf(1));
        List<SysClassEntity> classEntityList = list(wrapper);
        return classEntityList;
    }
}