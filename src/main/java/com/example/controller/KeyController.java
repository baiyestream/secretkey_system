package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.R;
import com.example.entity.User;
import com.example.entity.Activate_information;
import com.example.entity.Applyname;
import com.example.entity.Platform;
import com.example.service.Activate_informationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/key")
public class KeyController {

    @Autowired
    private Activate_informationService activate_informationService;



    /**
     * 激活信息查询模块
     * @param current   分页
     * @param size  分页条数
     * @param accountid   用户账号ID
     * @param applynameID   应用名称ID
     * @param appplatformID   应用平台ID
     * @param status    激活状态
     * @return
     */
    @GetMapping("/search")
    public R<Page> search(int current,int size,int accountid,int applynameID,int appplatformID,int status){
        Page pageInfo = new Page(current,size);

        LambdaQueryWrapper<Activate_information>  queryWrapper = new LambdaQueryWrapper();
        LambdaQueryWrapper<User> queryWrapper1 = new LambdaQueryWrapper();
        LambdaQueryWrapper<Platform> queryWrapper2 = new LambdaQueryWrapper();
        LambdaQueryWrapper<Applyname> queryWrapper3 = new LambdaQueryWrapper();

        // 条件查询-> 用户ID
        queryWrapper1.eq(User::getAccountid,accountid);
        // 条件查询-> 应用平台ID
        queryWrapper2.eq(Platform::getAppplatformID,appplatformID);
        // 条件查询-> 应用名称ID
        queryWrapper3.eq(Applyname::getApplynameID,applynameID);
        // 条件查询-> status
        queryWrapper.eq(Activate_information::getStatus,status);


        queryWrapper.orderByAsc(Activate_information::getNickname);

        activate_informationService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

}
