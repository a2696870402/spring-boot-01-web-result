package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class logincontroller {

//    @DeleteMapping
//    @RequestMapping
//    @GetMapping

    @PostMapping("/user/login")
    //相当于post的请求
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功,防止表单重复提交，可以重定向到主页
            //添加用户名到session中
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            map.put("msg","用户名密码错误");
            //登陆失败
            return "login";
        }
    }
}
