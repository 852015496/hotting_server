package com.hetting.hottable.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private Integer valveId;

    private Integer plotId;

    private Integer hotId;

    private Integer concentId;

    private Integer socketId;

    private String userName;

    private Integer userSex;

    private String userAddress;

    private String userContactway;

    private String userPlot;

    private String userBuilding;

    private String userCell;

    private String userDoornum;

    private String userIdType;

    private Date userCreattime;

    private String userCode;

    private String userOperator;

    private Long userSum;

    private Integer payType;

    private String userType;

    private String userArea;

    private String userConcentCode;

    private Integer userNum;

    private String plotAddress;

    private String hotting;

    public String getHotting() {
        return hotting;
    }

    public void setHotting(String hotting) {
        this.hotting = hotting;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
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

    public Integer getSocketId() {
        return socketId;
    }

    public void setSocketId(Integer socketId) {
        this.socketId = socketId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserContactway() {
        return userContactway;
    }

    public void setUserContactway(String userContactway) {
        this.userContactway = userContactway == null ? null : userContactway.trim();
    }

    public String getUserPlot() {
        return userPlot;
    }

    public void setUserPlot(String userPlot) {
        this.userPlot = userPlot == null ? null : userPlot.trim();
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding == null ? null : userBuilding.trim();
    }

    public String getUserCell() {
        return userCell;
    }

    public void setUserCell(String userCell) {
        this.userCell = userCell == null ? null : userCell.trim();
    }

    public String getUserDoornum() {
        return userDoornum;
    }

    public void setUserDoornum(String userDoornum) {
        this.userDoornum = userDoornum == null ? null : userDoornum.trim();
    }

    public String getUserIdType() {
        return userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType == null ? null : userIdType.trim();
    }

    public Date getUserCreattime() {
        return userCreattime;
    }

    public void setUserCreattime(Date userCreattime) {
        this.userCreattime = userCreattime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserOperator() {
        return userOperator;
    }

    public void setUserOperator(String userOperator) {
        this.userOperator = userOperator == null ? null : userOperator.trim();
    }

    public Long getUserSum() {
        return userSum;
    }

    public void setUserSum(Long userSum) {
        this.userSum = userSum;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea == null ? null : userArea.trim();
    }

    public String getUserConcentCode() {
        return userConcentCode;
    }

    public void setUserConcentCode(String userConcentCode) {
        this.userConcentCode = userConcentCode == null ? null : userConcentCode.trim();
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }
}