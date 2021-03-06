package com.wangzhen.spbthymeleaflogin.miao.controller;

/**
 * @ClassName LoginController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/24 下午12:55
 **/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @PostMapping("login")
    public ModelAndView login(
            @RequestParam("loginNameRequestParm") String loginNameJavaVar,
            @RequestParam("password") String password,
            ModelAndView mv){
        System.out.println("LoginController login方法被调用......");
        System.out.println("LoginController 登录名:"+loginNameJavaVar + " 密码:" + password);
        // 重定向到到main请求
        mv.setViewName("redirect:/main");
        return mv;
    }
}
