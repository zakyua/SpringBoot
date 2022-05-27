package com.atguigu.springboot.mvc.Interceptor;

import com.atguigu.springboot.constant.AdminEXConstant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录的拦截器
 * @author ChenCheng
 * @create 2022-05-27 9:13
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute(AdminEXConstant.LOGIN_USER);
        if(loginUser != null){
            return true;
        }


        // 拦截
        request.setAttribute(AdminEXConstant.MSG,AdminEXConstant.MESSAGE);
        // 拦截后让它去登录的主页面
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
