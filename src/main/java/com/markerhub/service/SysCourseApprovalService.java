package com.markerhub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.markerhub.entity.SysCourseApprovalEntity;
import com.markerhub.utils.PageUtils;


import java.security.Principal;
import java.util.Map;

/**
 * 课程审批表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-16 10:42:51
 */
public interface SysCourseApprovalService extends IService<SysCourseApprovalEntity> {

    PageUtils queryPage(Map<String, Object> params, Principal principal);

    /**
     * 课程审批结果通知
     * @param sysCourseApproval
     */
    void sendMsg(SysCourseApprovalEntity sysCourseApproval);
}

