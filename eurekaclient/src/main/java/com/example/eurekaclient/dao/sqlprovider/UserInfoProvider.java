package com.example.eurekaclient.dao.sqlprovider;

public class UserInfoProvider {

    public String selectUserInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, username,password from userinfo where username = #{username}");
        return sb.toString();
    }
}