package com.huont.login.auth.login.controller;

import com.huont.login.auth.login.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.controller
 * @date:2020-10-27
 */
@RestController
public class SessionController {

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session){
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            session.setAttribute("user",user);
            return "登录成功";
        }
        return "登录失败,账号或者密码错误";
    }
}
