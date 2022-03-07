package team.xyh.mall.dao;

import team.xyh.mall.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Short id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUsername(String username);

    void register(User user);
}