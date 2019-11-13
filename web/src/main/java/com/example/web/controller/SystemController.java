package com.example.web.controller;

import com.example.web.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemController {

    @Autowired
    ILoginService loginService;

    @GetMapping("/login")
    public ModelAndView index(@RequestParam(value = "username", defaultValue = "") String username,
                              @RequestParam(value = "password", defaultValue = "") String password) {
        int flag = loginService.login(username, password);
        if (flag == 1) {
            ModelAndView modelAndView = new ModelAndView("welcome");
            modelAndView.addObject("userName", username);
            return modelAndView;
        } else if (flag == 2) {
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("userName", username);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("sign-in");
            return modelAndView;
        }
    }

}
