package team.xyh.mall.dto;

import java.io.Serializable;

/**
 * @author ：夕阳红队
 * @date ：Created in 2020/9/25 16:31
 * @description：同一返回类
 * @modified By：
 * @version: $
 */
public class Result<T> implements Serializable {
    private Integer code=200;
    private String message="成功";
    private T data;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
