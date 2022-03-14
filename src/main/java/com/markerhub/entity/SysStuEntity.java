package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 15:23:43
 */
@Data
@TableName("sys_stu")
public class SysStuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学生id
	 */
	@TableId
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
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 班级ID
	 */
	private Long classId;
	/**
	 * 状态
	 */
	private Integer statu;

}
