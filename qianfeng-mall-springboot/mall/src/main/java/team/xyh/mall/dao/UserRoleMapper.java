package team.xyh.mall.dao;

import team.xyh.mall.pojo.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    void register(Integer id);
}