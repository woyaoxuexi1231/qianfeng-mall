package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.RoleMapper;
import team.xyh.mall.dao.UserMapper;

import team.xyh.mall.dao.UserRoleMapper;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.User;
import team.xyh.mall.service.UserService;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public Result register(String username, String password, String email) {
        Result result = new Result();
        if(userMapper.getUserByUsername(username)!=null){
            result.setCount(1); //用户名已存在
            return result;
        }
        else{
            result.setCount(0);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setStatus(true);
            user.setCreateTime(new Date());
            userMapper.register(user);
            userRoleMapper.register(user.getId());
        }
        return result;
    }

}
