package team.xyh.mall.dao;

import team.xyh.mall.pojo.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}