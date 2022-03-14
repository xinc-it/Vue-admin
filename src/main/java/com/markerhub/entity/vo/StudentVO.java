package com.markerhub.entity.vo;

import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.SysUser;
import lombok.Data;

/**
 * Date：2022/3/11
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Data
public class StudentVO {

    private Long id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生编号
     */
    private String code;
    /**
     * 用户
     */
    private SysUser user;
    /**
     * 班级
     */
    private SysClassEntity classInfo;
    /**
     * 状态
     */
    private Integer statu;
}
