package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Role;
import team.xyh.mall.service.RoleService;
import team.xyh.mall.service.UserService;

@RestController
@CrossOrigin
public class JumpController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/jump")
    public Result jump(String username){
        Result result = new Result();
        if(userService.getUserByUserName(username)!=null) {
            result.setMessage(roleService.getRoleById(userService.getUserByUserName(username).getId()).get(0).getName());
            result.setData(userService.getUserByUserName(username));
        }
        return result;
    }
}
