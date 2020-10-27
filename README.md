# login_auth

#登录的简单实现
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session){
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            session.setAttribute("user",user);
            return "登录成功";
        }
        return "登录失败,账号或者密码错误";
    }
    