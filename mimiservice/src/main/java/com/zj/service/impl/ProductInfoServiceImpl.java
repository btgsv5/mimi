package com.zj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zj.mapper.ProductInfoMapper;
import com.zj.pojo.ProductInfo;
import com.zj.pojo.vo.ProductInfoVo;
import com.zj.service.ProductInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = ProductInfoService.class,version = "1.0")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Resource
    RedisTemplate redisTemplate;
    @Override
    public List<ProductInfo> getAll() {
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        return productInfoMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<ProductInfo> splitPage(Integer pageNum, Integer pageSize) {
        IPage<ProductInfo> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("p_id");

        IPage<ProductInfo> pageInfo = productInfoMapper.selectPage(page,queryWrapper);

        //获取分页后的记录
        //List<ProductInfo> productInfos = pageInfo.getRecords();
        //总共多少页数
/*        long pages = result.getPages();
        //记录数
        long totals = result.getTotal();*/
        return pageInfo;
    }

    //添加数据
    @Override
    public int save(ProductInfo info) {
        int count = productInfoMapper.insert(info);

        return count;
    }

    @Override
    public ProductInfo getById(Integer pid) {
        return productInfoMapper.selectById(pid);
    }

    //更新数据
    @Override
    public int update(ProductInfo info)
    {   int count = productInfoMapper.updateById(info);

        return count;
    }

    @Override
    public int delete(Integer pid) {
        int count = productInfoMapper.deleteById(pid);

        return count;
    }

    @Transactional
    @Override
    public int deleteBatch(List<String> ids) throws Exception{
        int count = productInfoMapper.deleteBatchIds(ids);

        return count;
    }

    @Override
    public List<ProductInfo> selectCondition(ProductInfoVo vo) {
        //计算当前跳过条数
            Integer page = vo.getPage();
            page = (page-1)*5;
            vo.setPage(page);

        return productInfoMapper.selectCondition(vo);
    }

    @Override
    public int selectConditionCount(ProductInfoVo vo) {
        return productInfoMapper.selectConditionCount(vo);
    }



}
