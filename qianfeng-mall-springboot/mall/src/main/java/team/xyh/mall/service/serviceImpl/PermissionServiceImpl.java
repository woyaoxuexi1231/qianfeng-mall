package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.PermissionMapper;
import team.xyh.mall.pojo.Permission;
import team.xyh.mall.service.PermissionService;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionById(Integer id) {
        return permissionMapper.getPermissionById(id);
    }
}
