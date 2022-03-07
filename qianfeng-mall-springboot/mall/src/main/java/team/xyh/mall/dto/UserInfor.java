package team.xyh.mall.dto;

import java.io.Serializable;

/**
 * @author ：夕阳红队
 * @date ：Created in 2020/9/25 16:31
 * @description：同一返回类
 * @modified By：
 * @version: $
 */
public class UserInfor {
    private Integer code=200;
    private Integer total=0;
    private String message="成功";
    private Integer userId;
    private String nickname;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
