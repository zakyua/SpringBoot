package com.atguigu.springboot.mvc.Controller;

import com.atguigu.springboot.bean.User;
import com.atguigu.springboot.constant.AdminEXConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author ChenCheng
 * @create 2022-05-26 17:26
 */
@Controller
public class AdminController {
    /**
     *  去登录页面
     * @return
     */
    @GetMapping("/")
    public String adminLogin(){


        return "login";
    }


    /**
     *  处理登录的请求
     * @param user
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String Longin(User user, HttpSession session, Model model){
        // 1.从表单接收到user

        // 2.查询user是否有效
        if(user.getUserName() != null && user.getPassword().equals("123123")){
            // 3.将user保存到会话中
            session.setAttribute(AdminEXConstant.LOGIN_USER,user);
            // 登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";

        }else {
            model.addAttribute(AdminEXConstant.MSG,AdminEXConstant.MESSAGE);
            return "login";
        }



    }



    @RequestMapping("/main.html")
    public String redirectMain(HttpSession session,Model model){


//        Object user = session.getAttribute(AdminEXConstant.LOGIN_USER);
//        if(user != null ){
//            return "main";
//        }else {
//            // 登录失败!
//            model.addAttribute(AdminEXConstant.MSG,AdminEXConstant.MESSAGE);
//            return "login";
//        }

        return "main";

    }




}
