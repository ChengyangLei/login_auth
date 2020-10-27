package com.huont.login.auth.login.controller;

import com.huont.login.auth.login.entity.User;
import com.huont.login.auth.login.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.controller
 * @date:2020-10-27
 */
@RestController
public class JwtController {


    @PostMapping("/jwt/login")
    public String login(@RequestBody User user){
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            return JwtUtil.generateJwtToken(user.getUsername());
        }
        return "账号密码错误";
    }
}
