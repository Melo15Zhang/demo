package com.example.eurekaclient.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public class ResultFactory {

    private static final Map<Integer,Result> resultMap = new HashMap<>();

    public static Result getResult(int code){
        Result result = resultMap.get(code);

        if(result == null){
            result = new Result(code);
            resultMap.put(code,result);
            System.out.println("Create code = " + code + " result");
        }
        return result;
    }
}
