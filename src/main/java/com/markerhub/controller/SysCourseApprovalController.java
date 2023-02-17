package com.markerhub.controller;

import com.markerhub.common.enums.ApprovalStatusEnums;
import com.markerhub.entity.SysCourseApprovalEntity;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.SysUser;
import com.markerhub.service.SysCourseApprovalService;
import com.markerhub.service.SysCourseService;
import com.markerhub.utils.PageUtils;
import com.markerhub.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 课程审批表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-16 10:42:51
 */
@RestController
@RequestMapping("generator/approval")
public class SysCourseApprovalController extends BaseController {
    @Autowired
    private SysCourseApprovalService sysCourseApprovalService;

    @Autowired
    private SysCourseService sysCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('generator:syscourseapproval:list')")
    public R list(@RequestBody Map<String, Object> params, Principal principal) {
        PageUtils page = sysCourseApprovalService.queryPage(params, principal);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasAuthority('generator:syscourseapproval:info')")
    public R info(@PathVariable("id") Long id) {
        SysCourseApprovalEntity sysCourseApproval = sysCourseApprovalService.getById(id);

        return R.ok().put("sysCourseApproval", sysCourseApproval);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAuthority('generator:syscourseapproval:save')")
    public R save(@RequestBody SysCourseApprovalEntity sysCourseApproval, Principal principal) {
        sysCourseApproval.setApprovalStatu(1);
        sysCourseApproval.setStartTime(new Date());
        SysUser user = sysUserService.getByUsername(principal.getName());
        sysCourseApproval.setSponsorId(user.getId());
        sysCourseApproval.setStatu(1);
        sysCourseApprovalService.save(sysCourseApproval);
        SysCourseEntity courseEntity = new SysCourseEntity();
        courseEntity.setId(Long.valueOf(sysCourseApproval.getCourseId()));
        courseEntity.setCourseStatu(ApprovalStatusEnums.APPROVING.getStatus());
        sysCourseService.updateById(courseEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAuthority('generator:syscourseapproval:update')")
    public R update(@RequestBody SysCourseApprovalEntity sysCourseApproval) {
        sysCourseApproval.setEndTime(new Date());
        sysCourseApprovalService.updateById(sysCourseApproval);
        SysCourseEntity courseEntity = new SysCourseEntity();
        courseEntity.setId(Long.valueOf(sysCourseApproval.getCourseId()));
        courseEntity.setCourseStatu(sysCourseApproval.getApprovalStatu());
        sysCourseService.updateById(courseEntity);
        sysCourseApprovalService.sendMsg(sysCourseApproval);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('generator:syscourseapproval:delete')")
    public R delete(@RequestBody Long[] ids) {
        sysCourseApprovalService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
