package com.example.entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private Integer jurisdiction;
}
