package com.example.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "fallback")
    public String sayHello(String name){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKASERVERPROVIDER");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort()+"---------------------------");
        return  restTemplate.getForObject("http://EUREKASERVERPROVIDER/name/"+name,String.class);
    }

    public String fallback(String name) {
        return "some exception occur call fallback method.";
    }
}
