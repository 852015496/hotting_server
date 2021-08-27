package com.hetting.hottable.entity;

import java.util.Date;

public class HotMessage {
    private Long hotMid;

    private Integer hotId;

    private Integer userId;

    private Long concentMid;

    private String cooling;

    private String hotting;

    private String hotStatus;

    private String vol;

    private String worktime;

    private String flowTime;

    private String power;

    private String sumflow;

    private String hotEntrance;

    private String hotExit;

    private String hotStatusName;

    private String hotUnusualName;

    private Date startTime;

    private Date endTime;

    private String hotVenderName;

    // 仪表地址代码
    private String hotCode;
    // 热表接入通道
    private String hotAisle;


    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCooling() {
        return cooling;
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public String getHotCode() {
        return hotCode;
    }

    public void setHotCode(String hotCode) {
        this.hotCode = hotCode;
    }

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    public Long getHotMid() {
        return hotMid;
    }

    public void setHotMid(Long hotMid) {
        this.hotMid = hotMid;
    }

    public Long getConcentMid() {
        return concentMid;
    }

    public void setConcentMid(Long concentMid) {
        this.concentMid = concentMid;
    }

    public String getCooling(String meterCold) {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling == null ? null : cooling.trim();
    }

    public String getHotting() {
        return hotting;
    }

    public void setHotting(String hotting) {
        this.hotting = hotting == null ? null : hotting.trim();
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol == null ? null : vol.trim();
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime == null ? null : worktime.trim();
    }

    public String getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(String flowTime) {
        this.flowTime = flowTime == null ? null : flowTime.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getSumflow() {
        return sumflow;
    }

    public void setSumflow(String sumflow) {
        this.sumflow = sumflow == null ? null : sumflow.trim();
    }

    public String getHotEntrance() {
        return hotEntrance;
    }

    public void setHotEntrance(String hotEntrance) {
        this.hotEntrance = hotEntrance == null ? null : hotEntrance.trim();
    }

    public String getHotExit() {
        return hotExit;
    }

    public void setHotExit(String hotExit) {
        this.hotExit = hotExit == null ? null : hotExit.trim();
    }

    public String getHotStatusName() {
        return hotStatusName;
    }

    public void setHotStatusName(String hotStatusName) {
        this.hotStatusName = hotStatusName;
    }

    public String getHotUnusualName() {
        return hotUnusualName;
    }

    public void setHotUnusualName(String hotUnusualName) {
        this.hotUnusualName = hotUnusualName;
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
}