package nankai.xl.system.model.vo;

import java.io.Serializable;
import java.util.Date;

public class PasswordVO {

    private Integer userId;

    private String oldpassword;

    private String password0;

    private String password1;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getPassword0() {
        return password0;
    }

    public void setPassword0(String password0) {
        this.password0 = password0;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
