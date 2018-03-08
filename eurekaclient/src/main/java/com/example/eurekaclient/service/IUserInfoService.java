package com.example.eurekaclient.service;

import com.example.eurekaclient.dto.UserInfoDto;

public interface IUserInfoService {
    /**
     * 分页获取
     *
     * @return
     */
    UserInfoDto selectUserInfoDto(String username);
}
