package com.markerhub.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysStuEntity;
import com.markerhub.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 学生信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 15:23:43
 */
@Mapper
public interface SysStuMapper extends BaseMapper<SysStuEntity> {

    Page<StudentVO> pageAllStudentVO(Page<StudentVO> pageInfo,@Param("name")Object name);
	
}
