package com.zj.service;

import com.zj.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zj
 * @since 2022-02-09
 */
public interface AdminService  {
    Admin login(String name, String pwd);
}
