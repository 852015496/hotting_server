package com.hetting.hottable.server;

import com.hetting.hottable.entity.BillingInterval;
import com.hetting.hottable.entity.Company;
import com.hetting.hottable.mapper.BillingIntervalMapper;
import com.hetting.hottable.mapper.CompanyMapper;
import com.hetting.hottable.server.impl.IBillingIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillingIntervalService implements IBillingIntervalService {

    @Autowired
    private BillingIntervalMapper billingIntervalMapper;

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public List<BillingInterval> queryList(BillingInterval billingInterval) throws Exception{
        return billingIntervalMapper.queryList(billingInterval);
    }

    @Override
    public Integer savenBilling(BillingInterval billingInterval) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.format(new Date());
        System.err.println(new Date());
        billingInterval.setCreatTime(new Date());
        return billingIntervalMapper.insertSelective(billingInterval);
    }

    @Override
    public Integer updateBilling(BillingInterval billingInterval) throws Exception{
        return billingIntervalMapper.updateByPrimaryKeySelective(billingInterval);
    }

    @Override
    public Integer deleteByBillingId(BillingInterval billingInterval) throws Exception{
        return billingIntervalMapper.deleteByPrimaryKey(billingInterval.getBillingId());
    }

    @Override
    public Integer deleteByAll(List<String> id) throws Exception{
        Map<String, List<String>> map = new HashMap<>();
        map.put("id",id);
        return billingIntervalMapper.deleteByAll(map);
    }

    @Override
    public List<Company> selectIntervalTime() throws Exception{
        List<Company> intervalTime = null;
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newDate = dateFormat.format(date);
            // 当前时间
            Date simDate = dateFormat.parse(newDate);
            System.err.println(simDate);
            Company company = new Company();
//            if(billingInterval.getBillingId().equals(1)){
//                billingInterval.setBillingId(billingInterval.getBillingId());
//            }
            intervalTime = companyMapper.companyDutyList(company);
            if (intervalTime != null && intervalTime.size() != 0) {
                // 计算出总天数
                int zongDays = (int) ((intervalTime.get(0).getEndTime().getTime() - intervalTime.get(0).getStartTime().getTime()) / (1000 * 3600 * 24));
                System.err.println("总供暖时间 ----->" + zongDays);
                //判断当前时间是否开始供热
                int whether = simDate.compareTo(intervalTime.get(0).getStartTime());
                System.err.println(whether);
                if (whether == -1) {
                    // 还未开始供热 计算供热周期多少天  开始时间减去当前时间
                    int days = (int) ((intervalTime.get(0).getStartTime().getTime() - simDate.getTime()) / (1000 * 3600 * 24));
//                    int days = day / (1000 * 3600 * 24);
                    System.err.println("未开始供暖时间 ----->" + days);
                    intervalTime.get(0).setCompanyState("0");
                    intervalTime.get(0).setComanyZongDay(zongDays + "");
                    intervalTime.get(0).setCompanyWhetherDay(days + "");
                    return intervalTime;
                } else {
                    // 计算供热多长时间
                    int days = (int) ((intervalTime.get(0).getEndTime().getTime() - simDate.getTime()) / (1000 * 3600 * 24));
                    System.err.println("开始供暖时间 ----->" + days);
                    intervalTime.get(0).setCompanyState("1");
                    intervalTime.get(0).setComanyZongDay(zongDays + "");
                    intervalTime.get(0).setCompanyWhetherDay(days + "");
                    return intervalTime;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return intervalTime;
    }

}
