package com.markerhub.entity.vo;

import lombok.Data;

/**
 * Date：2022/3/11
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
@Data
public class ClassVO {

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

    private Integer nums;
}
