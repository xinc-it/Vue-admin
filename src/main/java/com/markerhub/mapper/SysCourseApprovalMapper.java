package com.markerhub.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysCourseApprovalEntity;
import com.markerhub.entity.vo.CourseApprovalVO;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程审批表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-16 10:42:51
 */
@Mapper
public interface SysCourseApprovalMapper extends BaseMapper<SysCourseApprovalEntity> {

    Page<CourseApprovalVO> getAllCourseApproval(Page<CourseApprovalVO> page, @Param("name") Object name);

    Page<CourseApprovalVO> getCourseApprovalByUserId(Page<CourseApprovalVO> page,@Param("name") Object name, @Param("id") Long id);
}
