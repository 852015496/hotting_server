package com.hetting.hottable.mapper;

import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.export.Entity.ExportUserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminMapper {

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin verifyAdmin(Admin admin);

    List<Admin> companyList(Admin admin);

    Integer deleteAllCompanyId(Map<String, List<String>> id);

    Admin verifyUserPhone(Admin admin);

    Admin verifyUserPostPox(Admin admin);

    List<Admin> adminQuery(Admin admin);

    Admin verifyAdminName(String adminUserName);

    Integer updateUserPass(Admin admin);

    Admin adminRoles(String adminUserName);

    List<ExportUserEntity> queryUserList();
}