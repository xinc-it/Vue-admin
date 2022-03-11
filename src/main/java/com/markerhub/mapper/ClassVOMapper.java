package com.markerhub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.entity.vo.ClassVO;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * Date：2022/3/11
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
public interface ClassVOMapper extends BaseMapper<ClassVOMapper> {

    Page<ClassVO>  pageAllClass(Page<ClassVO> pageInfo,@Param("name")Object name);
}
