package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-15 13:51:15
 */
@Data
@TableName("sys_course")
public class SysCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 课程ID
	 */
	@TableId
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
	 * 教师ID
	 */
	private Long teacherId;
	/**
	 * 班级ID
	 */
	private Long classId;
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

	private  Integer courseStatu;

	private  Date startTime;

	private Date endTime;

	private Integer classroomId;
}
