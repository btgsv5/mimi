package com.zj.pojo.vo;

import java.io.Serializable;

public class ProductInfoVo implements Serializable {
    //商品名称
    private  String pName;

    //商品类型
    private  Integer typeId;

    //最低价格
    private Double lPrice;

    //最高价格
    private Double hPrice;

    //当前页码
    private Integer page;

    public ProductInfoVo() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ProductInfoVo(String pName, Integer typeId, Double lPrice, Double hPrice, Integer page) {
        this.pName = pName;
        this.typeId = typeId;
        this.lPrice = lPrice;
        this.hPrice = hPrice;
        this.page = page;
    }

    @Override
    public String toString() {
        return "ProductInfoVo{" +
                "pName='" + pName + '\'' +
                ", typeId=" + typeId +
                ", lPrice=" + lPrice +
                ", hPrice=" + hPrice +
                ", page=" + page +
                '}';
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getlPrice() {
        return lPrice;
    }

    public void setlPrice(Double lPrice) {
        this.lPrice = lPrice;
    }

    public Double gethPrice() {
        return hPrice;
    }

    public void sethPrice(Double hPrice) {
        this.hPrice = hPrice;
    }


}
