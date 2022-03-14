package com.markerhub.controller;

import java.util.Arrays;
import java.util.Map;

import com.markerhub.entity.SysStuEntity;
import com.markerhub.service.SysStuService;
import com.markerhub.utils.PageUtils;
import com.markerhub.utils.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 学生信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 15:23:43
 */
@RestController
@RequestMapping("generator/sysstu")
public class SysStuController {
    @Autowired
    private SysStuService sysStuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('generator:sysstu:list')")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = sysStuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasAuthority('generator:sysstu:info')")
    public R info(@PathVariable("id") Long id){
		SysStuEntity sysStu = sysStuService.getById(id);

        return R.ok().put("sysStu", sysStu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAuthority('generator:sysstu:save')")
    public R save(@RequestBody SysStuEntity sysStu){
		sysStuService.save(sysStu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAuthority('generator:sysstu:update')")
    public R update(@RequestBody SysStuEntity sysStu){
		sysStuService.updateById(sysStu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('generator:sysstu:delete')")
    public R delete(@RequestBody Long[] ids){
		sysStuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
