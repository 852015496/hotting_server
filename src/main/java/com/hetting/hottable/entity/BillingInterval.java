package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BillingInterval {
    
    private Integer billingId;

    private String hettingName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GBM+8")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GBM+8")
    private Date endTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GBM+8")
    private Date creatTime;

    // 供暖状态 1:开始供暖  2:未开始供暖
    private String billingState;

    private String billingZongDay;

    private String billingWhetherDay;

    public String getBillingZongDay() {
        return billingZongDay;
    }

    public void setBillingZongDay(String billingZongDay) {
        this.billingZongDay = billingZongDay;
    }

    public String getBillingWhetherDay() {
        return billingWhetherDay;
    }

    public void setBillingWhetherDay(String billingWhetherDay) {
        this.billingWhetherDay = billingWhetherDay;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public Integer getBillingId() {
        return billingId;
    }

    public void setBillingId(Integer billingId) {
        this.billingId = billingId;
    }

    public String getHettingName() {
        return hettingName;
    }

    public void setHettingName(String hettingName) {
        this.hettingName = hettingName == null ? null : hettingName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}