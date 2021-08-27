package com.hetting.hottable.server.impl;

import com.hetting.hottable.entity.BillingInterval;
import com.hetting.hottable.entity.Company;

import java.util.List;

public interface IBillingIntervalService {

    List<BillingInterval> queryList(BillingInterval billingInterval) throws Exception;

    Integer savenBilling(BillingInterval billingInterval) throws Exception;

    Integer updateBilling(BillingInterval billingInterval) throws Exception;

    Integer deleteByBillingId(BillingInterval billingInterval) throws Exception;

    Integer deleteByAll(List<String> id) throws Exception;

    List<Company> selectIntervalTime() throws Exception;
}
