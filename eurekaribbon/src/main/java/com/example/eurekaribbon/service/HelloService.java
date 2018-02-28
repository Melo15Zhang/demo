package com.example.eurekaribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public String sayHello(String name){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKASERVERPROVIDER");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort()+"---------------------------");
        return  restTemplate.getForObject("http://EUREKASERVERPROVIDER/name/"+name,String.class);
    }
}
