package com.example.eurekaclient.controller;

import com.example.eurekaclient.common.Result;
import com.example.eurekaclient.dto.UserInfoDto;
import com.example.eurekaclient.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping(value ="/login")
    public UserInfoDto login(@RequestParam(value = "username",defaultValue = "") String username){
        if(null == username || "".equals(username)){
            Result.argResult("用户名参数有误");
        }
        UserInfoDto userInfoDto =  userInfoService.selectUserInfoDto(username);
        return userInfoDto;
    }
}