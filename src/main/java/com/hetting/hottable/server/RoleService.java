package com.hetting.hottable.server;

import com.hetting.hottable.entity.AdminRole;
import com.hetting.hottable.entity.Role;
import com.hetting.hottable.mapper.AdminRoleMapper;
import com.hetting.hottable.mapper.RoleMapper;
import com.hetting.hottable.server.impl.IRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class RoleService implements IRoleServiceImpl {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public List<Role> roleList(Role role) throws Exception{
        return roleMapper.selectRoleList(role);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveRole(Role role) throws Exception{
        roleMapper.insertSelective(role);
        Integer roleId = role.getRoleId();
        AdminRole adminRole = new AdminRole();
        adminRole.setRoleId(roleId);
        return adminRoleMapper.insertSelective(adminRole);
    }

    @Override
    public Integer updateRole(Role role) throws Exception {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer deleteById(Integer roleId) throws Exception {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Integer deleteAlllById(List<String> id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return roleMapper.deleteAllById(map);
    }

    @Override
    public List<Role> roleName() throws Exception{
        return roleMapper.roleName();
    }
}
