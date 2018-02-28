package com.example.eurekaribbon.web;

import com.example.eurekaribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/{who}")
    public String sayHello(@PathVariable String who){
        return helloService.sayHello(who);
    }

}
