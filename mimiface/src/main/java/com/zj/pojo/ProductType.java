package com.zj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "type_id", type = IdType.AUTO)
      private Integer typeId;

    private String typeName;

    public ProductType() {

    }

    public Integer getTypeId() {
        return typeId;
    }

      public void setTypeId(Integer typeId) {
          this.typeId = typeId;
      }
    
    public String getTypeName() {
        return typeName;
    }

      public void setTypeName(String typeName) {
          this.typeName = typeName;
      }

    @Override
    public String toString() {
        return "ProductType{" +
              "typeId=" + typeId +
                  ", typeName=" + typeName +
              "}";
    }
}
