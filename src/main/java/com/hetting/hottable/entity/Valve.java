package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;

import java.util.Date;

public class Valve {
    private Integer valveId;

    private Integer userId;

    private String callber;

    private Integer concentId;

    private String valveAddress;

    private String venderCode;

    private String venderName;

    private String venderAddress;

    private String venderContact;

    private String vemderPhone;

    private String dealerName;

    private String dealerAddress;

    private String dealerContact;

    private String dealerPhone;

    private String valveChn;

    private String valveBus;

    private String valveArrflag;

    private String wireless;

    private String openrate;

    private Integer valveStatus;

    private String valveModal;

    private String valveWorkMode;

    private String lastValveWorkMode;

    private String lastValveOpen;

    private String lastOpenMin;

    private String lastOpenMax;

    private String lastAntirusttmp;

    private String lastSetTemp;

    private String lastTestinterjust;

    private String lastTestpycle;

    private String lastTempadjust;

    private String lastLowVar;

    private String lastHighVar;

    private String lastValveRoomTemp;

    private String lastPower;

    private String lastFlux;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedate;

    private String lastFlag;

    private String valveDefined;

    private String setIndoorTemp;

    private String valveVenderName;

    private String opening;

    private String minOpen;

    private String maxOpen;

    private String tempUpper;

    private String tempLower;

    private String setTempValue;

    private String setPower;

    private String setFlow;

    private String apportionHot;

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

    public String getLastSetTemp() {
        return lastSetTemp;
    }

    public void setLastSetTemp(String lastSetTemp) {
        this.lastSetTemp = lastSetTemp;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCallber() {
        return callber;
    }

    public void setCallber(String callber) {
        this.callber = callber == null ? null : callber.trim();
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
        this.venderCode = venderCode == null ? null : venderCode.trim();
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName == null ? null : venderName.trim();
    }

    public String getVenderAddress() {
        return venderAddress;
    }

    public void setVenderAddress(String venderAddress) {
        this.venderAddress = venderAddress == null ? null : venderAddress.trim();
    }

    public String getVenderContact() {
        return venderContact;
    }

    public void setVenderContact(String venderContact) {
        this.venderContact = venderContact == null ? null : venderContact.trim();
    }

    public String getVemderPhone() {
        return vemderPhone;
    }

    public void setVemderPhone(String vemderPhone) {
        this.vemderPhone = vemderPhone == null ? null : vemderPhone.trim();
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress == null ? null : dealerAddress.trim();
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact == null ? null : dealerContact.trim();
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone == null ? null : dealerPhone.trim();
    }

    public String getValveChn() {
        return valveChn;
    }

    public void setValveChn(String valveChn) {
        this.valveChn = valveChn;
    }

    public String getValveBus() {
        return valveBus;
    }

    public void setValveBus(String valveBus) {
        this.valveBus = valveBus;
    }

    public String getValveArrflag() {
        return valveArrflag;
    }

    public void setValveArrflag(String valveArrflag) {
        this.valveArrflag = valveArrflag;
    }

    public String getWireless() {
        return wireless;
    }

    public void setWireless(String wireless) {
        this.wireless = wireless;
    }

    public String getOpenrate() {
        return openrate;
    }

    public void setOpenrate(String openrate) {
        this.openrate = openrate == null ? null : openrate.trim();
    }

    public Integer getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(Integer valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveModal() {
        return valveModal;
    }

    public void setValveModal(String valveModal) {
        this.valveModal = valveModal == null ? null : valveModal.trim();
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
        this.lastValveOpen = lastValveOpen == null ? null : lastValveOpen.trim();
    }

    public String getLastOpenMin() {
        return lastOpenMin;
    }

    public void setLastOpenMin(String lastOpenMin) {
        this.lastOpenMin = lastOpenMin == null ? null : lastOpenMin.trim();
    }

    public String getLastOpenMax() {
        return lastOpenMax;
    }

    public void setLastOpenMax(String lastOpenMax) {
        this.lastOpenMax = lastOpenMax == null ? null : lastOpenMax.trim();
    }

    public String getLastAntirusttmp() {
        return lastAntirusttmp;
    }

    public void setLastAntirusttmp(String lastAntirusttmp) {
        this.lastAntirusttmp = lastAntirusttmp == null ? null : lastAntirusttmp.trim();
    }

    public String getLastTestinterjust() {
        return lastTestinterjust;
    }

    public void setLastTestinterjust(String lastTestinterjust) {
        this.lastTestinterjust = lastTestinterjust == null ? null : lastTestinterjust.trim();
    }

    public String getLastTestpycle() {
        return lastTestpycle;
    }

    public void setLastTestpycle(String lastTestpycle) {
        this.lastTestpycle = lastTestpycle == null ? null : lastTestpycle.trim();
    }

    public String getLastTempadjust() {
        return lastTempadjust;
    }

    public void setLastTempadjust(String lastTempadjust) {
        this.lastTempadjust = lastTempadjust == null ? null : lastTempadjust.trim();
    }

    public String getLastLowVar() {
        return lastLowVar;
    }

    public void setLastLowVar(String lastLowVar) {
        this.lastLowVar = lastLowVar == null ? null : lastLowVar.trim();
    }

    public String getLastHighVar() {
        return lastHighVar;
    }

    public void setLastHighVar(String lastHighVar) {
        this.lastHighVar = lastHighVar == null ? null : lastHighVar.trim();
    }

    public String getLastPower() {
        return lastPower;
    }

    public void setLastPower(String lastPower) {
        this.lastPower = lastPower == null ? null : lastPower.trim();
    }

    public String getLastFlux() {
        return lastFlux;
    }

    public void setLastFlux(String lastFlux) {
        this.lastFlux = lastFlux == null ? null : lastFlux.trim();
    }

    public Date getLastUpdatedate() {
        return lastUpdatedate;
    }

    public void setLastUpdatedate(Date lastUpdatedate) {
        this.lastUpdatedate = lastUpdatedate;
    }

    public String getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(String lastFlag) {
        this.lastFlag = lastFlag == null ? null : lastFlag.trim();
    }

    public String getValveDefined() {
        return valveDefined;
    }

    public void setValveDefined(String valveDefined) {
        this.valveDefined = valveDefined;
    }

    public String getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(String valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
    }


    public String getLastValveRoomTemp() {
        return lastValveRoomTemp;
    }

    public void setLastValveRoomTemp(String lastValveRoomTemp) {
        this.lastValveRoomTemp = lastValveRoomTemp;
    }

    public String getSetIndoorTemp() {
        return setIndoorTemp;
    }

    public void setSetIndoorTemp(String setIndoorTemp) {
        this.setIndoorTemp = setIndoorTemp;
    }
}