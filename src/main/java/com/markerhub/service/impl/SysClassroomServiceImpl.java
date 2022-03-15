package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysClassroomEntity;
import com.markerhub.entity.vo.ClassroomVO;
import com.markerhub.mapper.SysClassroomMapper;
import com.markerhub.service.SysClassroomService;
import com.markerhub.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysClassroomService")
public class SysClassroomServiceImpl extends ServiceImpl<SysClassroomMapper, SysClassroomEntity> implements SysClassroomService {

    @Autowired
    private SysClassroomMapper classroomMapper;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer limit = (Integer) params.get("limit");
        Integer pageNum = (Integer) params.get("page");
        Object key = params.get("key");
        Page<ClassroomVO> page = new Page<>(pageNum, limit);
        page = classroomMapper.pageAllClassRoom(page, key);
        //IPage<SysClassroomEntity> page = this.page(
        //        new Query<SysClassroomEntity>().getPage(params),
        //        new QueryWrapper<SysClassroomEntity>()
        //);
        //
        return new PageUtils(page);
    }

}