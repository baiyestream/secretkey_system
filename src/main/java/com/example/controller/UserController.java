package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.R;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user){
        // 获取密码
        String password = user.getPassword();
        // 根据提交的用户名查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User user1 = userService.getOne(queryWrapper);
        // 判断
        if(user1 == null){
            return R.error("登录失败");
        }
        if(!user1.getPassword().equals(password)){
            return R.error("登录失败");
        }

        request.getSession().setAttribute("user",user1.getId());
        return R.success(user1);
    }


    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清除Session中保存的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }

    /**
     * 用户管理模块信息查询
     * @param current 分页
     * @param size  分页条数
     * @param accountid  用户账号id
     * @return
     */
    @GetMapping("/search")
    public R<Page> search(int current,int size,int accountid){

        Page pageInfo = new Page(current,size);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        // 根据id查询
        queryWrapper.eq(User::getAccountid,accountid);
        queryWrapper.orderByAsc(User::getAccountid);

        userService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

}












