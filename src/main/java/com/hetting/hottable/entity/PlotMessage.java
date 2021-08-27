package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlotMessage {
    private Integer plotId;

    private String plotName;

    private String plotAddress;

    private String addressCode;

    private String plotBuilding;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date plotCreathotTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date plotEndhotTime;

    private String gpsLong;

    private String gpsLatitude;

    private String companyName;

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName == null ? null : plotName.trim();
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress == null ? null : plotAddress.trim();
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode == null ? null : addressCode.trim();
    }

    public String getPlotBuilding() {
        return plotBuilding;
    }

    public void setPlotBuilding(String plotBuilding) {
        this.plotBuilding = plotBuilding == null ? null : plotBuilding.trim();
    }

    public Date getPlotCreathotTime() {
        return plotCreathotTime;
    }

    public void setPlotCreathotTime(Date plotCreathotTime) {
        this.plotCreathotTime = plotCreathotTime;
    }

    public Date getPlotEndhotTime() {
        return plotEndhotTime;
    }

    public void setPlotEndhotTime(Date plotEndhotTime) {
        this.plotEndhotTime = plotEndhotTime;
    }

    public String getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(String gpsLong) {
        this.gpsLong = gpsLong == null ? null : gpsLong.trim();
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude == null ? null : gpsLatitude.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName== null ? null : companyName.trim();
    }
}