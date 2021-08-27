package com.hetting.hottable.entity;

import java.util.Date;

public class ValveMessage {
    private Long valveMid;

    private Integer valveId;

    private Integer userId;

    private Long concentMid;

    private String valveWorkMode;

    private String valveStatus;

    private String valveOpen;

    private String valveOpenMin;

    private String valveOpenMax;

    private String valveAntirusttmo;

    private String testinterjust;

    private String testPycle;

    private String tempAdjust;

    private String lowVar;

    private String highVar;

    private String setTemp;

    private String setPower;

    private String setFlux;

    private String valveUpdatedate;

    private String valveFlag;

    private Date startTime;

    private String endTime;

    private String avgTemp;

    private String hotValveNum;

    private String apportionHot;

    private String lastVintemp;

    private String lastVouttemp;

    public String getLastVintemp() {
        return lastVintemp;
    }

    public void setLastVintemp(String lastVintemp) {
        this.lastVintemp = lastVintemp;
    }

    public String getLastVouttemp() {
        return lastVouttemp;
    }

    public void setLastVouttemp(String lastVouttemp) {
        this.lastVouttemp = lastVouttemp;
    }

    public String getApportionHot() {
        return apportionHot;
    }

    public void setApportionHot(String apportionHot) {
        this.apportionHot = apportionHot;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHotValveNum() {
        return hotValveNum;
    }

    public void setHotValveNum(String hotValveNum) {
        this.hotValveNum = hotValveNum;
    }

    public String getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(String avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Long getValveMid() {
        return valveMid;
    }

    public void setValveMid(Long valveMid) {
        this.valveMid = valveMid;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public Long getConcentMid() {
        return concentMid;
    }

    public void setConcentMid(Long concentMid) {
        this.concentMid = concentMid;
    }

    public String getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(String valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
    }

    public String getValveOpen() {
        return valveOpen;
    }

    public void setValveOpen(String valveOpen) {
        this.valveOpen = valveOpen == null ? null : valveOpen.trim();
    }

    public String getValveOpenMin() {
        return valveOpenMin;
    }

    public void setValveOpenMin(String valveOpenMin) {
        this.valveOpenMin = valveOpenMin == null ? null : valveOpenMin.trim();
    }

    public String getValveOpenMax() {
        return valveOpenMax;
    }

    public void setValveOpenMax(String valveOpenMax) {
        this.valveOpenMax = valveOpenMax == null ? null : valveOpenMax.trim();
    }

    public String getValveAntirusttmo() {
        return valveAntirusttmo;
    }

    public void setValveAntirusttmo(String valveAntirusttmo) {
        this.valveAntirusttmo = valveAntirusttmo == null ? null : valveAntirusttmo.trim();
    }

    public String getTestinterjust() {
        return testinterjust;
    }

    public void setTestinterjust(String testinterjust) {
        this.testinterjust = testinterjust == null ? null : testinterjust.trim();
    }

    public String getTestPycle() {
        return testPycle;
    }

    public void setTestPycle(String testPycle) {
        this.testPycle = testPycle == null ? null : testPycle.trim();
    }

    public String getTempAdjust() {
        return tempAdjust;
    }

    public void setTempAdjust(String tempAdjust) {
        this.tempAdjust = tempAdjust == null ? null : tempAdjust.trim();
    }

    public String getLowVar() {
        return lowVar;
    }

    public void setLowVar(String lowVar) {
        this.lowVar = lowVar == null ? null : lowVar.trim();
    }

    public String getHighVar() {
        return highVar;
    }

    public void setHighVar(String highVar) {
        this.highVar = highVar == null ? null : highVar.trim();
    }

    public String getSetTemp() {
        return setTemp;
    }

    public void setSetTemp(String setTemp) {
        this.setTemp = setTemp == null ? null : setTemp.trim();
    }

    public String getSetPower() {
        return setPower;
    }

    public void setSetPower(String setPower) {
        this.setPower = setPower == null ? null : setPower.trim();
    }

    public String getSetFlux() {
        return setFlux;
    }

    public void setSetFlux(String setFlux) {
        this.setFlux = setFlux == null ? null : setFlux.trim();
    }

    public String getValveUpdatedate() {
        return valveUpdatedate;
    }

    public void setValveUpdatedate(String valveUpdatedate) {
        this.valveUpdatedate = valveUpdatedate;
    }

    public String getValveFlag() {
        return valveFlag;
    }

    public void setValveFlag(String valveFlag) {
        this.valveFlag = valveFlag == null ? null : valveFlag.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}