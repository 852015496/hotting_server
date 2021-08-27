package com.hetting.hottable.entity;

public class ConcentMessageVO {

    private Integer hotId;

    private Integer valveId;

    private Integer concentId;

    private Integer userId;
    //户名
    private String userName;
    //用户建筑面积
    private String userArea;
    //用户类型
    private String userType;
    // 用户小区
    private String userPlot;
    // 集中小区
    private String housing;
    // 楼号
    private String userBuilding;
    // 单元
    private String userCell;
    // 房间号
    private String userDoornum;
    // 用户集中器代码
    private String userConcentCode;
    //集中器抄表通道
    private String shortOut;
    //集中器心跳
    private String concentPant;
    //------------------------------------------------------------
    // 热表类型
    private String hotModal;
    //热表厂商代码
    private Integer hotManuCode;
    //接入通道
    private String hotAisle;
    //  热表地址
    private String hotAddress;
    //阀门厂家代码
    private String venderCode;
    //阀门接入通道
    private String valveChn;
    //阀门工作模式
    private Integer valveWorkMode;
    // 热表状态
    private String hotStatus;
    //热表厂商名称
    private String hotVenderName;
    // 最后一次上传的冷量
    private String lastCooling;
    // 最后一次上传的热量
    private String lastHotting;
    // 最后一次上传的累计流量
    private String lastVol;
    // 最后一次上传的瞬时流量
    private String lastFlowTime;
    // 最后一次上传的功率
    private String lastPower;
    // 最后一次上传的体积流量
    private String lastSumflow;
    // 最后一次上传的入口温度
    private String lastHotEntrance;
    // 最后一次上传的出口温度
    private String lastHotExit;
    //-------------------------------------------------------------------
    // 阀门工作模式
    private String lastValveWorkMode;
    // 阀门开度
    private String lastValveOpen;
    // 阀门状态
    private String valveStatus;
    // 阀门类型
    private String valveModal;
    //  阀门地址
    private String valveAddress;
    //  集中器代码
    private String concentCode;
    // 最后一次上传阀门工作模式
    private String lastValveRoomTemp;
    //用户温度设定
    private String setIndoorTemp;
    //阀门厂商名称
    private String valveVenderName;
    //开度
    private String opening;
    //最小开度
    private String minOpen;
    //最大开度
    private String maxOpen;
    //温控上限
    private String tempUpper;
    //温控下限
    private String tempLower;
    //设置温控值
    private String setTempValue;
    //设置功率
    private String setPower;
    //掉电开度
    private String powerOpening;
    //剪线关阀
    private String trimClosing;
    //防锈动作
    private String rustSport;
    //测温间隔
    private String tempInterval;
    //温度调节
    private String tempAdjust;
    //设置流速
    private String setFlow;
    //分摊热量初始值
    private String apportionHot;

//---------------------------------------------------------

    //信号强度
    private String gprs;
    // 通道1 mubs1
    private String tongdaodl1;
    // 通道2 mubs2
    private String tongdaodl2;
    // 通道2 mubs2
    private String tongdaodl3;
    // 通道2 mubs2
    private String tongdaodl4;
    // 通道状态
    private String tongdaostate;
    //电压值
    private String dianyaval;
    //电压开关
    private String dianyuankaiguan;
    // CCID
    private String simno;


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

    public String getGprs() {
        return gprs;
    }

    public void setGprs(String gprs) {
        this.gprs = gprs;
    }

    public String getTongdaodl1() {
        return tongdaodl1;
    }

    public void setTongdaodl1(String tongdaodl1) {
        this.tongdaodl1 = tongdaodl1;
    }

    public String getTongdaodl2() {
        return tongdaodl2;
    }

    public void setTongdaodl2(String tongdaodl2) {
        this.tongdaodl2 = tongdaodl2;
    }

    public String getTongdaodl3() {
        return tongdaodl3;
    }

    public void setTongdaodl3(String tongdaodl3) {
        this.tongdaodl3 = tongdaodl3;
    }

    public String getTongdaodl4() {
        return tongdaodl4;
    }

    public void setTongdaodl4(String tongdaodl4) {
        this.tongdaodl4 = tongdaodl4;
    }

    public String getTongdaostate() {
        return tongdaostate;
    }

    public void setTongdaostate(String tongdaostate) {
        this.tongdaostate = tongdaostate;
    }

    public String getDianyaval() {
        return dianyaval;
    }

    public void setDianyaval(String dianyaval) {
        this.dianyaval = dianyaval;
    }

    public String getDianyuankaiguan() {
        return dianyuankaiguan;
    }

    public void setDianyuankaiguan(String dianyuankaiguan) {
        this.dianyuankaiguan = dianyuankaiguan;
    }

    public String getSimno() {
        return simno;
    }

    public void setSimno(String simno) {
        this.simno = simno;
    }


    //----------------------------------------------------

    public String getConcentPant() {
        return concentPant;
    }

    public void setConcentPant(String concentPant) {
        this.concentPant = concentPant;
    }

    public String getShortOut() {
        return shortOut;
    }

    public void setShortOut(String shortOut) {
        this.shortOut = shortOut;
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

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public String getValveVenderName() {
        return valveVenderName;
    }

    public void setValveVenderName(String valveVenderName) {
        this.valveVenderName = valveVenderName;
    }

    public String getSetIndoorTemp() {
        return setIndoorTemp;
    }

    public void setSetIndoorTemp(String setIndoorTemp) {
        this.setIndoorTemp = setIndoorTemp;
    }

    public String getLastValveRoomTemp() {
        return lastValveRoomTemp;
    }

    public void setLastValveRoomTemp(String lastValveRoomTemp) {
        this.lastValveRoomTemp = lastValveRoomTemp;
    }

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPlot() {
        return userPlot;
    }

    public void setUserPlot(String userPlot) {
        this.userPlot = userPlot;
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding;
    }

    public String getUserCell() {
        return userCell;
    }

    public void setUserCell(String userCell) {
        this.userCell = userCell;
    }

    public String getUserDoornum() {
        return userDoornum;
    }

    public void setUserDoornum(String userDoornum) {
        this.userDoornum = userDoornum;
    }

    public String getUserConcentCode() {
        return userConcentCode;
    }

    public void setUserConcentCode(String userConcentCode) {
        this.userConcentCode = userConcentCode;
    }

    public String getHotModal() {
        return hotModal;
    }

    public void setHotModal(String hotModal) {
        this.hotModal = hotModal;
    }

    public String getLastCooling() {
        return lastCooling;
    }

    public void setLastCooling(String lastCooling) {
        this.lastCooling = lastCooling;
    }

    public String getLastHotting() {
        return lastHotting;
    }

    public void setLastHotting(String lastHotting) {
        this.lastHotting = lastHotting;
    }

    public String getLastVol() {
        return lastVol;
    }

    public void setLastVol(String lastVol) {
        this.lastVol = lastVol;
    }

    public String getLastFlowTime() {
        return lastFlowTime;
    }

    public void setLastFlowTime(String lastFlowTime) {
        this.lastFlowTime = lastFlowTime;
    }

    public String getLastPower() {
        return lastPower;
    }

    public void setLastPower(String lastPower) {
        this.lastPower = lastPower;
    }

    public String getLastSumflow() {
        return lastSumflow;
    }

    public void setLastSumflow(String lastSumflow) {
        this.lastSumflow = lastSumflow;
    }

    public String getLastHotEntrance() {
        return lastHotEntrance;
    }

    public void setLastHotEntrance(String lastHotEntrance) {
        this.lastHotEntrance = lastHotEntrance;
    }

    public String getLastHotExit() {
        return lastHotExit;
    }

    public void setLastHotExit(String lastHotExit) {
        this.lastHotExit = lastHotExit;
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
        this.lastValveOpen = lastValveOpen;
    }

    public String getValveModal() {
        return valveModal;
    }

    public void setValveModal(String valveModal) {
        this.valveModal = valveModal;
    }

    public String getHotAddress() {
        return hotAddress;
    }

    public void setHotAddress(String hotAddress) {
        this.hotAddress = hotAddress;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getHotManuCode() {
        return hotManuCode;
    }

    public void setHotManuCode(Integer hotManuCode) {
        this.hotManuCode = hotManuCode;
    }

    public String getVenderCode() {
        return venderCode;
    }

    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }

    public Integer getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(Integer valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public String getValveChn() {
        return valveChn;
    }

    public void setValveChn(String valveChn) {
        this.valveChn = valveChn;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }
}
