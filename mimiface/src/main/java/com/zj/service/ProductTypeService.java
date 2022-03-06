package com.zj.service;

import com.zj.pojo.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProductTypeService  {
    List<ProductType> getAll();
}
