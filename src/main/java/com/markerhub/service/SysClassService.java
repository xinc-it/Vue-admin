package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.vo.ClassVO;
import com.markerhub.utils.PageUtils;


import java.util.List;
import java.util.Map;

/**
 * 班级表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 13:38:08
 */
public interface SysClassService extends IService<SysClassEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysClassEntity> getAllClass();
}

