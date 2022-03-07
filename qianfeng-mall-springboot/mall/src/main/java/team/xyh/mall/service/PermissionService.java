package team.xyh.mall.service;

import team.xyh.mall.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissionById(Integer id);
}
