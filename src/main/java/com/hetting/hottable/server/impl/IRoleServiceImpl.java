package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Role;

import java.util.List;

public interface IRoleServiceImpl {

    List<Role> roleList(Role role) throws Exception;

    Integer saveRole(Role role) throws Exception;

    Integer updateRole(Role role) throws Exception;

    Integer deleteById(Integer roleId) throws Exception;

    Integer deleteAlllById(List<String> id) throws Exception;

    List<Role> roleName() throws Exception;
}
