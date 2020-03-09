package com.example.springboot.controller;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.concurrent.ExecutionException;


@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) throws UserPrincipalNotFoundException {
        if("aaa".equals(user)){
            throw new UserPrincipalNotFoundException(user);
        }
        return "hello world";
    }
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "success";
//    }


}
