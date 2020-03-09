package com.example.springboot.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    //自定义处理异常
//    @ResponseBody
//    @ExceptionHandler(UserPrincipalNotFoundException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code:","user.PrincipalNotFound");
//        map.put("message:",e.toString());
//        return map;
//    }
//自定义处理异常

    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public String handleException(Exception e, HttpServletRequest request) {
//(Integer)request.getAttribute("javax.servlet.error.status_code");
        //设置自己的状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.PrincipalNotFound");
        map.put("h1","aaaa");
        map.put("message", e.toString());
        //我们需要把map放到request中，才可以带走

        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
