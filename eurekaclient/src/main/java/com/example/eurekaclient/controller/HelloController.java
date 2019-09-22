package com.example.eurekaclient.controller;

import com.example.eurekaclient.common.Result;
import com.example.eurekaclient.common.StringUtil;
import com.example.eurekaclient.dto.UserInfoDTO;
import com.example.eurekaclient.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "spring.application")
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

    @Autowired
    IUserInfoService userInfoService;

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @RequestMapping(value ="/login")
    public UserInfoDTO login(@RequestParam(value = "username",defaultValue = "") String username){
        if(StringUtil.isNullOrEmpty(username)){
            Result.argResult("用户名参数有误");
        }
        System.out.println("index->" + index + "被访问---------------------------");
        UserInfoDTO userInfoDTO = userInfoService.selectUserInfoDto(username);
        return userInfoDTO;
    }
}