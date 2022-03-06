package com.zj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.pojo.ProductInfo;
import com.zj.pojo.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> selectCondition(ProductInfoVo vo);

    int selectConditionCount(ProductInfoVo vo);
}
