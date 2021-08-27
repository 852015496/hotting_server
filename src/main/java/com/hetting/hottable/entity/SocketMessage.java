package com.hetting.hottable.entity;

import java.util.Date;

public class SocketMessage {
    private Long socketId;

    private Integer socSocketId;

    private Long concentmId;

    private Date lastDate;

    private String dataTemp;

    private Date loadTime;

    public Long getSocketId() {
        return socketId;
    }

    public void setSocketId(Long socketId) {
        this.socketId = socketId;
    }

    public Integer getSocSocketId() {
        return socSocketId;
    }

    public void setSocSocketId(Integer socSocketId) {
        this.socSocketId = socSocketId;
    }

    public Long getConcentmId() {
        return concentmId;
    }

    public void setConcentmId(Long concentmId) {
        this.concentmId = concentmId;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getDataTemp() {
        return dataTemp;
    }

    public void setDataTemp(String dataTemp) {
        this.dataTemp = dataTemp == null ? null : dataTemp.trim();
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }
}