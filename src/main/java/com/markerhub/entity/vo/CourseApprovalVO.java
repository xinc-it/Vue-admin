package com.markerhub.entity.vo;

import com.markerhub.entity.SysClassEntity;
import com.markerhub.entity.SysCourseEntity;
import com.markerhub.entity.SysUser;
import lombok.Data;

import java.util.Date;

/**
 * Date：2022/3/16
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Data
public class CourseApprovalVO {

    private Long id;
    /**
     * 审批标题名
     */
    private String title;
    /**
     * 审批人ID
     */

    private SysUser approver;
    /**
     * 发起人ID
     */
    private SysUser sponsor;
    /**
     * 课程ID
     */

    private SysCourseEntity course;
    /**
     * 审批状态
     */
    private Integer approvalStatu;
    /**
     * 备注
     */
    private String remark;
    /**
     * 发起时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 状态
     */
    private Integer statu;
}
