package com.example.web.service;

public interface ILoginService {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    int login(String username, String password);
}
