package com.huont.login.auth.login.filter;

import com.huont.login.auth.login.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.filter
 * @date:2020-10-27
 *
 *
 * session存放用户登录信息使用此过滤器
 *
 */
//@Component
public class LoginFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //简单的白名单
        // 登录请求就放行
        if ("/login".equals(request.getRequestURI()) ||"/jwt/login".equals(request.getRequestURI())){
            filterChain.doFilter(request,response);
            return;
        }

        // 已登录就放行
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            filterChain.doFilter(request,response);
            return;
        }

        response.setContentType("json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("请先登录");
        writer.flush();
        writer.close();



    }
}
