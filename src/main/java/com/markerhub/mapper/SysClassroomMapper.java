package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysClassroomEntity;
import com.markerhub.entity.vo.ClassroomVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 教室表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-14 17:05:04
 */
@Mapper
public interface SysClassroomMapper extends BaseMapper<SysClassroomEntity> {

    Page<ClassroomVO> pageAllClassRoom(Page<ClassroomVO> page,@Param("name") Object name);
}
