package com.hetting.hottable.server;

import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.entity.AdminRole;
import com.hetting.hottable.entity.Company;
import com.hetting.hottable.mapper.AdminMapper;
import com.hetting.hottable.mapper.AdminRoleMapper;
import com.hetting.hottable.mapper.CompanyMapper;
import com.hetting.hottable.server.impl.ICompanyService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;


    @Override
    public List<Admin> companyList(Admin admin) throws Exception{
        return adminMapper.companyList(admin);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveUserAndCompany(Admin admin) throws Exception{
      /*  Company company = new Company();
        company.setCompanyName(companyVO.getCompanyName());
        company.setUserRole(companyVO.getUserRole());
        company.setCompanyComment(companyVO.getCompanyComment());
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.format(new Date());
        company.setCreatTime(new Date());
        companyMapper.insertSelective(company);
        Integer companyId = company.getCompanyId();
        System.err.println(companyId);*/
        /*admin.setCompanyId(companyId);
        admin.setAdminUsername(companyVO.getAdminUserName());
        admin.setAdminPostbox(companyVO.getAdminPostbox());
        admin.setAdminVoip(companyVO.getAdminVoip());
        admin.setAdminPhone(companyVO.getAdminPhone());
        admin.setLoginWhether(companyVO.getLoginWhether());*/
        if(ObjectUtils.isEmpty(admin)){
            return 0;
        }
        Admin admins = adminMapper.verifyAdmin(admin);
        if(ObjectUtils.isNotEmpty(admins)){
            return 110; //用户名已存在
        }
        Admin phone = adminMapper.verifyUserPhone(admin);
        if(ObjectUtils.isNotEmpty(phone)){
            return 111; //此手机号码已存在
        }
        Admin postPox = adminMapper.verifyUserPostPox(admin);
        if(ObjectUtils.isNotEmpty(postPox)){
            return 112; //此邮箱已经被使用
        }
        Md5Hash md5 = new Md5Hash(admin.getAdminPass().getBytes());
        System.err.println(md5);
        admin.setAdminPass(md5.toString());
        admin.setCreateDate(new Date());
        adminMapper.insertSelective(admin);
        Integer adminId = admin.getAdminId();
        AdminRole adminRole = new AdminRole();
        adminRole.setAdminId(adminId);
        adminRole.setRoleId(admin.getRoleId());
        return adminRoleMapper.insertSelective(adminRole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updateUserAndCompany(Admin admin) throws Exception{
    /*    Admin admin = new Admin();
        admin.setCompanyId(companyVO.getCompanyId());
        admin.setAdminUsername(companyVO.getAdminUserName());
        admin.setAdminPostbox(companyVO.getAdminPostbox());
        admin.setAdminVoip(companyVO.getAdminVoip());
        admin.setAdminPhone(companyVO.getAdminPhone());
        admin.setLoginWhether(companyVO.getLoginWhether());
        admin.setAdminPass(companyVO.getAdminPass());*/
        Md5Hash md5Hash = new Md5Hash(admin.getAdminPass());
        admin.setAdminPass(md5Hash.toString());
        return adminMapper.updateByPrimaryKeySelective(admin);
      /*  Company company = new Company();
        company.setCompanyId(companyVO.getCompanyId());
        company.setCompanyName(companyVO.getCompanyName());
        company.setCompanyAddress(companyVO.getCompanyAddress());
        company.setUserRole(companyVO.getUserRole());
        company.setCompanyComment(companyVO.getCompanyComment());
        return companyMapper.updateByPrimaryKeySelective(company);*/
    }

    @Override
    public Integer deleteByCompanyId(Integer adminId) throws Exception{
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Integer deleteAllCompanyId(List<String> id) throws Exception{
        Map<String,List<String>> map = new HashMap<>();
        map.put("id",id);
        return adminMapper.deleteAllCompanyId(map);
    }

    @Override
    public List<Company> companyDutyList(Company company) {
        return companyMapper.companyDutyList(company);
    }

    @Override
    public Integer updateCompanyMessage(Company company) {
        return companyMapper.updateByPrimaryKeySelective(company);
    }
}
