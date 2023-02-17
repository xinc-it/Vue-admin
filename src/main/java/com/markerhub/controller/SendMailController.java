package com.markerhub.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.markerhub.entity.SysClassroomEntity;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.SysStuEntity;
import com.markerhub.entity.SysUser;
import com.markerhub.service.*;
import com.markerhub.service.impl.MailService;
import com.markerhub.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试邮件发送
 * @author qzz
 */
@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private MailService mailService;


    @Autowired
    private SysStuService sysStuService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysClassroomService sysClassroomService;
    @Autowired
    private SysCourseService sysCourseService;

    /**
     * 发送文本邮件
     * @param id
     */
    @RequestMapping("/sendTextMail/{id}")
    public R sendTextMail(@PathVariable("id")String  id){
        SysCourseEntity courseEntity = sysCourseService.getById(id);
        List<SysStuEntity> stuEntityList = sysStuService.getStuInfoByClass(courseEntity.getClassId());
        String to=getEmailAddress(stuEntityList);
        String courseName = courseEntity.getName();
        String subject="关于"+courseName+"课程提醒";
        String text=buildText(courseEntity);
        mailService.sendTextMailMessage(to,subject,text);
        return R.ok();
    }

    private String buildText(SysCourseEntity courseEntity) {
        Long teacherId = courseEntity.getTeacherId();
        String teacherName = sysUserService.getById(teacherId).getUsername();
        Integer classroomId = courseEntity.getClassroomId();
        QueryWrapper<SysClassroomEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", classroomId);
        SysClassroomEntity classroomEntity = sysClassroomService.getOne(wrapper);
        String classroomEntityName = classroomEntity.getName();
        String classroomEntitySite = classroomEntity.getSite();
        Date startTime = courseEntity.getStartTime();
        Date endTime = courseEntity.getEndTime();
        String startFormat = DateUtil.format(startTime, "yyyy-MM-dd HH:mm:ss");
        String endFormat = DateUtil.format(endTime, "yyyy-MM-dd HH:mm:ss");
        StringBuilder textBuilder=new StringBuilder();
        textBuilder.append("课程名:"+courseEntity.getName()+"\n");
        textBuilder.append("上课时间:"+startFormat+"-"+endFormat+"\n");
        textBuilder.append("上课地点:"+classroomEntitySite+"\n");
        textBuilder.append("上课实验室名:"+classroomEntityName+"\n");
        textBuilder.append("教师名:"+teacherName+"\n");
        return textBuilder.toString();
    }


    private String  getEmailAddress(List<SysStuEntity> stuEntityList) {
        List<Long> userIdList=new ArrayList<>();
        for (SysStuEntity sysStuEntity : stuEntityList) {
            userIdList.add(sysStuEntity.getUserId());
        }
        QueryWrapper<SysUser> wrapper=new QueryWrapper();
        wrapper.select("email");
        wrapper.in("id",userIdList );
        List<SysUser> list = sysUserService.list(wrapper);
        StringBuilder subjectBuilder=new StringBuilder();
        for (SysUser sysUser : list) {
             String email = sysUser.getEmail();
            subjectBuilder.append(email+",");
        }
        return subjectBuilder.toString();
    }


}

