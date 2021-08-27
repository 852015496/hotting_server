package com.hetting.hottable.entity;

import lombok.Data;

/**
 * @Description TODO    新增仪表信息VO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/

@Data
public class UserVO {

    private Integer userId;

    private Integer plotId;

    private Integer concentId;

    private Integer hotId;

    private Integer valveId;

    private String housing;

    private String userName;

    private String userType;

    private String userBuilding;

    private String userCell;

    private String userDoornum;

    private String userArea;

    private String userConcentCode;
    // 热表类型
    private String hotModal;

    private Integer hotManuCode;
    //热表接入的抄表通道1-4MBUS 8=485 10=Lora
    private String hotAisle;

    private String hotAddress;

    private String venderCode;
    //阀门接入的抄表通道1-4MBUS 8=485 10=Lora
    private String valveChn;

    private String valveAddress;
    // 热表状态
    private String hotStatus;
    // 最后一次上传的冷量
    private String lastCooling;
    // 最后一次上传的热量
    private String lastHotting;
    // 最后一次上传的累计流量
    private String lastVol;
    // 最后一次上传的瞬时流量
    private String lastFlowTime;
    // 最后一次上传的功率
    private String lastPower;
    // 最后一次上传的体积流量
    private String lastSumflow;
    // 最后一次上传的入口温度
    private String lastHotEntrance;
    // 最后一次上传的出口温度
    private String lastHotExit;
    //阀门工作模式
    private String valveWorkMode;
    // 上报阀门工作模式
    private String lastValveWorkMode;
    // 阀门开度
    private String lastValveOpen;
    // 阀门状态
    private String valveStatus;
    // 阀门类型
    private String valveModal;

    //  集中器代码
    private String concentCode;

    //温度设定
    private String setIndoorTemp;

    private String  valveVenderName;

    private String hotVenderName;

    private String opening;

    private String minOpen;

    private String maxOpen;

    private String tempUpper;

    private String tempLower;

    private String setTempValue;

    private String setFlow;

    private String apportionHot;

    private String setPower;

    private String powerOpening;

    private String trimClosing;

    private String rustSport;

    private String tempInterval;

    private String tempAdjust;


    public String getSetFlow() {
        return setFlow;
    }

    public void setSetFlow(String setFlow) {
        this.setFlow = setFlow;
    }

    public String getApportionHot() {
        return apportionHot;
    }

    public void setApportionHot(String apportionHot) {
        this.apportionHot = apportionHot;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getMinOpen() {
        return minOpen;
    }

    public void setMinOpen(String minOpen) {
        this.minOpen = minOpen;
    }

    public String getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(String maxOpen) {
        this.maxOpen = maxOpen;
    }

    public String getTempUpper() {
        return tempUpper;
    }

    public void setTempUpper(String tempUpper) {
        this.tempUpper = tempUpper;
    }

    public String getTempLower() {
        return tempLower;
    }

    public void setTempLower(String tempLower) {
        this.tempLower = tempLower;
    }

    public String getSetTempValue() {
        return setTempValue;
    }

    public void setSetTempValue(String setTempValue) {
        this.setTempValue = setTempValue;
    }

    public String getSetPower() {
        return setPower;
    }

    public void setSetPower(String setPower) {
        this.setPower = setPower;
    }

    public String getPowerOpening() {
        return powerOpening;
    }

    public void setPowerOpening(String powerOpening) {
        this.powerOpening = powerOpening;
    }

    public String getTrimClosing() {
        return trimClosing;
    }

    public void setTrimClosing(String trimClosing) {
        this.trimClosing = trimClosing;
    }

    public String getRustSport() {
        return rustSport;
    }

    public void setRustSport(String rustSport) {
        this.rustSport = rustSport;
    }

    public String getTempInterval() {
        return tempInterval;
    }

    public void setTempInterval(String tempInterval) {
        this.tempInterval = tempInterval;
    }

    public String getTempAdjust() {
        return tempAdjust;
    }

    public void setTempAdjust(String tempAdjust) {
        this.tempAdjust = tempAdjust;
    }

    public String getValveVenderName() {
        return valveVenderName;
    }

    public void setValveVenderName(String valveVenderName) {
        this.valveVenderName = valveVenderName;
    }

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public String getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(String valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
    }

    public String getSetIndoorTemp() {
        return setIndoorTemp;
    }

    public void setSetIndoorTemp(String setIndoorTemp) {
        this.setIndoorTemp = setIndoorTemp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding;
    }

    public String getUserCell() {
        return userCell;
    }

    public void setUserCell(String userCell) {
        this.userCell = userCell;
    }

    public String getUserDoornum() {
        return userDoornum;
    }

    public void setUserDoornum(String userDoornum) {
        this.userDoornum = userDoornum;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserConcentCode() {
        return userConcentCode;
    }

    public void setUserConcentCode(String userConcentCode) {
        this.userConcentCode = userConcentCode;
    }

    public Integer getHotManuCode() {
        return hotManuCode;
    }

    public void setHotManuCode(Integer hotManuCode) {
        this.hotManuCode = hotManuCode;
    }

    public String getHotAddress() {
        return hotAddress;
    }

    public void setHotAddress(String hotAddress) {
        this.hotAddress = hotAddress;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }

    public String getVenderCode() {
        return venderCode;
    }

    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public String getValveChn() {
        return valveChn;
    }

    public void setValveChn(String valveChn) {
        this.valveChn = valveChn;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getHotModal() {
        return hotModal;
    }

    public void setHotModal(String hotModal) {
        this.hotModal = hotModal;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public String getLastCooling() {
        return lastCooling;
    }

    public void setLastCooling(String lastCooling) {
        this.lastCooling = lastCooling;
    }

    public String getLastHotting() {
        return lastHotting;
    }

    public void setLastHotting(String lastHotting) {
        this.lastHotting = lastHotting;
    }

    public String getLastVol() {
        return lastVol;
    }

    public void setLastVol(String lastVol) {
        this.lastVol = lastVol;
    }

    public String getLastFlowTime() {
        return lastFlowTime;
    }

    public void setLastFlowTime(String lastFlowTime) {
        this.lastFlowTime = lastFlowTime;
    }

    public String getLastPower() {
        return lastPower;
    }

    public void setLastPower(String lastPower) {
        this.lastPower = lastPower;
    }

    public String getLastSumflow() {
        return lastSumflow;
    }

    public void setLastSumflow(String lastSumflow) {
        this.lastSumflow = lastSumflow;
    }

    public String getLastHotEntrance() {
        return lastHotEntrance;
    }

    public void setLastHotEntrance(String lastHotEntrance) {
        this.lastHotEntrance = lastHotEntrance;
    }

    public String getLastHotExit() {
        return lastHotExit;
    }

    public void setLastHotExit(String lastHotExit) {
        this.lastHotExit = lastHotExit;
    }


    public String getLastValveWorkMode() {
        return lastValveWorkMode;
    }

    public void setLastValveWorkMode(String lastValveWorkMode) {
        this.lastValveWorkMode = lastValveWorkMode;
    }

    public String getLastValveOpen() {
        return lastValveOpen;
    }

    public void setLastValveOpen(String lastValveOpen) {
        this.lastValveOpen = lastValveOpen;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public String getValveModal() {
        return valveModal;
    }

    public void setValveModal(String valveModal) {
        this.valveModal = valveModal;
    }

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }
}
