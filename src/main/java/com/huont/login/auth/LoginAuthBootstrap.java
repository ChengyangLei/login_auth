package com.huont.login.auth;

import com.huont.login.auth.login.interceptor.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth
 * @date:2020-10-27
 */
@SpringBootApplication
public class LoginAuthBootstrap implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(LoginAuthBootstrap.class);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }
}
