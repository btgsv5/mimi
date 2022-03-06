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
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "odid", type = IdType.AUTO)
      private Integer odid;

    private String oid;

    private Integer pid;

    private Integer pnumber;

    private Double ptotal;

    
    public Integer getOdid() {
        return odid;
    }

      public void setOdid(Integer odid) {
          this.odid = odid;
      }
    
    public String getOid() {
        return oid;
    }

      public void setOid(String oid) {
          this.oid = oid;
      }
    
    public Integer getPid() {
        return pid;
    }

      public void setPid(Integer pid) {
          this.pid = pid;
      }
    
    public Integer getPnumber() {
        return pnumber;
    }

      public void setPnumber(Integer pnumber) {
          this.pnumber = pnumber;
      }
    
    public Double getPtotal() {
        return ptotal;
    }

      public void setPtotal(Double ptotal) {
          this.ptotal = ptotal;
      }

    @Override
    public String toString() {
        return "Orderdetail{" +
              "odid=" + odid +
                  ", oid=" + oid +
                  ", pid=" + pid +
                  ", pnumber=" + pnumber +
                  ", ptotal=" + ptotal +
              "}";
    }
}
