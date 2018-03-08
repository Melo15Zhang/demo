package com.example.eurekaclient.service;

import com.example.eurekaclient.common.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService{

    @Autowired
    protected RedisClient redisClient;

    private final static String USER_INFO_KEY = "userinfo:%s";

    public String getUserInfoCacheKey(String username){
        return String.format(USER_INFO_KEY, username);
    }

    public void delUserInfoCacheKey(String username){
        String key = getUserInfoCacheKey(username);
        redisClient.delete(key);
    }

}
