package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Activatecode {

    private Long id;

    @TableField(value = "activationcode")
    private String activationcode;
}
