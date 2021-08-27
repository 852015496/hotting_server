package com.hetting.hottable.controller;

import com.hetting.hottable.entity.Role;
import com.hetting.hottable.server.impl.IRoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/RoleController",tags = "角色管理")
@RestController
@RequestMapping("/RoleController")
public class RoleController {

    @Autowired
    private IRoleServiceImpl roleService;

    @PostMapping("/roleList")
    @ApiOperation(value = "角色列表",httpMethod = "POST")
    public List<Role> roleList(@RequestBody Role role) throws Exception{
        List<Role> roleQueryList = roleService.roleList(role);
        return roleQueryList;
    }

    @PostMapping("/saveRole")
    @ApiOperation(value = "添加角色",httpMethod = "POST")
    public Integer saveRole(@RequestBody Role role) throws Exception{
    return roleService.saveRole(role);
    }

    @PostMapping("/updateRole")
    @ApiOperation(value = "编辑角色",httpMethod = "POST")
    public Integer updateRole(@RequestBody Role role) throws Exception{
        return roleService.updateRole(role);
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "删除角色",httpMethod = "POST")
    public Integer deleteById(@RequestBody Role role) throws Exception{
        if(null == role.getRoleId()){
            return -1;
        }
        return roleService.deleteById(role.getRoleId());
    }

    @PostMapping("/deleteAllBuId")
    @ApiOperation(value = "批量删除角色",httpMethod = "POST")
    public Integer deleteAllById(@RequestBody Role role) throws Exception{
        List arr = new ArrayList<>();
        String[] split = role.getRoleName().split(",");
        for(String str:split){
            arr.add(Integer.parseInt(str));
        }
        return roleService.deleteAlllById(arr);
    }

    @PostMapping("/roleName")
    @ApiOperation(value = "角色名称",httpMethod = "POST")
    public List<Role> roleName() throws Exception{
        List<Role> roles = roleService.roleName();
        return roles;
    }

}
