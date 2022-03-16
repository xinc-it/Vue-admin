package com.markerhub.controller;

import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.SysRole;
import com.markerhub.service.SysCourseService;
import com.markerhub.utils.PageUtils;
import com.markerhub.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 课程表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-15 13:51:15
 */
@RestController
@RequestMapping("generator/syscourse")
public class SysCourseController extends BaseController {
    @Autowired
    private SysCourseService sysCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('generator:syscourse:list')")
    public R list(@RequestBody Map<String, Object> params,Principal principal) {
        PageUtils page = sysCourseService.queryPage(params,principal);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasAuthority('generator:syscourse:info')")
    public R info(@PathVariable("id") Long id) {
        SysCourseEntity sysCourse = sysCourseService.getById(id);

        return R.ok().put("sysCourse", sysCourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAuthority('generator:syscourse:save')")
    public R save(@RequestBody SysCourseEntity sysCourse) {
        sysCourseService.save(sysCourse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAuthority('generator:syscourse:update')")
    public R update(@RequestBody SysCourseEntity sysCourse) {
        sysCourseService.updateById(sysCourse);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('generator:syscourse:delete')")
    public R delete(@RequestBody Long[] ids) {
        sysCourseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
