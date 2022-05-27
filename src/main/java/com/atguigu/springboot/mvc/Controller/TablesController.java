package com.atguigu.springboot.mvc.Controller;

import com.atguigu.springboot.Service.UserService;
import com.atguigu.springboot.bean.User;
import com.atguigu.springboot.mvc.Interceptor.LoginInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.jdbc.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenCheng
 * @create 2022-05-26 18:56
 */
@Controller
public class TablesController {



    @Autowired
    private UserService userService;


    @RequestMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }



    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model model){
        //表格内容的遍历
//        response.sendError
//     List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123444"),
//                new User("haha", "aaaaa"),
//                new User("hehe ", "aaddd"));
//        model.addAttribute("users",users);
//
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        //从数据库中查出user表中的用户进行展示

        //构造分页参数
        Page<User> page = new Page<>(pn, 2);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);


//        userPage.getRecords()
//        userPage.getCurrent()
//        userPage.getPages()


        model.addAttribute("users",userPage);

        return "table/dynamic_table";
    }

    @RequestMapping("/pricing_table")
    public String pricingTable(){
        return "pricing_table";
    }







}
