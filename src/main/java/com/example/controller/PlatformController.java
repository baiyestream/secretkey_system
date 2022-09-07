package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.R;
import com.example.entity.Platform;
import com.example.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    /**
     * 激活信息-应用平台接口
     */

    @GetMapping("/list")
    public R<List> list(Platform platform){
        LambdaQueryWrapper<Platform> queryWrapper = new LambdaQueryWrapper<>();
        List<Platform> list = platformService.list(queryWrapper);
        return R.success(list);
    }

}
