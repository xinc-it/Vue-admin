package com.markerhub.controller;

import com.markerhub.entity.SysClassEntity;
import com.markerhub.service.SysClassService;
import com.markerhub.utils.PageUtils;
import com.markerhub.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 班级表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 13:38:08
 */
@RestController
@RequestMapping("generator/sysclass")
public class SysClassController {
    @Autowired
    private SysClassService sysClassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('generator:sysclass:list')")
    public R list(@RequestBody Map<String, Object> params) {
        PageUtils page = sysClassService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasAuthority('generator:sysclass:info')")
    public R info(@PathVariable("id") Long id) {
        SysClassEntity sysClass = sysClassService.getById(id);

        return R.ok().put("sysClass", sysClass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAuthority('generator:sysclass:save')")
    public R save(@RequestBody SysClassEntity sysClass) {
        sysClassService.save(sysClass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAuthority('generator:sysclass:update')")
    public R update(@RequestBody SysClassEntity sysClass) {
        sysClassService.updateById(sysClass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('generator:sysclass:delete')")
    public R delete(@RequestBody Long[] ids) {
        sysClassService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/all")
    public R allClass() {
        List<SysClassEntity> allClass = sysClassService.getAllClass();
        return R.ok().put("data", allClass);
    }

}
