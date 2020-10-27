package com.huont.login.auth.login.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;

/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.util
 * @date:2020-10-27
 */
public class JwtUtil {

    /**
     * 这个秘钥是防止jwt被篡改的关键，随便设置，但不能泄露
     */
    private static final String secretKey="whatever";

    /**
     * 过期时间，根据需求自定义设置
     */
    private static Duration expiration=Duration.ofHours(2);


    public static String generateJwtToken(String username){
        Date expire = new Date(System.currentTimeMillis()+expiration.toMillis());
        return Jwts.builder()
                .setSubject(username)  //将username放进jwt
                .setIssuedAt(new Date())  //设置签发时间
                .setExpiration(expire)  //设置过期时间
                .signWith(SignatureAlgorithm.HS512,secretKey) //设置加密算法
                .compact();
    }


    public static Claims parseJwtToken(String token){
        if (StringUtils.isEmpty(token)){
            return null;
        }

        //因为可能解析失败，所以需要捕获异常
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (JwtException e) {
            e.printStackTrace();
        }
        return claims;
    }

}
