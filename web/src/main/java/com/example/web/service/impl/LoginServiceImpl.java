package com.example.web.service.impl;

import com.example.web.config.SystemConfig;
import com.example.web.dto.UserInfoDto;
import com.example.web.service.ILoginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    SystemConfig systemConfig;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public int login(String username,String password) {
        String param = String.format("?username=%s&password=%s&flag=%b",username,password,true);
        ResponseEntity<UserInfoDto> responseEntity = restTemplate.getForEntity(systemConfig.getLoginUrl()+param,UserInfoDto.class);
        System.out.println("param="+param);
        UserInfoDto userInfoDto = responseEntity.getBody();
        if(null != userInfoDto && userInfoDto.getPassword().equals(password)){
            return 1;
        }
        return 2;
    }

    public int fallback(String name,String password) {
        return 0;
    }
}
