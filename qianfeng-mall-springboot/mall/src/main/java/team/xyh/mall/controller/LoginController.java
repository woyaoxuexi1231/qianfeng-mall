package team.xyh.mall.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.User;
import team.xyh.mall.service.RoleService;
import team.xyh.mall.service.UserService;

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public Result login(String username, String password, Model model){
        Result result = new Result();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码不正确");
        }catch(UnknownAccountException uae){
            model.addAttribute("msg","账号不存在");
        }catch(AuthenticationException ae){
            model.addAttribute("msg","状态不正常");
        }
        if(userService.getUserByUserName(username)!=null && password.equals(userService.getUserByUserName(username).getPassword())){
            System.out.println("认证成功");
            model.addAttribute("username",username);
            result.setMessage(roleService.getRoleById(userService.getUserByUserName(username).getId()).get(0).getName());
        }else{
            System.out.println("认证失败");
            token.clear();
            result.setMessage("失败");
            return result;
        }
        return result;
    }
}
