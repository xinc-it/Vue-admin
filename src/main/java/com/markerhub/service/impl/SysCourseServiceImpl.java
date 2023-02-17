package com.markerhub.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.SysRole;
import com.markerhub.entity.SysUser;
import com.markerhub.entity.vo.CourseVO;
import com.markerhub.mapper.SysCourseMapper;
import com.markerhub.service.SysCourseService;
import com.markerhub.service.SysUserService;
import com.markerhub.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Map;


@Service("sysCourseService")
public class SysCourseServiceImpl extends ServiceImpl<SysCourseMapper, SysCourseEntity> implements SysCourseService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysCourseMapper courseMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Principal principal) {

        Integer limit = (Integer) params.get("limit");
        Integer pageNum = (Integer) params.get("page");
        Page<CourseVO> page = new Page<>(pageNum, limit);
        Object key = params.get("key");
        String name = principal.getName();
        SysUser user = sysUserService.getUserRoleByName(name);
        List<SysRole> sysRoles = user.getSysRoles();
        if (SysUserService.userIsManager(sysRoles)) {
            page = courseMapper.getAllCourse(page, key);
        } else {
            page = courseMapper.getTeacherCourseByUserId(page, key, user.getId());
        }
        return new PageUtils(page);
    }

    @Override
    public List<CourseVO> getCoursesByUserId(Long id) {
        List<CourseVO> courseVOList = courseMapper.getCourseByUserId(id);
        //QueryWrapper<SysCourseEntity> wrapper = new QueryWrapper<SysCourseEntity>()
        //        .select("id", "name")
        //        .eq("teacher_id", id)
        //        .eq("statu", 1)
        //        .in("course_statu", 0,3);
        //List<SysCourseEntity> courseList = list(wrapper);
        return courseVOList;
    }

    @Override
    public CourseVO getCourseDetail(Long id) {
        return courseMapper.getCourseDetailById(id);
    }
}