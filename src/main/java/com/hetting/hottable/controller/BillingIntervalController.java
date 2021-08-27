package com.hetting.hottable.controller;

import com.hetting.hottable.entity.BillingInterval;
import com.hetting.hottable.entity.Company;
import com.hetting.hottable.server.impl.IBillingIntervalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api()
@RestController
@RequestMapping("/BillingIntervalController")
public class BillingIntervalController {

    @Autowired
    private IBillingIntervalService billingIntervalService;


    /**
     * @Author ZhangWenTao
     * @Description //TODO 供热周期展示
     * @Date 2020/8/31
     * @Param [billingInterval]
     * @return java.util.List<com.hetting.hottable.entity.BillingInterval>
     **/
    @ApiOperation(value = "查询各个供热周期时间",httpMethod = "POST")
    @PostMapping("/queryList")
    public List<BillingInterval> queryList(@RequestBody BillingInterval billingInterval) throws Exception{
        List<BillingInterval> intervalList = billingIntervalService.queryList(billingInterval);
        return intervalList;
    }


    /**
     * @Author ZhangWenTao
     * @Description //TODO 增加供热周期
     * @Date 2020/8/31
     * @Param [billingInterval]
     * @return java.lang.Integer
     **/
    @ApiOperation(value = "添加供热周期",httpMethod = "POST")
    @PostMapping("/saveBilling")
    public Integer saveBilling(@RequestBody BillingInterval billingInterval) throws Exception{
        return billingIntervalService.savenBilling(billingInterval);
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO 修改供热周期的时间
     * @Date 2020/8/31
     * @Param [billingInterval]
     * @return java.lang.Integer
     **/
    @ApiOperation(value = "编辑供热周期区间",httpMethod = "POST")
    @PostMapping("/updateBilling")
    public Integer updateBilling(@RequestBody BillingInterval billingInterval) throws Exception{
        if(null == billingInterval.getBillingId()){
            return -1;
        }
        return billingIntervalService.updateBilling(billingInterval);
    }

    @ApiOperation(value = "删除供热区间记录",httpMethod = "POST")
    @PostMapping("/deleteByBillingId")
    public Integer deleteByBillingId(@RequestBody BillingInterval billingInterval) throws Exception{
        return billingIntervalService.deleteByBillingId(billingInterval);
    }


    @ApiOperation(value = "批量删除记录",httpMethod = "POST")
    @PostMapping("/deleteByAll")
    public Integer deleteByAll(@RequestBody BillingInterval billingInterval) throws Exception{
        List list = new ArrayList<>();
        String[] strs = billingInterval.getHettingName().split(",");
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }
        return billingIntervalService.deleteByAll(list);
    }


    @ApiOperation(value = "供热时间计算展示",httpMethod = "POST")
    @PostMapping("/intervalTime")
    public List<Company> intervalTime() throws Exception{
        return billingIntervalService.selectIntervalTime();
    }


}
