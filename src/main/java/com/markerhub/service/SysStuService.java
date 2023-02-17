package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysStuEntity;
import com.markerhub.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 学生信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 15:23:43
 */
public interface SysStuService extends IService<SysStuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysStuEntity> getStuInfoByClass(Long classId);
}

