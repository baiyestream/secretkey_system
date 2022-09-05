package com.example.entity;

import lombok.Data;
import java.util.Date;

/**
 * 激活信息实体类
 */
@Data
public class activation_information {

    private static final long serialVersionUID = 1L;

    //  主键ID
    private Long id;
    //  客户名称
    private String nickname;
    //  应用名称
    private String applyname;
    //  应用平台
    private String appplatform;
    //  imei1
    private Long imei1;
    //  imei2
    private Long imei2;
    //  激活码
    private String activationcode;
    //  状态 0:禁用 1：激活
    private Integer status;
    //  激活开始时间
    private Date beginTime;
    //  激活结束时间
    private Date endTime;
}
