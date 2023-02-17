package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysStuEntity;
import com.markerhub.entity.vo.StudentVO;
import com.markerhub.mapper.SysStuMapper;
import com.markerhub.service.SysStuService;
import com.markerhub.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysStuService")
public class SysStuServiceImpl extends ServiceImpl<SysStuMapper, SysStuEntity> implements SysStuService {


    @Autowired
    private SysStuMapper stuMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer limit = (Integer) params.get("limit");
        Integer pageNum = (Integer) params.get("page");
        Object key = params.get("key");
        Page<StudentVO> page = new Page<StudentVO>(pageNum, limit);
        page = stuMapper.pageAllStudentVO(page, key);
        //IPage<SysStuEntity> page = this.page(
        //        new Query<SysStuEntity>().getPage(params),
        //        new QueryWrapper<SysStuEntity>()
        //);
        //return null;
        return new PageUtils(page);
    }


    @Override
    public List<SysStuEntity> getStuInfoByClass(Long classId) {
        QueryWrapper<SysStuEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("class_id", classId);
        List<SysStuEntity> stuEntityList = list(wrapper);
        return stuEntityList;
    }
}