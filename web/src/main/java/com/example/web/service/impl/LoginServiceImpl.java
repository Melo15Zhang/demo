package com.example.web.service.impl;

import com.example.web.dto.UserInfoDto;
import com.example.web.service.ILoginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements ILoginService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public boolean login(String username,String password) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKASERVERPROVIDER");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort()+"---------------------------");
        String param = String.format("?username=%s&password=%s",username,password);
        ResponseEntity<UserInfoDto> responseEntity = restTemplate.getForEntity("http://EUREKASERVERPROVIDER/login"+param,UserInfoDto.class);
        UserInfoDto userInfoDto = responseEntity.getBody();
        if(null != userInfoDto && userInfoDto.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean fallback(String name,String password) {
        return false;
    }
}
