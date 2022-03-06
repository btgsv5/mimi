package com.zj.controller;



import com.zj.pojo.Admin;
import com.zj.service.AdminService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    //引用远程服务，把创建好的代理对象注入给AdminService
    @DubboReference(interfaceClass = AdminService.class,version = "1.0")
    AdminService adminService;


    @RequestMapping("/login")
    public String login(String name, String pwd, HttpSession session){
        Admin admin = adminService.login(name,pwd);
        if (admin!=null){
            session.setAttribute("admin",admin);
            return "main";
        }
        session.setAttribute("errmsg","用户名或密码不正确");
        return "login";
    }

    @RequestMapping("/addproduct")
    public String addproduct(){
        return "addproduct";
    }
}

