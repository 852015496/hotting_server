package com.hetting.hottable.export.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class ExportUserEntity {

    private Long adminId;
    private String userName;
    private String adminUserName;
    private String adminPostbox;
    private String adminPhone;
    private String userRole;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private String adminDescribe;

    public ExportUserEntity(Long adminId, String userName, String adminUserName, String adminPostbox, String adminPhone, String userRole, Date createDate, String adminDescribe) {
        this.adminId = adminId;
        this.userName = userName;
        this.adminUserName = adminUserName;
        this.adminPostbox = adminPostbox;
        this.adminPhone = adminPhone;
        this.userRole = userRole;
        this.createDate = createDate;
        this.adminDescribe = adminDescribe;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.adminPostbox = adminPostbox;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAdminDescribe() {
        return adminDescribe;
    }

    public void setAdminDescribe(String adminDescribe) {
        this.adminDescribe = adminDescribe;
    }
}
