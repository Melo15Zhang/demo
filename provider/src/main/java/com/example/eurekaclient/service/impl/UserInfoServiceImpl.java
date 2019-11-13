package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.dao.mapper.product.UserInfoMapper;
import com.example.eurekaclient.dto.UserInfoDTO;
import com.example.eurekaclient.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 获取
     *
     * @param username
     * @return
     */
    @Override
    public UserInfoDTO selectUserInfoDto(String username) {
        UserInfoDTO userInfoDTO = userInfoMapper.selectUserInfo(username);
        return userInfoDTO;
    }
}
