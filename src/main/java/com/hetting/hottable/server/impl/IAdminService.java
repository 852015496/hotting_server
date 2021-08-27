package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IAdminService {

    Map<String, Object> verifyAdmin(Admin admin) throws Exception;

    Map<String, Object> adminLogin(HttpServletRequest request, Admin admin) throws Exception;

    List<Admin> adminQuery(Admin admin);

    Integer updateUserPass(Admin admin);
}
