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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "uid", type = IdType.AUTO)
      private Integer uid;

    private String uname;

    private String upass;

    private Integer ustatus;

    private Integer ulevel;

    private Integer score;

    
    public Integer getUid() {
        return uid;
    }

      public void setUid(Integer uid) {
          this.uid = uid;
      }
    
    public String getUname() {
        return uname;
    }

      public void setUname(String uname) {
          this.uname = uname;
      }
    
    public String getUpass() {
        return upass;
    }

      public void setUpass(String upass) {
          this.upass = upass;
      }
    
    public Integer getUstatus() {
        return ustatus;
    }

      public void setUstatus(Integer ustatus) {
          this.ustatus = ustatus;
      }
    
    public Integer getUlevel() {
        return ulevel;
    }

      public void setUlevel(Integer ulevel) {
          this.ulevel = ulevel;
      }
    
    public Integer getScore() {
        return score;
    }

      public void setScore(Integer score) {
          this.score = score;
      }

    @Override
    public String toString() {
        return "Users{" +
              "uid=" + uid +
                  ", uname=" + uname +
                  ", upass=" + upass +
                  ", ustatus=" + ustatus +
                  ", ulevel=" + ulevel +
                  ", score=" + score +
              "}";
    }
}
