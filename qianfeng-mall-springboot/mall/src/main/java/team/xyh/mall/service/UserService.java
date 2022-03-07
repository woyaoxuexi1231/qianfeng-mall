package team.xyh.mall.service;

import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Role;
import team.xyh.mall.pojo.User;

public interface UserService {
    User getUserByUserName(String username);

    Result register(String username, String password, String email);
}
