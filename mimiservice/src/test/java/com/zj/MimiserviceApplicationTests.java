package com.zj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ListSerializer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.mapper.ProductInfoMapper;
import com.zj.pojo.ProductInfo;
import com.zj.pojo.ProductType;
import com.zj.service.ProductInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MimiserviceApplicationTests {

    @Test
    public void contextLoads() {
 /*       List<ProductType> typeList1 = new ArrayList<>();
        typeList1.add(new ProductType());
        typeList1.add(new ProductType());
        typeList1.add(new ProductType());
        typeList1.add(new ProductType());
        typeList1.add(new ProductType());
        typeList1.add(new ProductType());
        List<ProductType> typeList = new ArrayList<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());


        redisTemplate.opsForList().range("typeList",0,1).size();
        System.out.println(typeList.size());*/
      /*  for (ProductType p: typeList
             ) {
            System.out.println(p);
        }*/

    }

}
