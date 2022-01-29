package com.pxf.counting.controller;

import com.pxf.counting.dao.UserInfo;
import com.pxf.counting.serviceImp.UserloginServiceImp;
import com.pxf.counting.utill.Result;
import com.pxf.counting.utill.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @className: UserloginController
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/27 11:23
 * @version: 1.0
 */
@Slf4j
@RestController
public class UserloginController {
    @Autowired
    UserloginServiceImp userloginServiceImp;

    /**
     *查询用户信息
     *
     */
    @ResponseBody
    @RequestMapping(value = "/User/getUserInfo" )
    public Result selectUserInfo(@RequestBody UserInfo userInfo){
       return userloginServiceImp.selectUserInfo(userInfo);
    }

    /**
     *新增用户信息
     *
     */
    @ResponseBody
    @PostMapping(value = "/User/insertUserInfo" )
    public Result insertUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setId(UUIDUtil.getUuid());
        log.info("log输出userinfo =" +userInfo.toString());
        System.out.println(userInfo.toString());
        return userloginServiceImp.insertUserInfo(userInfo);
    }


    /**
     *修改用户信息
     *
     */
    @ResponseBody
    @PostMapping(value = "/User/updateUserInfo" )
    public Result udpdateUserInfo(@RequestBody UserInfo userInfo){
        log.info("log输出userinfo =" +userInfo.toString());
        System.out.println(userInfo.toString());
        return userloginServiceImp.udpdateUserInfo(userInfo);
    }

    /**
     *删除用户信息
     *
     */
    @ResponseBody
    @PostMapping(value = "/User/deleteUserInfo" )
    public Result deleteUserInfo(@RequestBody UserInfo userInfo){
        log.info("log输出userinfo =" +userInfo.toString());
        System.out.println(userInfo.toString());
        return userloginServiceImp.deleteUserInfo(userInfo);
    }

}
