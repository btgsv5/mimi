package com.zj.controller;


import com.alibaba.fastjson.JSONObject;
import com.zj.pojo.ProductInfo;
import com.zj.pojo.vo.ProductInfoVo;
import com.zj.service.ProductInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import utils.FileNameUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/prod")
public class ProductInfoController{
    String saveFileName="";
    //每一页显示的记录数
    public static final int PAGE_SIZE = 5;

    @DubboReference(interfaceClass = ProductInfoService.class,version = "1.0")
    ProductInfoService productInfoService;

/*    @RequestMapping("/getAll")
    public void getAll(Model model){
        List<ProductInfo> list = productInfoService.getAll();
        model.addAttribute("list",list);
    }*/

    //显示第一页的五条记录
    @RequestMapping("/split")
    public String split(HttpSession session){
        //默认显示第一页的数据
       /* IPage info = productInfoService.splitPage(1,PAGE_SIZE);
        model.addAttribute("total",info.getTotal());*/
        System.out.println("进入到商品管理的页面");

        return "product";
    }

    @RequestMapping("/ajaxSplit")
    @ResponseBody
    public Map ajaxSplit(ProductInfoVo vo,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            System.out.println("进入到分页操作！");
            System.out.println(vo);
            if (session.getAttribute("vo")!=null){
                session.removeAttribute("vo");
            }

            List<ProductInfo> list = productInfoService.selectCondition(vo);
            int total = productInfoService.selectConditionCount(vo);

            session.setAttribute("info",list);
            Map map = new HashMap();
            map.put("total",total);
            map.put("list",list);

            return map;
    }

    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile pimage,HttpServletRequest request){
        saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        String path = System.getProperty("user.dir")+"\\mimiweb\\src\\main\\resources\\static\\image_big";
//        String path = request.getServletContext().getRealPath("/image_big");
/*        String path = request.getServletContext().getRealPath("");*/
        System.out.println(path);
        try {
             pimage.transferTo(new File(path+ File.separator+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }

    @RequestMapping("/save")
    public ModelAndView save(ProductInfo info, Model model){
        System.out.println("进入到添加商品的操作");
        info.setpImage(saveFileName);
        info.setpDate(LocalDate.now());
        ModelAndView mv = new ModelAndView();
        int num = productInfoService.save(info);
        if (num > 0){
            mv.addObject("msg","添加成功");
            //添加成功为redis添加数据
            productInfoService.save(info);
        }else{
            mv.addObject("msg","添加失败");
        }
        saveFileName = "";
        mv.setViewName("forward:/prod/split");
        return mv;
    }

    @RequestMapping("/one")
    public String one(Integer pid, ProductInfoVo vo, Model model,HttpSession session){
        ProductInfo info = productInfoService.getById(pid);
        model.addAttribute("prod",info);
        session.setAttribute("vo",vo);
        System.out.println("跳转到更新页面！");
        return "update";
    }

    @RequestMapping("/update")
    public String update(ProductInfo info,Model model){
        System.out.println("进入到更新商品的操作");
        if (!saveFileName.equals("")){
            info.setpImage(saveFileName);
        }
        try {
            int count = productInfoService.update(info);
            if (count>0){
                //更新成功后要进行一次全查询将数据放到redis
                model.addAttribute("msg","更新成功");
            }else {
                model.addAttribute("msg","更新失败");
            }
        }catch (Exception e){
            model.addAttribute("msg","商品正在订单中更新失败");
        }
        saveFileName = "";
        return "forward:/prod/split";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int pid){
        System.out.println("进入到删除单个商品操作");
        try{
            int count = productInfoService.delete(pid);
            if (count > 0){
                return "删除成功";
            }else {
                return "删除失败";
            }
        }catch (Exception e){
            return "商品处在订单中删除失败";
        }

    }

    @ResponseBody
    @RequestMapping("/deleteBatch")
    public String deleteBatch(String[] pids){
        System.out.println("进行批量删除操作pid"+pids[0]);
        int count = 0;
        try{
             count = productInfoService.deleteBatch(Arrays.asList(pids));
            if (count > 0){
                return "批量删除成功:"+count+"条";
            }
        }
        catch (Exception e){
            return "有商品处于订单状态批量删除失败:"+count+"条";
        }
        return "批量删除失败:"+count+"条";
    }


}

