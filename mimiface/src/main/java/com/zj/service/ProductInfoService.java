package com.zj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zj.pojo.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.pojo.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoService  {
    List<ProductInfo> getAll();

    //坑人分页看一次打一次字
    IPage<ProductInfo> splitPage(Integer pageNum,Integer pageSize);

    int save(ProductInfo info);

    ProductInfo getById(Integer pid);

    int update(ProductInfo info);

    int delete(Integer pid);

    int deleteBatch(List<String> ids) throws Exception;

    //多条件查询分页
    List<ProductInfo> selectCondition(ProductInfoVo vo);

    //查询分页总条数
    int selectConditionCount(ProductInfoVo vo);
}
