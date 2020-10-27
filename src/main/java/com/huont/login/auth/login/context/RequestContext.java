package com.huont.login.auth.login.context;

import com.huont.login.auth.login.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.context
 * @date:2020-10-27
 */
public class RequestContext {

    public static HttpServletRequest getCurrentRequest(){
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static User getUser(){
        return (User) getCurrentRequest().getSession().getAttribute("user");
    }
}
