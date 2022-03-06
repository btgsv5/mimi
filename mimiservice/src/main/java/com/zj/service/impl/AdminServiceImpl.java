package com.zj.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.mapper.AdminMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.pojo.Admin;
import com.zj.service.AdminService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import utils.MD5Util;

import java.util.List;

@DubboService(interfaceClass = AdminService.class,version = "1.0")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("a_name",name);
        List<Admin> list = adminMapper.selectList(queryWrapper);
        if (list.size()>0){
            Admin admin = list.get(0);
            String miPwd = MD5Util.getMD5(pwd);
            System.out.println(miPwd+"=========="+admin);
            if (miPwd.equals(admin.getaPass())){
                System.out.println("密码匹配！");
                return admin;
            }
        }
        return null;
    }
}
