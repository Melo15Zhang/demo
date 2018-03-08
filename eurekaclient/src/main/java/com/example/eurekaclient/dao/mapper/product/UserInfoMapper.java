package com.example.eurekaclient.dao.mapper.product;

import com.example.eurekaclient.dao.sqlprovider.UserInfoProvider;
import com.example.eurekaclient.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserInfoMapper {

    /**
     * 查询用户
     *
     * @return
     */
    @SelectProvider(type = UserInfoProvider.class, method = "selectUserInfo")
    UserInfoDto selectUserInfo(@Param("username") String username);
}
