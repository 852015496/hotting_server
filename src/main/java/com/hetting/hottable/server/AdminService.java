package com.hetting.hottable.server;

import com.hetting.hottable.common.ResultCode;
import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.mapper.AdminMapper;
import com.hetting.hottable.server.impl.IAdminService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bouncycastle.crypto.tls.HashAlgorithm.md5;

@Service("adminService")
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    TokenService tokenService;


    @Override
    public Map<String, Object> verifyAdmin(Admin admin) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        Admin adminUser = adminMapper.verifyAdmin(admin);
        if(adminUser == null){
            map.put("errorCode",200); // 验证成功
        }else {
            map.put("errorCode",404); // 用户不存在
        }
        return map;
    }

    @Override
    public Map<String,Object> adminLogin(HttpServletRequest request, Admin admin) throws Exception{

        Map<String, Object> returnMap = new HashMap<>();

        Admin adminUser = adminMapper.verifyAdmin(admin);
        Admin adminRole = adminMapper.adminRoles(admin.getAdminUserName());
        System.err.println(adminRole.getUserRole());
        request.getSession().setAttribute("user",adminRole);
        if(null == adminUser) {
            returnMap.put("error",ResultCode.VALIDATE_FAILED.getCode());
            return returnMap;
        }
        if(!adminUser.getAdminUserName().equals(admin.getAdminUserName())){
            returnMap.put("error",ResultCode.VALIDATE_FAILED.getCode());
            return returnMap;
        }
        Md5Hash md5Hash = new Md5Hash(admin.getAdminPass().getBytes());
        if(!adminUser.getAdminPass().equals(md5Hash.toString())){
            returnMap.put("error",ResultCode.VALIDATE_FAILED.getCode());
            return returnMap;
        }
        String token = tokenService.getToken(adminUser);
        returnMap.put("userName",admin.getAdminUserName());
        returnMap.put("userRole",adminRole.getUserRole());
        returnMap.put("token",token);
        returnMap.put("success",ResultCode.SUCCESS.getCode());
        return returnMap;
    }

    @Override
    public List<Admin> adminQuery(Admin admin) {
        return adminMapper.adminQuery(admin);
    }

    @Override
    public Integer updateUserPass(Admin admin) {
        Admin adminName = adminMapper.verifyAdminName(admin.getAdminUserName());
        Md5Hash oldPass = new Md5Hash(admin.getAdminPass());
        Md5Hash newPass = new Md5Hash(admin.getNewAdminPass());
        System.err.println(adminName.getAdminPass());
        System.err.println(oldPass);
        //当前用户密码和旧密码是否一致
        if(adminName.getAdminPass().equals(oldPass.toString())){
            admin.setAdminPass(newPass.toString());
        }else{
            return 500; //当前用户密码和旧密码不一致!
        }
        return adminMapper.updateUserPass(admin);
    }


}
