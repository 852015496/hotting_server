package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.Company;
import com.hetting.hottable.entity.CompanyVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<CompanyVO> companyList(CompanyVO companyVO);

    Integer deleteByCompanyId(Integer companyId);

    Integer deleteAllCompanyId(Map<String, List<String>> id);

    List<Company> companyDutyList(Company company);
}