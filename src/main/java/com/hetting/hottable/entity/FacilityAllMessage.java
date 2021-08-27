package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class FacilityAllMessage {
    //集中器代码
    private String concentCode;
    //集中器地址
    private String concentAddress;
    //集中器服务地址1
    private String serverAddress1;
    //集中器服务地址2
    private String serverAddress2;
    //集中器类型
    private String concentType;
    //小区
    private String housing;
    //单元
    private String cell;
    //楼号
    private String building;
    //房间号
    private String roomnum;
    //集中器状态     1:正常 2:异常 3:修复
    private Integer concentStatus;
    //集中器间隔
    private String concentGap;
    //通道短路
    private String lastShortOut;
    //通信时间
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private String lastCommunicationDate;
    //仪表数量
    private String materNum;
    //故障仪表
    private Integer lastFaultMater;
    //阀门数量
    private String valveNum;
    //阀门地址
    private String valveCode;
    //故障阀门
    private Integer lastFaultValve;
    //抄表类型
    private String concentModal;
    //业务状态
    private String professional;
    //集中器总数
    private Integer concentCount;
    //  故障总数
    private String faultNum;
    //正常总数
    private String normalNum;
    //热表总数
    private Integer hotCount;
    //阀门总数
    private Integer valveCount;
    //故障集中器总数
    private Integer faultConcentCount;
    //故障热表总数
    private Integer faultHotCount;
    //故障阀门总数
    private Integer faultValveCount;
    //室内温度
    private String lastValveRoomTemp;

    private String address;

    private String concentIp1;

    private String concentIp2;

    private String concentUpdatedate;

    private String workTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private Date lastTime;

    private String shortOut;

    private Integer faultMater;

    private Integer faultValve;

    private String phoneId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private String communicationDate;

    private String concentProfessionalWork;

    private String concentPant;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String hottableName;

    private Integer hottableNumber;

    private String hottableAddress;

    private String hotType;

    private String hotAisle;

    private Integer hotManuCode;

    private String cailber;

    private String hotStatus;

    private String hotModal;

    private String lastCooling;

    private String lastHotting;

    private String lastVol;

    private String lastWorktime;

    private String lastFlowTime;

    private String lastPower;

    private String lastSumflow;

    private String lastHotEntrance;

    private String lastHotExit;

    private String hotAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  hotMaterDate;

    private String hotVenderName;

    private String cooling;

    private String hotting;

    private String vol;

    private String worktime;

    private String flowTime;

    private String power;

    private String sumflow;

    private String hotEntrance;

    private String hotExit;

    private String hotStatusName;

    private String hotUnusualName;
    // 仪表地址代码
    private String hotCode;

    private String valveAddress;

    private String venderCode;

    private String venderName;

    private String venderAddress;

    private String venderContact;

    private String vemderPhone;

    private String dealerName;

    private String dealerAddress;

    private String dealerContact;

    private String dealerPhone;

    private String valveChn;

    private String valveBus;

    private String valveArrflag;

    private String wireless;

    private String openrate;

    private Integer valveStatus;

    private String valveModal;

    private String valveWorkMode;

    private String lastValveWorkMode;

    private String lastValveOpen;

    private String lastOpenMin;

    private String lastOpenMax;

    private String lastAntirusttmp;

    private String lastSetTemp;

    private String lastTestinterjust;

    private String lastTestpycle;

    private String lastTempadjust;

    private String lastLowVar;

    private String lastHighVar;

    private String lastFlux;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedate;

    private String lastFlag;

    private String valveDefined;

    private String setIndoorTemp;

    private String valveVenderName;

    private String opening;

    private String minOpen;

    private String maxOpen;

    private String tempUpper;

    private String tempLower;

    private String setTempValue;

    private String setPower;

    private String setFlow;

    private String apportionHot;

    private String powerOpening;

    private String trimClosing;

    private String rustSport;

    private String tempInterval;

    private String tempAdjust;

    private String valveOpen;

    private String valveOpenMin;

    private String valveOpenMax;

    private String valveAntirusttmo;

    private String testinterjust;

    private String testPycle;

    private String lowVar;

    private String highVar;

    private String setTemp;

    private String setFlux;

    private Date valveUpdatedate;

    private String valveFlag;

    private String avgTemp;

    private String hotValveNum;

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

    private String protocolType;

    private String protocolCode;

    private String valveType;

    private Integer userId;

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

//--------------------------------------------
    //信号强度
    private String gprs;
    //抄表方式
    private String chaobiaofs;
    //抄表间隔 实时上传 间隔上传
    private String chaobiaojg;
    //下次通讯日期
    private String xiacitxrq;
    // 通讯日期
    private String tongxunrq;
    //服务器地址选择日期
    private String fuwuqdzxzrq;
    //仪表状态码2
    private String stat1;
    //仪表状态码2
    private String stat2;
    //通道1
    private String channel1;
    //通道2
    private String channel2;
    //通道3
    private String channel3;
    //通道4
    private String channel4;
    //状态485
    private String status485;
    //lora 状态
    private String statusloar;
    //输出电源开关状态
    private String statusout;
    //4G/NB信号强度
    private String nblevel;





    //------------------get and set-----------------


    public String getChannel1() {
        return channel1;
    }

    public void setChannel1(String channel1) {
        this.channel1 = channel1;
    }

    public String getChannel2() {
        return channel2;
    }

    public void setChannel2(String channel2) {
        this.channel2 = channel2;
    }

    public String getChannel3() {
        return channel3;
    }

    public void setChannel3(String channel3) {
        this.channel3 = channel3;
    }

    public String getChannel4() {
        return channel4;
    }

    public void setChannel4(String channel4) {
        this.channel4 = channel4;
    }

    public String getStatus485() {
        return status485;
    }

    public void setStatus485(String status485) {
        this.status485 = status485;
    }

    public String getStatusloar() {
        return statusloar;
    }

    public void setStatusloar(String statusloar) {
        this.statusloar = statusloar;
    }

    public String getStatusout() {
        return statusout;
    }

    public void setStatusout(String statusout) {
        this.statusout = statusout;
    }

    public String getNblevel() {
        return nblevel;
    }

    public void setNblevel(String nblevel) {
        this.nblevel = nblevel;
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1;
    }

    public String getStat2() {
        return stat2;
    }

    public void setStat2(String stat2) {
        this.stat2 = stat2;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.userAddress = userAddress;
    }

    public String getUserContactway() {
        return userContactway;
    }

    public void setUserContactway(String userContactway) {
        this.userContactway = userContactway;
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

    public String getUserIdType() {
        return userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
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
        this.userCode = userCode;
    }

    public String getUserOperator() {
        return userOperator;
    }

    public void setUserOperator(String userOperator) {
        this.userOperator = userOperator;
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
        this.userType = userType;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserConcentCode() {
        return userConcentCode;
    }

    public void setUserConcentCode(String userConcentCode) {
        this.userConcentCode = userConcentCode;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public String getValveCode() {
        return valveCode;
    }

    public void setValveCode(String valveCode) {
        this.valveCode = valveCode;
    }

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }

    public String getConcentAddress() {
        return concentAddress;
    }

    public void setConcentAddress(String concentAddress) {
        this.concentAddress = concentAddress;
    }

    public String getServerAddress1() {
        return serverAddress1;
    }

    public void setServerAddress1(String serverAddress1) {
        this.serverAddress1 = serverAddress1;
    }

    public String getServerAddress2() {
        return serverAddress2;
    }

    public void setServerAddress2(String serverAddress2) {
        this.serverAddress2 = serverAddress2;
    }

    public String getConcentType() {
        return concentType;
    }

    public void setConcentType(String concentType) {
        this.concentType = concentType;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public Integer getConcentStatus() {
        return concentStatus;
    }

    public void setConcentStatus(Integer concentStatus) {
        this.concentStatus = concentStatus;
    }

    public String getConcentGap() {
        return concentGap;
    }

    public void setConcentGap(String concentGap) {
        this.concentGap = concentGap;
    }

    public String getLastShortOut() {
        return lastShortOut;
    }

    public void setLastShortOut(String lastShortOut) {
        this.lastShortOut = lastShortOut;
    }

    public String getLastCommunicationDate() {
        return lastCommunicationDate;
    }

    public void setLastCommunicationDate(String lastCommunicationDate) {
        this.lastCommunicationDate = lastCommunicationDate;
    }

    public String getMaterNum() {
        return materNum;
    }

    public void setMaterNum(String materNum) {
        this.materNum = materNum;
    }

    public Integer getLastFaultMater() {
        return lastFaultMater;
    }

    public void setLastFaultMater(Integer lastFaultMater) {
        this.lastFaultMater = lastFaultMater;
    }

    public String getValveNum() {
        return valveNum;
    }

    public void setValveNum(String valveNum) {
        this.valveNum = valveNum;
    }

    public Integer getLastFaultValve() {
        return lastFaultValve;
    }

    public void setLastFaultValve(Integer lastFaultValve) {
        this.lastFaultValve = lastFaultValve;
    }

    public String getConcentModal() {
        return concentModal;
    }

    public void setConcentModal(String concentModal) {
        this.concentModal = concentModal;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getConcentCount() {
        return concentCount;
    }

    public void setConcentCount(Integer concentCount) {
        this.concentCount = concentCount;
    }

    public String getFaultNum() {
        return faultNum;
    }

    public void setFaultNum(String faultNum) {
        this.faultNum = faultNum;
    }

    public String getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(String normalNum) {
        this.normalNum = normalNum;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }

    public Integer getValveCount() {
        return valveCount;
    }

    public void setValveCount(Integer valveCount) {
        this.valveCount = valveCount;
    }

    public Integer getFaultConcentCount() {
        return faultConcentCount;
    }

    public void setFaultConcentCount(Integer faultConcentCount) {
        this.faultConcentCount = faultConcentCount;
    }

    public Integer getFaultHotCount() {
        return faultHotCount;
    }

    public void setFaultHotCount(Integer faultHotCount) {
        this.faultHotCount = faultHotCount;
    }

    public Integer getFaultValveCount() {
        return faultValveCount;
    }

    public void setFaultValveCount(Integer faultValveCount) {
        this.faultValveCount = faultValveCount;
    }

    public String getLastValveRoomTemp() {
        return lastValveRoomTemp;
    }

    public void setLastValveRoomTemp(String lastValveRoomTemp) {
        this.lastValveRoomTemp = lastValveRoomTemp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConcentIp1() {
        return concentIp1;
    }

    public void setConcentIp1(String concentIp1) {
        this.concentIp1 = concentIp1;
    }

    public String getConcentIp2() {
        return concentIp2;
    }

    public void setConcentIp2(String concentIp2) {
        this.concentIp2 = concentIp2;
    }

    public String getConcentUpdatedate() {
        return concentUpdatedate;
    }

    public void setConcentUpdatedate(String concentUpdatedate) {
        this.concentUpdatedate = concentUpdatedate;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getShortOut() {
        return shortOut;
    }

    public void setShortOut(String shortOut) {
        this.shortOut = shortOut;
    }

    public Integer getFaultMater() {
        return faultMater;
    }

    public void setFaultMater(Integer faultMater) {
        this.faultMater = faultMater;
    }

    public Integer getFaultValve() {
        return faultValve;
    }

    public void setFaultValve(Integer faultValve) {
        this.faultValve = faultValve;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(String communicationDate) {
        this.communicationDate = communicationDate;
    }

    public String getConcentProfessionalWork() {
        return concentProfessionalWork;
    }

    public void setConcentProfessionalWork(String concentProfessionalWork) {
        this.concentProfessionalWork = concentProfessionalWork;
    }

    public String getConcentPant() {
        return concentPant;
    }

    public void setConcentPant(String concentPant) {
        this.concentPant = concentPant;
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

    public String getHottableName() {
        return hottableName;
    }

    public void setHottableName(String hottableName) {
        this.hottableName = hottableName;
    }

    public Integer getHottableNumber() {
        return hottableNumber;
    }

    public void setHottableNumber(Integer hottableNumber) {
        this.hottableNumber = hottableNumber;
    }

    public String getHottableAddress() {
        return hottableAddress;
    }

    public void setHottableAddress(String hottableAddress) {
        this.hottableAddress = hottableAddress;
    }

    public String getHotType() {
        return hotType;
    }

    public void setHotType(String hotType) {
        this.hotType = hotType;
    }

    public String getHotAisle() {
        return hotAisle;
    }

    public void setHotAisle(String hotAisle) {
        this.hotAisle = hotAisle;
    }

    public Integer getHotManuCode() {
        return hotManuCode;
    }

    public void setHotManuCode(Integer hotManuCode) {
        this.hotManuCode = hotManuCode;
    }

    public String getCailber() {
        return cailber;
    }

    public void setCailber(String cailber) {
        this.cailber = cailber;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
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

    public String getLastWorktime() {
        return lastWorktime;
    }

    public void setLastWorktime(String lastWorktime) {
        this.lastWorktime = lastWorktime;
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

    public String getHotAddress() {
        return hotAddress;
    }

    public void setHotAddress(String hotAddress) {
        this.hotAddress = hotAddress;
    }

    public Date getHotMaterDate() {
        return hotMaterDate;
    }

    public void setHotMaterDate(Date hotMaterDate) {
        this.hotMaterDate = hotMaterDate;
    }

    public String getHotVenderName() {
        return hotVenderName;
    }

    public void setHotVenderName(String hotVenderName) {
        this.hotVenderName = hotVenderName;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
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

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
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

    public String getSumflow() {
        return sumflow;
    }

    public void setSumflow(String sumflow) {
        this.sumflow = sumflow;
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

    public String getHotStatusName() {
        return hotStatusName;
    }

    public void setHotStatusName(String hotStatusName) {
        this.hotStatusName = hotStatusName;
    }

    public String getHotUnusualName() {
        return hotUnusualName;
    }

    public void setHotUnusualName(String hotUnusualName) {
        this.hotUnusualName = hotUnusualName;
    }

    public String getHotCode() {
        return hotCode;
    }

    public void setHotCode(String hotCode) {
        this.hotCode = hotCode;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public String getVenderCode() {
        return venderCode;
    }

    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getVenderAddress() {
        return venderAddress;
    }

    public void setVenderAddress(String venderAddress) {
        this.venderAddress = venderAddress;
    }

    public String getVenderContact() {
        return venderContact;
    }

    public void setVenderContact(String venderContact) {
        this.venderContact = venderContact;
    }

    public String getVemderPhone() {
        return vemderPhone;
    }

    public void setVemderPhone(String vemderPhone) {
        this.vemderPhone = vemderPhone;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
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

    public String getValveChn() {
        return valveChn;
    }

    public void setValveChn(String valveChn) {
        this.valveChn = valveChn;
    }

    public String getValveBus() {
        return valveBus;
    }

    public void setValveBus(String valveBus) {
        this.valveBus = valveBus;
    }

    public String getValveArrflag() {
        return valveArrflag;
    }

    public void setValveArrflag(String valveArrflag) {
        this.valveArrflag = valveArrflag;
    }

    public String getWireless() {
        return wireless;
    }

    public void setWireless(String wireless) {
        this.wireless = wireless;
    }

    public String getOpenrate() {
        return openrate;
    }

    public void setOpenrate(String openrate) {
        this.openrate = openrate;
    }

    public Integer getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(Integer valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveModal() {
        return valveModal;
    }

    public void setValveModal(String valveModal) {
        this.valveModal = valveModal;
    }

    public String getValveWorkMode() {
        return valveWorkMode;
    }

    public void setValveWorkMode(String valveWorkMode) {
        this.valveWorkMode = valveWorkMode;
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

    public String getLastOpenMin() {
        return lastOpenMin;
    }

    public void setLastOpenMin(String lastOpenMin) {
        this.lastOpenMin = lastOpenMin;
    }

    public String getLastOpenMax() {
        return lastOpenMax;
    }

    public void setLastOpenMax(String lastOpenMax) {
        this.lastOpenMax = lastOpenMax;
    }

    public String getLastAntirusttmp() {
        return lastAntirusttmp;
    }

    public void setLastAntirusttmp(String lastAntirusttmp) {
        this.lastAntirusttmp = lastAntirusttmp;
    }

    public String getLastSetTemp() {
        return lastSetTemp;
    }

    public void setLastSetTemp(String lastSetTemp) {
        this.lastSetTemp = lastSetTemp;
    }

    public String getLastTestinterjust() {
        return lastTestinterjust;
    }

    public void setLastTestinterjust(String lastTestinterjust) {
        this.lastTestinterjust = lastTestinterjust;
    }

    public String getLastTestpycle() {
        return lastTestpycle;
    }

    public void setLastTestpycle(String lastTestpycle) {
        this.lastTestpycle = lastTestpycle;
    }

    public String getLastTempadjust() {
        return lastTempadjust;
    }

    public void setLastTempadjust(String lastTempadjust) {
        this.lastTempadjust = lastTempadjust;
    }

    public String getLastLowVar() {
        return lastLowVar;
    }

    public void setLastLowVar(String lastLowVar) {
        this.lastLowVar = lastLowVar;
    }

    public String getLastHighVar() {
        return lastHighVar;
    }

    public void setLastHighVar(String lastHighVar) {
        this.lastHighVar = lastHighVar;
    }

    public String getLastFlux() {
        return lastFlux;
    }

    public void setLastFlux(String lastFlux) {
        this.lastFlux = lastFlux;
    }

    public Date getLastUpdatedate() {
        return lastUpdatedate;
    }

    public void setLastUpdatedate(Date lastUpdatedate) {
        this.lastUpdatedate = lastUpdatedate;
    }

    public String getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(String lastFlag) {
        this.lastFlag = lastFlag;
    }

    public String getValveDefined() {
        return valveDefined;
    }

    public void setValveDefined(String valveDefined) {
        this.valveDefined = valveDefined;
    }

    public String getSetIndoorTemp() {
        return setIndoorTemp;
    }

    public void setSetIndoorTemp(String setIndoorTemp) {
        this.setIndoorTemp = setIndoorTemp;
    }

    public String getValveVenderName() {
        return valveVenderName;
    }

    public void setValveVenderName(String valveVenderName) {
        this.valveVenderName = valveVenderName;
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

    public String getValveOpen() {
        return valveOpen;
    }

    public void setValveOpen(String valveOpen) {
        this.valveOpen = valveOpen;
    }

    public String getValveOpenMin() {
        return valveOpenMin;
    }

    public void setValveOpenMin(String valveOpenMin) {
        this.valveOpenMin = valveOpenMin;
    }

    public String getValveOpenMax() {
        return valveOpenMax;
    }

    public void setValveOpenMax(String valveOpenMax) {
        this.valveOpenMax = valveOpenMax;
    }

    public String getValveAntirusttmo() {
        return valveAntirusttmo;
    }

    public void setValveAntirusttmo(String valveAntirusttmo) {
        this.valveAntirusttmo = valveAntirusttmo;
    }

    public String getTestinterjust() {
        return testinterjust;
    }

    public void setTestinterjust(String testinterjust) {
        this.testinterjust = testinterjust;
    }

    public String getTestPycle() {
        return testPycle;
    }

    public void setTestPycle(String testPycle) {
        this.testPycle = testPycle;
    }

    public String getLowVar() {
        return lowVar;
    }

    public void setLowVar(String lowVar) {
        this.lowVar = lowVar;
    }

    public String getHighVar() {
        return highVar;
    }

    public void setHighVar(String highVar) {
        this.highVar = highVar;
    }

    public String getSetTemp() {
        return setTemp;
    }

    public void setSetTemp(String setTemp) {
        this.setTemp = setTemp;
    }

    public String getSetFlux() {
        return setFlux;
    }

    public void setSetFlux(String setFlux) {
        this.setFlux = setFlux;
    }

    public Date getValveUpdatedate() {
        return valveUpdatedate;
    }

    public void setValveUpdatedate(Date valveUpdatedate) {
        this.valveUpdatedate = valveUpdatedate;
    }

    public String getValveFlag() {
        return valveFlag;
    }

    public void setValveFlag(String valveFlag) {
        this.valveFlag = valveFlag;
    }

    public String getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(String avgTemp) {
        this.avgTemp = avgTemp;
    }

    public String getHotValveNum() {
        return hotValveNum;
    }

    public void setHotValveNum(String hotValveNum) {
        this.hotValveNum = hotValveNum;
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
        this.caliber = caliber;
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    public String getMaxFlux() {
        return maxFlux;
    }

    public void setMaxFlux(String maxFlux) {
        this.maxFlux = maxFlux;
    }

    public String getMaxProvideTemp() {
        return maxProvideTemp;
    }

    public void setMaxProvideTemp(String maxProvideTemp) {
        this.maxProvideTemp = maxProvideTemp;
    }

    public String getMaxReturnTemp() {
        return maxReturnTemp;
    }

    public void setMaxReturnTemp(String maxReturnTemp) {
        this.maxReturnTemp = maxReturnTemp;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

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

    public String getValveType() {
        return valveType;
    }

    public void setValveType(String valveType) {
        this.valveType = valveType;
    }

    public String getGprs() {
        return gprs;
    }

    public void setGprs(String gprs) {
        this.gprs = gprs;
    }

    public String getChaobiaofs() {
        return chaobiaofs;
    }

    public void setChaobiaofs(String chaobiaofs) {
        this.chaobiaofs = chaobiaofs;
    }

    public String getChaobiaojg() {
        return chaobiaojg;
    }

    public void setChaobiaojg(String chaobiaojg) {
        this.chaobiaojg = chaobiaojg;
    }

    public String getXiacitxrq() {
        return xiacitxrq;
    }

    public void setXiacitxrq(String xiacitxrq) {
        this.xiacitxrq = xiacitxrq;
    }

    public String getTongxunrq() {
        return tongxunrq;
    }

    public void setTongxunrq(String tongxunrq) {
        this.tongxunrq = tongxunrq;
    }

    public String getFuwuqdzxzrq() {
        return fuwuqdzxzrq;
    }

    public void setFuwuqdzxzrq(String fuwuqdzxzrq) {
        this.fuwuqdzxzrq = fuwuqdzxzrq;
    }

}
