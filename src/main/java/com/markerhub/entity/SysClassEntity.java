package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 班级表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-11 13:38:08
 */
@Data
@TableName("sys_class")
public class SysClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 班级ID
	 */
	@TableId
	private Long id;
	/**
	 * 班级code
	 */
	private String code;
	/**
	 * 班级名
	 */
	private String name;
	/**
	 * 状态
	 */
	private Integer statu;

}
