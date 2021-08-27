package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class MeterData {

    //集中器id
    private Integer concentId;
    //集中器信息id
    private Long concentMid;
    //用户id
    private Integer userId;
    //热表信息id
    private Long hotMid;
    //热表id
    private Integer hotId;
    //阀门id
    private Integer valveId;
    //阀门信息id
    private Long valveMid;
    //集中器代码
    private String concentCode;
    //集中器小区地址
    private String housing;
    //集中器业务状态
    private String professional;
    //热表型号
    private String hotModal;
    //热表地址
    private String hotAddress;
    //热表口径
    private String cailber;
    //抄表时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date meterTime;
    //热表状态
    private String hotStatus;
    //当前热量   --> 热表信息表下
    private String hotting;
    //累计流量   --> 热表信息表下
    private String vol;
    //瞬时流量   --> 热表信息表下
    private String flowTime;
    //功率     --> 热表信息表下
    private String power;
    //入口温度   --> 热表信息表下
    private String hotEntrance;
    //出口温度   --> 热表信息表下
    private String hotExit;
    //热表累计时间
    private String addupTime;
    //热表通道
    private String hotAisle;
    //热表厂家地址
    private String hotVenderCode;
    //热表类型
    private String hotType;
    //开始时间  --> 热表信息表下
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    //结束时间  --> 热表信息表下
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    //阀门状态
    private String valveStatus;
    //阀门类型
    private String valveModal;
    //阀门地址
    private String valveAddress;
    //室内温度  -->阀门信息下
    private String valveRoomTemp;
    //设置温度
    private String setTemp;
    //户名
    private String userName;
    //用户楼号
    private String userBuilding;
    //用户单元
    private String userCell;
    //用户门牌
    private String userDoorNum;
    //用户面积
    private String userArea;
    //计费单价  -->备用字段
    private String standby;

    private String min;

    private String max;

    //-------------齐心字段--------Netty--------------------------
    private String num;
    private String resultType;
    private String requestTime;
    private String jzqCode;
    private String meterChannel;
    private String meterFac;
    private String meterType;
    private String meterAddr;
    private String status;
    private String createBy;
    private String responseTime;
    private String cold;
    private String hot;
    private String meterPower;
    private String speed;
    private String inTemp;
    private String ouTemp;
    private String workTime;
    private String readStatus;
    private String meterStatus;
    private String originalData;
    //----------------阀门设定---------------------------
    private String valveFlag;
    private String valveFac;
    private String valveChannel;
    private String valveType;
    private String valveAddr;
    private String setOpening;
    //---------------点名控阀-----------------------------
    private String actualOpening;
    private String cwqStatus;
    private String valveIntemp;
    private String valveOutemp;
    private String roomTemp1;
    private String roomTemp2;
    private String roomTemp3;
    private String roomTemp4;
    private String cwqTemp;
    private String valveOpenTime;
    private String shareHotNow;


    public String getActualOpening() {
        return actualOpening;
    }

    public void setActualOpening(String actualOpening) {
        this.actualOpening = actualOpening;
    }

    public String getCwqStatus() {
        return cwqStatus;
    }

    public void setCwqStatus(String cwqStatus) {
        this.cwqStatus = cwqStatus;
    }

    public String getValveIntemp() {
        return valveIntemp;
    }

    public void setValveIntemp(String valveIntemp) {
        this.valveIntemp = valveIntemp;
    }

    public String getValveOutemp() {
        return valveOutemp;
    }

    public void setValveOutemp(String valveOutemp) {
        this.valveOutemp = valveOutemp;
    }

    public String getRoomTemp1() {
        return roomTemp1;
    }

    public void setRoomTemp1(String roomTemp1) {
        this.roomTemp1 = roomTemp1;
    }

    public String getRoomTemp2() {
        return roomTemp2;
    }

    public void setRoomTemp2(String roomTemp2) {
        this.roomTemp2 = roomTemp2;
    }

    public String getRoomTemp3() {
        return roomTemp3;
    }

    public void setRoomTemp3(String roomTemp3) {
        this.roomTemp3 = roomTemp3;
    }

    public String getRoomTemp4() {
        return roomTemp4;
    }

    public void setRoomTemp4(String roomTemp4) {
        this.roomTemp4 = roomTemp4;
    }

    public String getCwqTemp() {
        return cwqTemp;
    }

    public void setCwqTemp(String cwqTemp) {
        this.cwqTemp = cwqTemp;
    }

    public String getValveOpenTime() {
        return valveOpenTime;
    }

    public void setValveOpenTime(String valveOpenTime) {
        this.valveOpenTime = valveOpenTime;
    }

    public String getShareHotNow() {
        return shareHotNow;
    }

    public void setShareHotNow(String shareHotNow) {
        this.shareHotNow = shareHotNow;
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public String getHotVenderCode() {
        return hotVenderCode;
    }

    public void setHotVenderCode(String hotVenderCode) {
        this.hotVenderCode = hotVenderCode;
    }

    public String getHotType() {
        return hotType;
    }

    public void setHotType(String hotType) {
        this.hotType = hotType;
    }

    public String getValveFlag() {
        return valveFlag;
    }

    public void setValveFlag(String valveFlag) {
        this.valveFlag = valveFlag;
    }

    public String getValveFac() {
        return valveFac;
    }

    public void setValveFac(String valveFac) {
        this.valveFac = valveFac;
    }

    public String getValveChannel() {
        return valveChannel;
    }

    public void setValveChannel(String valveChannel) {
        this.valveChannel = valveChannel;
    }

    public String getValveType() {
        return valveType;
    }

    public void setValveType(String valveType) {
        this.valveType = valveType;
    }

    public String getValveAddr() {
        return valveAddr;
    }

    public void setValveAddr(String valveAddr) {
        this.valveAddr = valveAddr;
    }

    public String getSetOpening() {
        return setOpening;
    }

    public void setSetOpening(String setOpening) {
        this.setOpening = setOpening;
    }

    public String getOriginalData() {
        return originalData;
    }

    public void setOriginalData(String originalData) {
        this.originalData = originalData;
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getMeterPower() {
        return meterPower;
    }

    public void setMeterPower(String meterPower) {
        this.meterPower = meterPower;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getInTemp() {
        return inTemp;
    }

    public void setInTemp(String inTemp) {
        this.inTemp = inTemp;
    }

    public String getOuTemp() {
        return ouTemp;
    }

    public void setOuTemp(String ouTemp) {
        this.ouTemp = ouTemp;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getMeterStatus() {
        return meterStatus;
    }

    public void setMeterStatus(String meterStatus) {
        this.meterStatus = meterStatus;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getJzqCode() {
        return jzqCode;
    }

    public void setJzqCode(String jzqCode) {
        this.jzqCode = jzqCode;
    }

    public String getMeterChannel() {
        return meterChannel;
    }

    public void setMeterChannel(String meterChannel) {
        this.meterChannel = meterChannel;
    }

    public String getMeterFac() {
        return meterFac;
    }

    public void setMeterFac(String meterFac) {
        this.meterFac = meterFac;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public String getMeterAddr() {
        return meterAddr;
    }

    public void setMeterAddr(String meterAddr) {
        this.meterAddr = meterAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }

    public Long getConcentMid() {
        return concentMid;
    }

    public void setConcentMid(Long concentMid) {
        this.concentMid = concentMid;
    }

    public Long getValveMid() {
        return valveMid;
    }

    public Long getHotMid() {
        return hotMid;
    }

    public void setHotMid(Long hotMid) {
        this.hotMid = hotMid;
    }

    public void setValveMid(Long valveMid) {
        this.valveMid = valveMid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getHotModal() {
        return hotModal;
    }

    public void setHotModal(String hotModal) {
        this.hotModal = hotModal;
    }

    public String getHotAddress() {
        return hotAddress;
    }

    public void setHotAddress(String hotAddress) {
        this.hotAddress = hotAddress;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public String getValveRoomTemp() {
        return valveRoomTemp;
    }

    public void setValveRoomTemp(String valveRoomTemp) {
        this.valveRoomTemp = valveRoomTemp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserDoorNum() {
        return userDoorNum;
    }

    public void setUserDoorNum(String userDoorNum) {
        this.userDoorNum = userDoorNum;
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby;
    }

    public String getHotting() {
        return hotting;
    }

    public void setHotting(String hotting) {
        this.hotting = hotting;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(String flowTime) {
        this.flowTime = flowTime;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
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

    public String getAddupTime() {
        return addupTime;
    }

    public void setAddupTime(String addupTime) {
        this.addupTime = addupTime;
    }

    public String getSetTemp() {
        return setTemp;
    }

    public void setSetTemp(String setTemp) {
        this.setTemp = setTemp;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getCailber() {
        return cailber;
    }

    public void setCailber(String cailber) {
        this.cailber = cailber;
    }

    public String getValveModal() {
        return valveModal;
    }

    public void setValveModal(String valveModal) {
        this.valveModal = valveModal;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public Date getMeterTime() {
        return meterTime;
    }

    public void setMeterTime(Date meterTime) {
        this.meterTime = meterTime;
    }
}
