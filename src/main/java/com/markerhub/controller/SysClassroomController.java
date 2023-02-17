package com.markerhub.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.markerhub.entity.SysClassroomEntity;
import com.markerhub.service.SysClassroomService;
import com.markerhub.utils.PageUtils;
import com.markerhub.utils.Query;
import com.markerhub.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * 教室表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-14 17:05:04
 */
@RestController
@RequestMapping("generator/sysclassroom")
public class SysClassroomController {
    @Autowired
    private SysClassroomService sysClassroomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('generator:sysclassroom:list')")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = sysClassroomService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/all")
    public R getAllClassRoom(){
        QueryWrapper<SysClassroomEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("statu",1);
        wrapper.select("*");
        List<SysClassroomEntity> list = sysClassroomService.list(wrapper);

        return R.ok().put("data", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasAuthority('generator:sysclassroom:info')")
    public R info(@PathVariable("id") Long id){
		SysClassroomEntity sysClassroom = sysClassroomService.getById(id);

        return R.ok().put("sysClassroom", sysClassroom);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAuthority('generator:sysclassroom:save')")
    public R save(@RequestBody SysClassroomEntity sysClassroom){
		sysClassroomService.save(sysClassroom);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAuthority('generator:sysclassroom:update')")
    public R update(@RequestBody SysClassroomEntity sysClassroom){
		sysClassroomService.updateById(sysClassroom);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('generator:sysclassroom:delete')")
    public R delete(@RequestBody Long[] ids){
		sysClassroomService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
