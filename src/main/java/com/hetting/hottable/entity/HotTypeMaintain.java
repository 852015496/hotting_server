package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HotTypeMaintain {

    private Integer hotTypeId;

    private String hotVenderName;

    private String dealerName;

    private String hotType;

    private String protocolName;

    private String caliber;

    private String maxPower;

    private String maxFlux;

    private String maxProvideTemp;

    private String maxReturnTemp;

    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date creatTime;

    private String supplierAddress;

    private String supplierContact;

    private String supplierPhone;

    private String dealerAddress;

    private String dealerContact;

    private String dealerPhone;

    private String protocolType;

    private String protocolCode;

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact;
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getProtocolCode() {
        return protocolCode;
    }

    public void setProtocolCode(String protocolCode) {
        this.protocolCode = protocolCode;
    }

    public Integer getHotTypeId() {
        return hotTypeId;
    }

    public void setHotTypeId(Integer hotTypeId) {
        this.hotTypeId = hotTypeId;
    }

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getHotType() {
        return hotType;
    }

    public void setHotType(String hotType) {
        this.hotType = hotType == null ? null : hotType.trim();
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber == null ? null : caliber.trim();
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower == null ? null : maxPower.trim();
    }

    public String getMaxFlux() {
        return maxFlux;
    }

    public void setMaxFlux(String maxFlux) {
        this.maxFlux = maxFlux == null ? null : maxFlux.trim();
    }

    public String getMaxProvideTemp() {
        return maxProvideTemp;
    }

    public void setMaxProvideTemp(String maxProvideTemp) {
        this.maxProvideTemp = maxProvideTemp == null ? null : maxProvideTemp.trim();
    }

    public String getMaxReturnTemp() {
        return maxReturnTemp;
    }

    public void setMaxReturnTemp(String maxReturnTemp) {
        this.maxReturnTemp = maxReturnTemp == null ? null : maxReturnTemp.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}