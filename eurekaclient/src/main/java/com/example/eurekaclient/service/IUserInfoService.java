package com.example.eurekaclient.service;

import com.example.eurekaclient.dto.UserInfoDto;

public interface IUserInfoService {

    // 失效时间
    int USER_INFO_CACHE_EXPIRES = 2 * 3600;

    String USER_INFO_KEY = "userinfo:%s";

    /**
     * 分页获取
     *
     * @return
     */
    UserInfoDto selectUserInfoDto(String username);

    default String getUserInfoCacheKey(String username){
        return String.format(USER_INFO_KEY, username);
    }
}
