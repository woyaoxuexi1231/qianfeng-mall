package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.UserService;

@RestController
@CrossOrigin
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Result register(String username, String password, String email){
        return userService.register(username, password, email);
    }
}
