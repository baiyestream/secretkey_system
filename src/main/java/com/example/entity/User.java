package com.example.entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;
    // 昵称
    private String nickname;
    // ID
    private Integer accountid;
    // 账号
    private String username;
    // 密码
    private String password;
    // 权限： 0：用户 1：管理员
    private Integer jurisdiction;
    // 激活： 0：禁用 1：激活
    private Integer status;
}
