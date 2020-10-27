package com.huont.login.auth.api.controller;

import com.huont.login.auth.login.context.RequestContext;
import com.huont.login.auth.login.context.UserContext;
import com.huont.login.auth.login.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.api.controller
 * @date:2020-10-27
 */
@RestController
public class ApiController {

    @GetMapping("/api")
    public String api(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "请先登录";
        }
        return "请求api成功";
    }

    @GetMapping("/api2")
    public String api2(){
        return "请求api2成功，返回";
    }

    @GetMapping("/api3")
    public User api3(){
        User user = RequestContext.getUser();
        return user;
    }

    @GetMapping("/api4")
    public String api4(){
        return UserContext.getCurrentUserName()+ "请求api4成功,返回";
    }
}
