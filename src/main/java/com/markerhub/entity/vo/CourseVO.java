package com.markerhub.entity.vo;

import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.SysUser;
import lombok.Data;

/**
 * Date：2022/3/15
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Data
public class CourseVO {


    private Long id;
    /**
     * 课程编码
     */
    private String code;
    /**
     * 课程名
     */
    private String name;
    /**
     * 教师
     */
    private SysUser user;
    /**
     * 班级
     */
    private SysClassEntity classInfo;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 学期
     */
    private Integer semester;
    /**
     * 状态
     */
    private Integer statu;
    /**
     * 课程审批状态
     */
    private Long courseStatu;
}
