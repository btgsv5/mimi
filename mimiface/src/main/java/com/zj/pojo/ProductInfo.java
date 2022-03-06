package com.zj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zj
 * @since 2022-02-09
 */
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "p_id", type = IdType.AUTO)
      private Integer pId;

    private String pName;

    private String pContent;

    private Integer pPrice;

    private String pImage;

    private Integer pNumber;

    private Integer typeId;

    private LocalDate pDate;

    
    public Integer getpId() {
        return pId;
    }

      public void setpId(Integer pId) {
          this.pId = pId;
      }
    
    public String getpName() {
        return pName;
    }

      public void setpName(String pName) {
          this.pName = pName;
      }
    
    public String getpContent() {
        return pContent;
    }

      public void setpContent(String pContent) {
          this.pContent = pContent;
      }
    
    public Integer getpPrice() {
        return pPrice;
    }

      public void setpPrice(Integer pPrice) {
          this.pPrice = pPrice;
      }
    
    public String getpImage() {
        return pImage;
    }

      public void setpImage(String pImage) {
          this.pImage = pImage;
      }
    
    public Integer getpNumber() {
        return pNumber;
    }

      public void setpNumber(Integer pNumber) {
          this.pNumber = pNumber;
      }
    
    public Integer getTypeId() {
        return typeId;
    }

      public void setTypeId(Integer typeId) {
          this.typeId = typeId;
      }
    
    public LocalDate getpDate() {
        return pDate;
    }

      public void setpDate(LocalDate pDate) {
          this.pDate = pDate;
      }

    @Override
    public String toString() {
        return "ProductInfo{" +
              "pId=" + pId +
                  ", pName=" + pName +
                  ", pContent=" + pContent +
                  ", pPrice=" + pPrice +
                  ", pImage=" + pImage +
                  ", pNumber=" + pNumber +
                  ", typeId=" + typeId +
                  ", pDate=" + pDate +
              "}";
    }
}
