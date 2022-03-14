package com.markerhub.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.vo.ClassVO;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * 班级表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 13:38:08
 */
@Mapper
public interface SysClassMapper extends BaseMapper<SysClassEntity> {
    Page<ClassVO> pageAllClass(Page<ClassVO> pageInfo, @Param("name")Object name);
}
