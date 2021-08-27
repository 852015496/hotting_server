package com.hetting.hottable.mapper;


import com.hetting.hottable.entity.BillingInterval;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BillingIntervalMapper {
    int deleteByPrimaryKey(Integer billingId);

    int insert(BillingInterval record);

    int insertSelective(BillingInterval record);

    BillingInterval selectByPrimaryKey(Integer billingId);

    int updateByPrimaryKeySelective(BillingInterval record);

    int updateByPrimaryKey(BillingInterval record);

    List<BillingInterval> queryList(BillingInterval billingInterval);

    Integer deleteByAll(Map<String, List<String>> id);
}