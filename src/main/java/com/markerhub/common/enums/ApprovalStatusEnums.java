package com.markerhub.common.enums;

import lombok.Getter;

/**
 * Date：2022/3/16
 * Description：TODO
 *
 * @author xinC
 * @version 1.0
 */
public enum ApprovalStatusEnums {
    NOT_APPROVED("未审批",0),
    APPROVING("审批中",1),
    Approved("审批通过",2),
    APPROVAL_FAILED("审批未通过",3),
    ;
    @Getter
    private String msg;
    @Getter
    private Integer status;


    ApprovalStatusEnums(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }
}
