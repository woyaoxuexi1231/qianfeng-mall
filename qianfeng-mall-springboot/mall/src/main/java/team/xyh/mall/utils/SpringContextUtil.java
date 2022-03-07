package team.xyh.mall.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.xyh.mall.pojo.Permission;
import team.xyh.mall.pojo.Role;
import team.xyh.mall.pojo.User;
import team.xyh.mall.service.PermissionService;
import team.xyh.mall.service.RoleService;
import team.xyh.mall.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SpringContextUtil {
    //需要在工具类中调用service，查询表中记录
    @Autowired
    private UserService userservice;
    private static UserService userService;
    private RoleService roleservice;
    private static RoleService roleService;
    private PermissionService permissionservice;
    private static PermissionService permissionService;

    @PostConstruct //完成对service的注入
    public void init() {
        userService = userservice;
        roleService = roleservice;
        permissionService = permissionservice;
    }

    public User getUserByUsername(String username) {
        return userService.getUserByUserName(username);
    }
    public List<Role> getRoleById(Integer id) {
        return roleService.getRoleById(id);
    }

    public List<Permission> getPermissionById(Integer id){
        return permissionService.getPermissionById(id);
    }

}