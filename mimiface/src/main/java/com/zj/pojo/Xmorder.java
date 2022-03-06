package com.zj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zj
 * @since 2022-02-09
 */
public class Xmorder implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "oid", type = IdType.AUTO)
      private String oid;

    private Integer uid;

    @TableField("addressId")
    private Integer addressid;

    private Double totalprice;

    private String remarks;

    private String status;

    private LocalDateTime odate;

    
    public String getOid() {
        return oid;
    }

      public void setOid(String oid) {
          this.oid = oid;
      }
    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public Integer getAddressid() {
        return addressid;
    }

      public void setAddressid(Integer addressid) {
          this.addressid = addressid;
      }
    
    public Double getTotalprice() {
        return totalprice;
    }

      public void setTotalprice(Double totalprice) {
          this.totalprice = totalprice;
      }
    
    public String getRemarks() {
        return remarks;
    }

      public void setRemarks(String remarks) {
          this.remarks = remarks;
      }
    
    public String getStatus() {
        return status;
    }

      public void setStatus(String status) {
          this.status = status;
      }
    
    public LocalDateTime getOdate() {
        return odate;
    }

      public void setOdate(LocalDateTime odate) {
          this.odate = odate;
      }

    @Override
    public String toString() {
        return "Xmorder{" +
              "oid=" + oid +
                  ", uid=" + uid +
                  ", addressid=" + addressid +
                  ", totalprice=" + totalprice +
                  ", remarks=" + remarks +
                  ", status=" + status +
                  ", odate=" + odate +
              "}";
    }
}
