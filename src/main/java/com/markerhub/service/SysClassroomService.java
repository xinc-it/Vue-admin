package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysClassroomEntity;
import com.markerhub.utils.PageUtils;

import java.util.Map;

/**
 * 教室表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-14 17:05:04
 */
public interface SysClassroomService extends IService<SysClassroomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

