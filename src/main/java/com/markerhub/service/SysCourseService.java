package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.vo.CourseVO;
import com.markerhub.utils.PageUtils;


import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * 课程表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-15 13:51:15
 */
public interface SysCourseService extends IService<SysCourseEntity> {

    PageUtils queryPage(Map<String, Object> params, Principal principal);

    List<CourseVO> getCoursesByUserId(Long id);

    CourseVO getCourseDetail(Long id);
}

