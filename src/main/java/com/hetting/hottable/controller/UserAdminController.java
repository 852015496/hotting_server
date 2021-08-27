package com.hetting.hottable.controller;

import com.hetting.hottable.core.SysLog;
import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.server.TokenService;
import com.hetting.hottable.server.impl.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "userAdmin",tags = "管理员登录")
@Controller
@RequestMapping("/userAdmin")
public class UserAdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * @Author zhangWenTao
     * @Description //TODO 验证管理员
     * @Date 2020/4/5
     * @Param [admin]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @SysLog(type="验证",operation = "query")
    @ApiOperation(value = "验证",httpMethod = "POST")
    @PostMapping("/verifyAdmin")
    @ResponseBody
    public Map<String,Object> verifyAdmin(Admin admin) throws Exception{
        System.err.println(admin.getAdminUserName());
        return adminService.verifyAdmin(admin);
    }




    /**
     * @Author zhangWenTao
     * @Description //TODO 管理员登录
     * @Date 2020/4/5
     * @Param [request, admin]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @SysLog(type="登录",operation = "登录")
    @PostMapping("/adminLogin")
    @ResponseBody
    @ApiOperation(value = "登录",httpMethod = "POST")
    public Map<String,Object> adminLogin(HttpServletRequest request, Admin admin) throws Exception{
        Map<String, Object> map = adminService.adminLogin(request, admin);
        return map;
    }

    @ApiOperation(value = "查询用户",httpMethod = "POST")
    @PostMapping("/adminQuery")
    @ResponseBody
    public List<Admin> adminQuery(@RequestBody Admin admin){
        List<Admin> adminList = adminService.adminQuery(admin);
        return adminList;
    }

    @SysLog(type="修改密码",operation = "修改密码")
    @ApiOperation(value = "修改当前用户密码",httpMethod = "POST")
    @PostMapping("/updateUserPass")
    @ResponseBody
    public Integer updateUserPass(@RequestBody Admin admin){
        return adminService.updateUserPass(admin);
    }

}
