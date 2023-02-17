package com.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Const;
import com.markerhub.entity.SysCourseApprovalEntity;
import com.markerhub.entity.SysRole;
import com.markerhub.entity.SysUser;
import com.markerhub.entity.vo.CourseApprovalVO;
import com.markerhub.mapper.SysCourseApprovalMapper;
import com.markerhub.service.SysCourseApprovalService;
import com.markerhub.service.SysUserService;
import com.markerhub.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("sysCourseApprovalService")
public class SysCourseApprovalServiceImpl extends ServiceImpl<SysCourseApprovalMapper, SysCourseApprovalEntity> implements SysCourseApprovalService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysCourseApprovalMapper courseApprovalMapper;
    @Autowired
    private MailService mailService;


    @Override
    public PageUtils queryPage(Map<String, Object> params, Principal principal) {
        Integer limit = (Integer) params.get("limit");
        Integer pageNum = (Integer) params.get("page");
        Page<CourseApprovalVO> page = new Page<>(pageNum, limit);
        Object key = params.get("key");
        String name = principal.getName();
        SysUser user = sysUserService.getUserRoleByName(name);
        List<SysRole> sysRoles = user.getSysRoles();
        if (SysUserService.userIsManager(sysRoles)) {
            page = courseApprovalMapper.getAllCourseApproval(page, key);

        } else {
            page = courseApprovalMapper.getCourseApprovalByUserId(page, key, user.getId());
        }
        return new PageUtils(page);
    }


    @Override
    public void sendMsg(SysCourseApprovalEntity sysCourseApproval) {

        SysUser sponsor = sysUserService.getById(sysCourseApproval.getSponsorId());
        String text=sysCourseApproval.getApprovalStatu()==2? Const.APPROVAL_SUCCESS:Const.APPROVAL_FAIL;
        mailService.sendTextMailMessage(sponsor.getEmail(),sysCourseApproval.getTitle()+"审批结果" ,text);
    }
}