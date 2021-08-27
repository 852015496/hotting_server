package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AlarmDetails {

    private Long detailsId;

    private Integer alarmId;

    private String disposePeople;

    private String disposeCondition;

    private Integer disposeStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public String getDisposePeople() {
        return disposePeople;
    }

    public void setDisposePeople(String disposePeople) {
        this.disposePeople = disposePeople == null ? null : disposePeople.trim();
    }

    public String getDisposeCondition() {
        return disposeCondition;
    }

    public void setDisposeCondition(String disposeCondition) {
        this.disposeCondition = disposeCondition == null ? null : disposeCondition.trim();
    }

    public Integer getDisposeStatus() {
        return disposeStatus;
    }

    public void setDisposeStatus(Integer disposeStatus) {
        this.disposeStatus = disposeStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}