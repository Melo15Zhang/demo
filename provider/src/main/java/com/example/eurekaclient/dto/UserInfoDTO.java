package com.example.eurekaclient.dto;

/**
 * UserInfoDTO
 */
public class UserInfoDTO {
    /**
     * 编号
     */
    private long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
