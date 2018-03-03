package com.example.eurekaclient.service;

import com.example.eurekaclient.common.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService{

    @Autowired
    RedisClient redisClient;

    private final static String STUDENT_KEY = "student:pageindex:%d";

    public String getStudentCacheKey(int pageSize){
        return String.format(STUDENT_KEY, pageSize);
    }
}
