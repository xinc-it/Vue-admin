package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教室表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-14 17:05:04
 */
@Data
@TableName("sys_classroom")
public class SysClassroomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 教室ID
	 */
	@TableId
	private Long id;
	/**
	 * 编号
	 */
	private String code;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 地点
	 */
	private String site;
	/**
	 * 状态
	 */
	private Integer statu;
	/**
	 * 管理员ID
	 */
	private Long userId;

}
