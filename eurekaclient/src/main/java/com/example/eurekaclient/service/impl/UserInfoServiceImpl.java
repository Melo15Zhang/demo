package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.dao.mapper.product.UserInfoMapper;
import com.example.eurekaclient.dto.UserInfoDto;
import com.example.eurekaclient.service.CommonService;
import com.example.eurekaclient.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends CommonService implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    // 失效时间
    private static final int USER_INFO_CACHE_EXPIRES = 2 * 3600;

    /**
     * 获取
     *
     * @param username
     * @return
     */
    @Override
    public UserInfoDto selectUserInfoDto(String username) {
        String key = getUserInfoCacheKey(username);
        UserInfoDto userInfoDto = this.redisClient.getObject(key, UserInfoDto.class);
        if (null == userInfoDto) {
            userInfoDto = selectUserInfoDB(username);
            if (userInfoDto != null) {
                this.redisClient.setObject(key, userInfoDto, USER_INFO_CACHE_EXPIRES);
            }
        }
        return userInfoDto;
    }

    /**
     * 获取-DB
     *
     * @param username
     * @return
     */
    private UserInfoDto selectUserInfoDB(String username) {
        return userInfoMapper.selectUserInfo(username);
    }
}
