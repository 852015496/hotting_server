package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private Integer companyId;

    private String adminUserName;

    private String adminPostbox;

    private String userName;

    private String adminPhone;

    private String userRole;

    private String adminPass;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    private String adminDescribe;

//    ==============

    private Integer adminRoleId;

    private Integer roleId;

    private String adminName;

    private String newAdminPass1;

    private String newAdminPass;

    public String getNewAdminPass1() {
        return newAdminPass1;
    }

    public void setNewAdminPass1(String newAdminPass1) {
        this.newAdminPass1 = newAdminPass1;
    }

    public String getNewAdminPass() {
        return newAdminPass;
    }

    public void setNewAdminPass(String newAdminPass) {
        this.newAdminPass = newAdminPass;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdminDescribe() {
        return adminDescribe;
    }

    public void setAdminDescribe(String adminDescribe) {
        this.adminDescribe = adminDescribe;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPostbox() {
        return adminPostbox;
    }

    public void setAdminPostbox(String adminPostbox) {
        this.adminPostbox = adminPostbox == null ? null : adminPostbox.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass == null ? null : adminPass.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}