package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.common.RedisClient;
import com.example.eurekaclient.dao.mapper.product.UserInfoMapper;
import com.example.eurekaclient.dto.UserInfoDto;
import com.example.eurekaclient.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    RedisClient redisClient;

    /**
     * 获取
     *
     * @param username
     * @return
     */
    @Override
    public UserInfoDto selectUserInfoDto(String username) {
        String key = getUserInfoCacheKey(username);
        UserInfoDto userInfoDto = redisClient.getObject(key, UserInfoDto.class);
        if (null == userInfoDto) {
            userInfoDto = selectUserInfoDB(username);
            if (userInfoDto != null) {
                redisClient.setObject(key, userInfoDto, USER_INFO_CACHE_EXPIRES);
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
