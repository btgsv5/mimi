package com.zj.controller;


import com.zj.pojo.ProductType;
import com.zj.service.ProductTypeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zj
 * @since 2022-02-09
 */
@Controller
@RequestMapping("/productType")
public class ProductTypeController {
    @DubboReference(interfaceClass = ProductTypeService.class,version = "1.0")
    ProductTypeService productTypeService;

    @RequestMapping("/getAll")
    @ResponseBody
    public void getAll(HttpSession session){
        List<ProductType> typeList = (List<ProductType>) session.getAttribute("typeList");
        if (typeList==null){
             typeList = productTypeService.getAll();
        }
        session.setAttribute("typeList",typeList);
        System.out.println("监听typeList全局作用域！");


    }
}

