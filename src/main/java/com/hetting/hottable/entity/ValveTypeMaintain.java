package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ValveTypeMaintain {

    private Integer valveTypeId;

    private String valveVenderName;

    private String dealerName;

    private String valveType;

    private String protocolName;

    private String caliber;

    private String minOpen;

    private String maxOpen;

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

    public Integer getValveTypeId() {
        return valveTypeId;
    }

    public void setValveTypeId(Integer valveTypeId) {
        this.valveTypeId = valveTypeId;
    }

    public String getValveVenderName() {
        return valveVenderName;
    }

    public void setValveVenderName(String valveVenderName) {
        this.valveVenderName = valveVenderName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getValveType() {
        return valveType;
    }

    public void setValveType(String valveType) {
        this.valveType = valveType == null ? null : valveType.trim();
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

    public String getMinOpen() {
        return minOpen;
    }

    public void setMinOpen(String minOpen) {
        this.minOpen = minOpen == null ? null : minOpen.trim();
    }

    public String getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(String maxOpen) {
        this.maxOpen = maxOpen == null ? null : maxOpen.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}