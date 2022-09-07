package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.R;
import com.example.entity.Applyname;
import com.example.service.ApplynameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/file")
public class ApplynameController {

    @Autowired
    private ApplynameService applynameService;

    /**
     * 激活信息-选择信息接口
     * @param applyname
     * @return
     */
    /*
    @GetMapping("/list")
    public List<Applyname> list(@RequestBody Applyname applyname){

        LambdaQueryWrapper<Applyname> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Applyname::getApplyname,applyname);
        return applynameService.list(queryWrapper);
    }
     */

    @GetMapping("/list1")
    public R<List> list(Applyname applyname){
        LambdaQueryWrapper<Applyname> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Applyname::getApplyname,applyname.getApplyname());
        List<Applyname> list = applynameService.list(queryWrapper);
        return R.success(list);
    }

    @GetMapping("/list2")
    public R<List> list(String applyname){
        LambdaQueryWrapper<Applyname> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Applyname::getApplyname,applyname);
        List<Applyname> list = applynameService.list(queryWrapper);
        return R.success(list);
    }
}
