package com.markerhub.entity.vo;

import com.markerhub.entity.SysUser;
import lombok.Data;

/**
 * Date：2022/3/14
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Data
public class ClassroomVO {

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

    private SysUser user;
}
