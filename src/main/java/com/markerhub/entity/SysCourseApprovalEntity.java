package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程审批表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-16 16:08:33
 */
@Data
@TableName("sys_course_approval")
public class SysCourseApprovalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 审批标题名
	 */
	private String title;
	/**
	 * 审批人ID
	 */
	private Long approverId;
	/**
	 * 发起人ID
	 */
	private Long sponsorId;
	/**
	 * 课程ID
	 */
	private String courseId;
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
