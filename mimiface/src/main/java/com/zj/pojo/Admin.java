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
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "a_id", type = IdType.AUTO)
      private Integer aId;

    private String aName;

    private String aPass;

    
    public Integer getaId() {
        return aId;
    }

      public void setaId(Integer aId) {
          this.aId = aId;
      }
    
    public String getaName() {
        return aName;
    }

      public void setaName(String aName) {
          this.aName = aName;
      }
    
    public String getaPass() {
        return aPass;
    }

      public void setaPass(String aPass) {
          this.aPass = aPass;
      }

    @Override
    public String toString() {
        return "Admin{" +
              "aId=" + aId +
                  ", aName=" + aName +
                  ", aPass=" + aPass +
              "}";
    }
}
