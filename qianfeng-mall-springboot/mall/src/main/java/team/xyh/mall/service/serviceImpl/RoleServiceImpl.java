package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.RoleMapper;
import team.xyh.mall.pojo.Role;
import team.xyh.mall.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }
}
