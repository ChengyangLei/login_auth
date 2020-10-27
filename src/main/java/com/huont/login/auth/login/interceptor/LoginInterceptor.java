package com.huont.login.auth.login.interceptor;

import com.huont.login.auth.login.context.UserContext;
import com.huont.login.auth.login.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.interceptor
 * @date:2020-10-27
 *
 * jwt 存放登录信息使用此拦截器
 *
 */
//@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/login".equals(request.getRequestURI()) || "/jwt/login".equals(request.getRequestURI())){
            return true;
        }

        Claims claims = JwtUtil.parseJwtToken(request.getHeader("Authorization"));
        if (claims!=null){
            UserContext.add(claims.getSubject());
            return true;
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("json");
        PrintWriter writer = response.getWriter();
        writer.write("请先登录");
        writer.flush();
        writer.close();

        return false;
    }

    /**
     * 请求结束后，从上下文中删除数据，如果不删除可能会导致内存泄露
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
