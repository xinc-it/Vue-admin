package com.markerhub.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-15 13:51:15
 */
@Mapper
public interface SysCourseMapper extends BaseMapper<SysCourseEntity> {

    Page<CourseVO> getAllCourse(Page<CourseVO> page, @Param("name") Object name);

    Page<CourseVO> getTeacherCourseByUserId(Page<CourseVO> page, @Param("name") Object name,@Param("id") Long id );
}
