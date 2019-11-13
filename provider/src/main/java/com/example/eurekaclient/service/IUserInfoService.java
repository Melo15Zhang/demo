package com.example.eurekaclient.service;

import com.example.eurekaclient.dto.UserInfoDTO;

public interface IUserInfoService {

    /**
     * 分页获取
     *
     * @return
     */
    UserInfoDTO selectUserInfoDto(String username);
}
