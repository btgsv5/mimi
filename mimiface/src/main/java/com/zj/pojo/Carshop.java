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
public class Carshop implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "cid", type = IdType.AUTO)
      private Integer cid;

    private Integer uid;

    private Integer pid;

    private Integer numbers;

    
    public Integer getCid() {
        return cid;
    }

      public void setCid(Integer cid) {
          this.cid = cid;
      }
    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public Integer getPid() {
        return pid;
    }

      public void setPid(Integer pid) {
          this.pid = pid;
      }
    
    public Integer getNumbers() {
        return numbers;
    }

      public void setNumbers(Integer numbers) {
          this.numbers = numbers;
      }

    @Override
    public String toString() {
        return "Carshop{" +
              "cid=" + cid +
                  ", uid=" + uid +
                  ", pid=" + pid +
                  ", numbers=" + numbers +
              "}";
    }
}
