package com.hetting.hottable.controller;

import com.hetting.hottable.entity.Admin;
import com.hetting.hottable.entity.Company;
import com.hetting.hottable.entity.CompanyVO;
import com.hetting.hottable.entity.Concent;
import com.hetting.hottable.server.impl.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/CompanyController",tags = "系统设置")
@RestController
@RequestMapping("/CompanyController")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;


    /**
     * @Author ZhangWenTao
     * @Description //TODO 用户列表展示
     * @Date 2020/8/31
     * @Param [admin]
     * @return java.util.List<com.hetting.hottable.entity.Admin>
     **/
    @PostMapping("/companyList")
    @ApiOperation(value = "用户列表展示",httpMethod = "POST")
    public List<Admin> companyList(@RequestBody Admin admin) throws Exception{
        List<Admin> companyList = companyService.companyList(admin);
        return companyList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 公司列表展示
     * @Date 2020/8/31
     * @Param [company]
     * @return java.util.List<com.hetting.hottable.entity.Company>
     **/
    @PostMapping("/companyDutyList")
    @ApiOperation(value = "公司列表展示",httpMethod = "POST")
    public List<Company> companyDutyList(@RequestBody Company company) throws Exception{
        List<Company> companyList = companyService.companyDutyList(company);
        return companyList;
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 修改公司信息
     * @Date 2020/8/31
     * @Param [company]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateCompanyMessage")
    @ApiOperation(value = "修改公司信息",httpMethod = "POST")
    public Integer updateCompanyMessage(@RequestBody Company company) throws Exception{
        return companyService.updateCompanyMessage(company);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 增加公司和用户信息
     * @Date 2020/8/31
     * @Param [admin]
     * @return java.lang.Integer
     **/
    @PostMapping("/saveUserAndCompany")
    @ApiOperation(value = "添加用户管理信息",httpMethod = "POST")
    public Integer saveUserAndCompany(@RequestBody Admin admin) throws Exception{
        return companyService.saveUserAndCompany(admin);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  更改公司和用户信息
     * @Date 2020/8/31
     * @Param [admin]
     * @return java.lang.Integer
     **/
    @PostMapping("/updateUserAndCompany")
    @ApiOperation(value = "更改用户管理",httpMethod = "POST")
    public Integer updateUserAndCompany(@RequestBody Admin admin) throws Exception{
        return companyService.updateUserAndCompany(admin);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  根据id删除信息
     * @Date 2020/8/31
     * @Param [admin]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteByCompanyId")
    @ApiOperation(value = "删除信息")
    public Integer deleteByCompanyId(@RequestBody Admin admin) throws Exception{
        if(null == admin.getAdminId()){
            return -1;
        }
        return companyService.deleteByCompanyId(admin.getAdminId());
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  批量删除
     * @Date 2020/8/31
     * @Param [admin]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteAllCompanyId")
    @ApiOperation(value = "批量删除公司信息",httpMethod = "POST")
    public Integer deleteAllCompanyId(@RequestBody Admin admin) throws Exception{
        //创建数据
        List list = new ArrayList<Integer>();
        // 把获取的到id用String接收并分割逗号
        String[] strs = admin.getUserName().split(",");
        //循环取值
        for (String str : strs) {
            //id要用Integer类型接收
            list.add(Integer.parseInt(str));
        }
        return companyService.deleteAllCompanyId(list);
    }



}
