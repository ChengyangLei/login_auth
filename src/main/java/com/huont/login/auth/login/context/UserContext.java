package com.huont.login.auth.login.context;


/**
 * @author:leichengyang
 * @desc:com.huont.login.auth.login.context
 * @date:2020-10-27
 */
public class UserContext {

    private static ThreadLocal<String> user=new ThreadLocal<>();

    public static void add(String username){
        user.set(username);
    }

    public static void remove(){
        user.remove();
    }


    public static String getCurrentUserName(){
        return user.get();
    }

}
