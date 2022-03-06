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
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "addressId", type = IdType.AUTO)
      private Integer addressid;

    private Integer uid;

    private String cnee;

    private String phone;

    private String address;

    
    public Integer getAddressid() {
        return addressid;
    }

      public void setAddressid(Integer addressid) {
          this.addressid = addressid;
      }
    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public String getCnee() {
        return cnee;
    }

      public void setCnee(String cnee) {
          this.cnee = cnee;
      }
    
    public String getPhone() {
        return phone;
    }

      public void setPhone(String phone) {
          this.phone = phone;
      }
    
    public String getAddress() {
        return address;
    }

      public void setAddress(String address) {
          this.address = address;
      }

    @Override
    public String toString() {
        return "Address{" +
              "addressid=" + addressid +
                  ", uid=" + uid +
                  ", cnee=" + cnee +
                  ", phone=" + phone +
                  ", address=" + address +
              "}";
    }
}
