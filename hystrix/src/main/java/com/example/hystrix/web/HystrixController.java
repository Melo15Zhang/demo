package com.example.hystrix.web;

import com.example.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    private HystrixService service;
    /**
     * 调用依赖的服务
     */
    @RequestMapping("/{who}")
    public String callSayHello(@PathVariable String who){
        return service.callSayHello(who);
    }
}
