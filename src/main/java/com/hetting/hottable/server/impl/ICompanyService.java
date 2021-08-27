package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.entity.Company;
import com.hetting.hottable.entity.CompanyVO;

import java.util.List;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public interface ICompanyService {

    List<Admin> companyList(Admin admin) throws Exception;

    Integer saveUserAndCompany(Admin admin) throws Exception;

    Integer updateUserAndCompany(Admin admin) throws Exception;

    Integer deleteByCompanyId(Integer adminId) throws Exception;

    Integer deleteAllCompanyId(List<String> id) throws Exception;

    List<Company> companyDutyList(Company company) throws Exception;

    Integer updateCompanyMessage(Company company) throws Exception;
}
