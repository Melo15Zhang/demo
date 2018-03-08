package com.example.web.controller;

import com.example.web.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemController {

    @Autowired
    ILoginService loginService;
    @RequestMapping("/login")
    public ModelAndView index(@RequestParam(value = "username",defaultValue = "") String username,
                              @RequestParam(value = "password",defaultValue = "") String password) {
        boolean flag = loginService.login(username,password);
        if (flag){
            ModelAndView modelAndView  = new ModelAndView("welcome");
            modelAndView.addObject("userName",username);
            return modelAndView;
        }else{
            ModelAndView modelAndView  = new ModelAndView("index");
            return modelAndView;
        }
    }

}
