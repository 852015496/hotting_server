package com.hetting.hottable.entity;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class UserTemperature {

    //集中器代码
    private String concentCode;
    //阀门id
    private Integer valveId;
    //用户id
    private Integer userId;
    //阀门信息id
    private Long valveMid;
    //小区id
    private Integer plotId;
    //用户名
    private String userName;
    //换热站
    private String heatStation;
    //地址
    private String userAddress;
    //联系电话
    private String userContactWay;
    //设置室内温度温度
    private String indoorTemp;
    //室内温度
    private String valveRoomTemp;
    //阀门开度
    private String valveDefined;
    //最高温度
    private String maxTemp;
    //最小温度
    private String minTemp;
    //平均温度
    private Integer  avgTemp;
    //供暖状态
    private String heatingStatus;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //7天内的日期
    private String Date;
    //用户数量
    private Integer userNum;
    //小区地址
    private String plotAddress;
    //阀门工作模式
    private String valveWorkMode;
    //区间温度
    private String tempName;
    //供水温度
    private String hotEntrance;
    //回水温度
    private String hotExit;

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }

    public String getHotEntrance() {
        return hotEntrance;
    }

    public void setHotEntrance(String hotEntrance) {
        this.hotEntrance = hotEntrance;
    }

    public String getHotExit() {
        return hotExit;
    }

    public void setHotExit(String hotExit) {
        this.hotExit = hotExit;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public String getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(String valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeatStation() {
        return heatStation;
    }

    public void setHeatStation(String heatStation) {
        this.heatStation = heatStation;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserContactWay() {
        return userContactWay;
    }

    public void setUserContactWay(String userContactWay) {
        this.userContactWay = userContactWay;
    }

    public String getValveRoomTemp() {
        return valveRoomTemp;
    }

    public void setValveRoomTemp(String valveRoomTemp) {
        this.valveRoomTemp = valveRoomTemp;
    }

    public String getIndoorTemp() {
        return indoorTemp;
    }

    public void setIndoorTemp(String indoorTemp) {
        this.indoorTemp = indoorTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public Integer getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Integer avgTemp) {
        this.avgTemp = avgTemp;
    }

    public String getHeatingStatus() {
        return heatingStatus;
    }

    public void setHeatingStatus(String heatingStatus) {
        this.heatingStatus = heatingStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getValveDefined() {
        return valveDefined;
    }

    public void setValveDefined(String valveDefined) {
        this.valveDefined = valveDefined;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }
}
