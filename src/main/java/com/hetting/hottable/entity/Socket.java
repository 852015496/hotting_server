package com.hetting.hottable.entity;

public class Socket {
    private Integer socketId;

    private String socketName;

    private String socketAddress;

    private String imei;

    private String ccid;

    private String readinterval;

    private String mainserverAddress;

    private String gprsUploudtime;

    //备用服务器地址
    private String resServerAddress;
    // 温度
    private String tempPerature;
    // 信号强度
    private String signalIntensity;

    public Integer getSocketId() {
        return socketId;
    }

    public void setSocketId(Integer socketId) {
        this.socketId = socketId;
    }

    public String getSocketName() {
        return socketName;
    }

    public void setSocketName(String socketName) {
        this.socketName = socketName == null ? null : socketName.trim();
    }

    public String getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(String socketAddress) {
        this.socketAddress = socketAddress == null ? null : socketAddress.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid == null ? null : ccid.trim();
    }

    public String getReadinterval() {
        return readinterval;
    }

    public void setReadinterval(String readinterval) {
        this.readinterval = readinterval == null ? null : readinterval.trim();
    }

    public String getMainserverAddress() {
        return mainserverAddress;
    }

    public void setMainserverAddress(String mainserverAddress) {
        this.mainserverAddress = mainserverAddress == null ? null : mainserverAddress.trim();
    }

    public String getGprsUploudtime() {
        return gprsUploudtime;
    }

    public void setGprsUploudtime(String gprsUploudtime) {
        this.gprsUploudtime = gprsUploudtime == null ? null : gprsUploudtime.trim();
    }

    public String getResServerAddress() {
        return resServerAddress;
    }

    public void setResServerAddress(String resServerAddress) {
        this.resServerAddress = resServerAddress;
    }

    public String getTempPerature() {
        return tempPerature;
    }

    public void setTempPerature(String tempPerature) {
        this.tempPerature = tempPerature;
    }

    public String getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(String signalIntensity) {
        this.signalIntensity = signalIntensity;
    }
}