package com.zj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.zj.mapper.ProductTypeMapper;
import com.zj.pojo.ProductType;
import com.zj.service.ProductTypeService;
import org.apache.dubbo.config.annotation.DubboService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zj
 * @since 2022-02-09
 */
@DubboService(interfaceClass = ProductTypeService.class,version = "1.0")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public List<ProductType> getAll() {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            List redList =  redisTemplate.opsForList().range("typeList",0,-1);
            List<ProductType> typeList = null;
                if (redList.size()==0){
                    typeList = productTypeMapper.selectList(null);
                    redisTemplate.opsForList().rightPush("typeList",typeList);
                    System.out.println("从数据库取！");
                    return typeList;
                }


            typeList = (List<ProductType>) redList.get(0);
          /*  JSONArray parse = JSONObject.parseArray(json);
            typeList= parse.toJavaList(ProductType.class);*/
            System.out.println("从redis取！");
            return typeList;
    }
}
