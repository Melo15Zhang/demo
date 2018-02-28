package com.example.eurekaclient.controller;

import com.example.eurekaclient.common.Result;
import com.example.eurekaclient.dto.StudentDto;
import com.example.eurekaclient.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    IStudentService sStudentService;

    @RequestMapping(value ="/name/{who}")
    @ResponseBody
    public Result sayHello(@PathVariable String who){
        String returnStr = "Hey "+who+", what's up man!";
        return Result.successResult(returnStr);
    }

    @RequestMapping(value ="/dbtest")
    @ResponseBody
    public Result dbtest(@RequestParam(value = "offset",defaultValue = "-1") int offset,
                         @RequestParam(value = "pageSize",defaultValue = "-1")  int pageSize){
        if(offset == -1){
            Result.argResult();
        }

        if(pageSize == -1){
            Result.argResult();
        }

        try{
            List<StudentDto> list = sStudentService.selectStudentList(offset,pageSize);
            return Result.successResult(list);
        }catch(Exception e){
            return Result.serverResult();
        }
    }
}