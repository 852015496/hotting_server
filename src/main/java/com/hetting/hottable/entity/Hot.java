package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Hot {
    private Integer hotId;

    private Integer userId;

    private Integer concentId;

    private String hottableName;

    private Integer hottableNumber;

    private String hottableAddress;

    private Integer hotType;  // String 热表法

    private String hotAisle;

    private Integer hotManuCode;

    private String cailber;

    private String hotStatus;

    private String hotModal;

    private String lastCooling;

    private String lastHotting;

    private String lastVol;

    private String lastWorktime;

    private String lastFlowTime;

    private String lastPower;

    private String lastSumflow;

    private String lastHotEntrance;

    private String lastHotExit;

    private String hotAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  hotMaterDate;

    private String hotVenderName;
    //仪表状态码1
    private String stat1;
    //仪表状态码2
    private String stat2;

    //条件对比
    private String plotAddress;

    private String userBuilding;

    private String userDoorNum;


    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding;
    }

    public String getUserDoorNum() {
        return userDoorNum;
    }

    public void setUserDoorNum(String userDoorNum) {
        this.userDoorNum = userDoorNum;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1;
    }

    public String getStat2() {
        return stat2;
    }

    public void setStat2(String stat2) {
        this.stat2 = stat2;
    }

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public String getHotAddress() {
        return hotAddress;
    }

    public void setHotAddress(String hotAddress) {
        this.hotAddress = hotAddress;
    }

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }

    public String getHottableName() {
        return hottableName;
    }

    public void setHottableName(String hottableName) {
        this.hottableName = hottableName == null ? null : hottableName.trim();
    }

    public Integer getHottableNumber() {
        return hottableNumber;
    }

    public void setHottableNumber(Integer hottableNumber) {
        this.hottableNumber = hottableNumber;
    }

    public String getHottableAddress() {
        return hottableAddress;
    }

    public void setHottableAddress(String hottableAddress) {
        this.hottableAddress = hottableAddress == null ? null : hottableAddress.trim();
    }

    public Integer getHotType() {
        return hotType;
    }

    public void setHotType(Integer hotType) {
        this.hotType = hotType;
    }

    public Integer getHotManuCode() {
        return hotManuCode;
    }

    public void setHotManuCode(Integer hotManuCode) {
        this.hotManuCode = hotManuCode;
    }

    public String getCailber() {
        return cailber;
    }

    public void setCailber(String cailber) {
        this.cailber = cailber == null ? null : cailber.trim();
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public String getHotModal() {
        return hotModal;
    }

    public void setHotModal(String hotModal) {
        this.hotModal = hotModal == null ? null : hotModal.trim();
    }

    public String getLastCooling() {
        return lastCooling;
    }

    public void setLastCooling(String lastCooling) {
        this.lastCooling = lastCooling == null ? null : lastCooling.trim();
    }

    public String getLastHotting() {
        return lastHotting;
    }

    public void setLastHotting(String lastHotting) {
        this.lastHotting = lastHotting == null ? null : lastHotting.trim();
    }

    public String getLastVol() {
        return lastVol;
    }

    public void setLastVol(String lastVol) {
        this.lastVol = lastVol == null ? null : lastVol.trim();
    }

    public String getLastWorktime() {
        return lastWorktime;
    }

    public void setLastWorktime(String lastWorktime) {
        this.lastWorktime = lastWorktime == null ? null : lastWorktime.trim();
    }

    public String getLastFlowTime() {
        return lastFlowTime;
    }

    public void setLastFlowTime(String lastFlowTime) {
        this.lastFlowTime = lastFlowTime == null ? null : lastFlowTime.trim();
    }

    public String getLastPower() {
        return lastPower;
    }

    public void setLastPower(String lastPower) {
        this.lastPower = lastPower == null ? null : lastPower.trim();
    }

    public String getLastSumflow() {
        return lastSumflow;
    }

    public void setLastSumflow(String lastSumflow) {
        this.lastSumflow = lastSumflow == null ? null : lastSumflow.trim();
    }

    public String getLastHotEntrance() {
        return lastHotEntrance;
    }

    public void setLastHotEntrance(String lastHotEntrance) {
        this.lastHotEntrance = lastHotEntrance == null ? null : lastHotEntrance.trim();
    }

    public String getLastHotExit() {
        return lastHotExit;
    }

    public void setLastHotExit(String lastHotExit) {
        this.lastHotExit = lastHotExit == null ? null : lastHotExit.trim();
    }

    public Date getHotMaterDate() {
        return hotMaterDate;
    }

    public void setHotMaterDate(Date hotMaterDate) {
        this.hotMaterDate = hotMaterDate;
    }
}