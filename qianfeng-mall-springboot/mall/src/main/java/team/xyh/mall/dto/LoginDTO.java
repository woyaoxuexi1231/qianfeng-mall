package team.xyh.mall.dto;


import javax.validation.constraints.NotBlank;

/**
 * 登录传输类
 */

public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "密码不能为空")
    private String password;
}
