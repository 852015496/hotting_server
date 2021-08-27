package com.hetting.hottable.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Concent {

    private Integer concentId;

    private Long concentMid;

    private Integer plotId;

    private Integer hotId;

    private Integer socketId;

    private Integer valveId;

    private String concentCode;

    private Long concentNum;

    private String concentAddress;

    private String serverAddress1;

    private String serverAddress2;

    private String concentType;

    private String companyCode;

    private String housing;

    private String cell;

    private String building;

    private String roomnum;

    private String concentGap;

    private String lastShortOut;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastCommunicationDate;

    private String materNum;

    private Integer lastFaultMater;

    private String valveNum;

    private Integer lastFaultValve;

    private String PhoneId;

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

    private String lastValveRoomTemp;


    //---------------------Netty------------------------
    private String userName;
    private String userArea;
    private String hotAddress;
    private String valveAddress;
    private String valveMode;
    private String creatBy;

    private String remarks;

    private String valveStatus;

    private String valveVolstatus;

    private String addrStatus;

    private String addrCount;

    private String addrDate;

    private String readIntervel;

    private String heartIntervel;

    private String addr1;

    private String addr2;

    private String statusMbus1;
    private String statusMbus2;
    private String statusMbus3;
    private String statusMbus4;
    private String status485;
    private String sucRate;
    private String wirStatus;
    private String maxSignal;
    private String minSignal;
    private String btStatus;
    private String btLevel;
    private String voltage;
    private String updateDate;

    private String version;
    private String volMbus1;
    private String curMbus1;
    private String volMbus2;
    private String curMbus2;
    private String volMbus3;
    private String curMbus3;
    private String volMbus4;
    private String curMbus4;
    private String wirType;
    private String level4g;
    private String sim;

    private String concentProfessionalWork;
    //集中器通讯成功率
    private String concentStatus;
    //信号强度
    private String gprs;
    //下次通讯日期
    private String xiacitxrq;
    // 通讯日期
    private String tongxunrq;
    //服务器地址选择日期
    private String fuwuqdzxzrq;
    //抄表方式
    private String chaobiaofs;

    private String chaobiaojg;

    private String concentPant;

    private String concentUpdatedate;

    private String address;

    private String concentIp1;

    private String concentIp2;

    private String workTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private Date lastTime;

    private String shortOut;

    private Integer faultMater;

    private Integer faultValve;

    private String phoneId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private Date communicationDate;


    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
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

    public String getValveMode() {
        return valveMode;
    }

    public void setValveMode(String valveMode) {
        this.valveMode = valveMode;
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFuwuqdzxzrq() {
        return fuwuqdzxzrq;
    }

    public void setFuwuqdzxzrq(String fuwuqdzxzrq) {
        this.fuwuqdzxzrq = fuwuqdzxzrq;
    }

    public String getTongxunrq() {
        return tongxunrq;
    }

    public void setTongxunrq(String tongxunrq) {
        this.tongxunrq = tongxunrq;
    }

    public Long getConcentMid() {
        return concentMid;
    }

    public void setConcentMid(Long concentMid) {
        this.concentMid = concentMid;
    }

    public String getChaobiaojg() {
        return chaobiaojg;
    }

    public void setChaobiaojg(String chaobiaojg) {
        this.chaobiaojg = chaobiaojg;
    }

    public String getConcentPant() {
        return concentPant;
    }

    public void setConcentPant(String concentPant) {
        this.concentPant = concentPant;
    }

    public String getConcentUpdatedate() {
        return concentUpdatedate;
    }

    public void setConcentUpdatedate(String concentUpdatedate) {
        this.concentUpdatedate = concentUpdatedate;
    }

    public String getConcentProfessionalWork() {
        return concentProfessionalWork;
    }

    public void setConcentProfessionalWork(String concentProfessionalWork) {
        this.concentProfessionalWork = concentProfessionalWork;
    }

    public String getChaobiaofs() {
        return chaobiaofs;
    }

    public void setChaobiaofs(String chaobiaofs) {
        this.chaobiaofs = chaobiaofs;
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

    public Date getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(Date communicationDate) {
        this.communicationDate = communicationDate;
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

    public String getConcentStatus() {
        return concentStatus;
    }

    public void setConcentStatus(String concentStatus) {
        this.concentStatus = concentStatus;
    }

    public String getGprs() {
        return gprs;
    }

    public void setGprs(String gprs) {
        this.gprs = gprs;
    }

    public String getXiacitxrq() {
        return xiacitxrq;
    }

    public void setXiacitxrq(String xiacitxrq) {
        this.xiacitxrq = xiacitxrq;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVolMbus1() {
        return volMbus1;
    }

    public void setVolMbus1(String volMbus1) {
        this.volMbus1 = volMbus1;
    }

    public String getCurMbus1() {
        return curMbus1;
    }

    public void setCurMbus1(String curMbus1) {
        this.curMbus1 = curMbus1;
    }

    public String getVolMbus2() {
        return volMbus2;
    }

    public void setVolMbus2(String volMbus2) {
        this.volMbus2 = volMbus2;
    }

    public String getCurMbus2() {
        return curMbus2;
    }

    public void setCurMbus2(String curMbus2) {
        this.curMbus2 = curMbus2;
    }

    public String getVolMbus3() {
        return volMbus3;
    }

    public void setVolMbus3(String volMbus3) {
        this.volMbus3 = volMbus3;
    }

    public String getCurMbus3() {
        return curMbus3;
    }

    public void setCurMbus3(String curMbus3) {
        this.curMbus3 = curMbus3;
    }

    public String getVolMbus4() {
        return volMbus4;
    }

    public void setVolMbus4(String volMbus4) {
        this.volMbus4 = volMbus4;
    }

    public String getCurMbus4() {
        return curMbus4;
    }

    public void setCurMbus4(String curMbus4) {
        this.curMbus4 = curMbus4;
    }

    public String getWirType() {
        return wirType;
    }

    public void setWirType(String wirType) {
        this.wirType = wirType;
    }

    public String getLevel4g() {
        return level4g;
    }

    public void setLevel4g(String level4g) {
        this.level4g = level4g;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getStatusMbus1() {
        return statusMbus1;
    }

    public void setStatusMbus1(String statusMbus1) {
        this.statusMbus1 = statusMbus1;
    }

    public String getStatusMbus2() {
        return statusMbus2;
    }

    public void setStatusMbus2(String statusMbus2) {
        this.statusMbus2 = statusMbus2;
    }

    public String getStatusMbus3() {
        return statusMbus3;
    }

    public void setStatusMbus3(String statusMbus3) {
        this.statusMbus3 = statusMbus3;
    }

    public String getStatusMbus4() {
        return statusMbus4;
    }

    public void setStatusMbus4(String statusMbus4) {
        this.statusMbus4 = statusMbus4;
    }

    public String getStatus485() {
        return status485;
    }

    public void setStatus485(String status485) {
        this.status485 = status485;
    }

    public String getSucRate() {
        return sucRate;
    }

    public void setSucRate(String sucRate) {
        this.sucRate = sucRate;
    }

    public String getWirStatus() {
        return wirStatus;
    }

    public void setWirStatus(String wirStatus) {
        this.wirStatus = wirStatus;
    }

    public String getMaxSignal() {
        return maxSignal;
    }

    public void setMaxSignal(String maxSignal) {
        this.maxSignal = maxSignal;
    }

    public String getMinSignal() {
        return minSignal;
    }

    public void setMinSignal(String minSignal) {
        this.minSignal = minSignal;
    }

    public String getBtStatus() {
        return btStatus;
    }

    public void setBtStatus(String btStatus) {
        this.btStatus = btStatus;
    }

    public String getBtLevel() {
        return btLevel;
    }

    public void setBtLevel(String btLevel) {
        this.btLevel = btLevel;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getReadIntervel() {
        return readIntervel;
    }

    public void setReadIntervel(String readIntervel) {
        this.readIntervel = readIntervel;
    }

    public String getHeartIntervel() {
        return heartIntervel;
    }

    public void setHeartIntervel(String heartIntervel) {
        this.heartIntervel = heartIntervel;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddrStatus() {
        return addrStatus;
    }

    public void setAddrStatus(String addrStatus) {
        this.addrStatus = addrStatus;
    }

    public String getAddrCount() {
        return addrCount;
    }

    public void setAddrCount(String addrCount) {
        this.addrCount = addrCount;
    }

    public String getAddrDate() {
        return addrDate;
    }

    public void setAddrDate(String addrDate) {
        this.addrDate = addrDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveVolstatus() {
        return valveVolstatus;
    }

    public void setValveVolstatus(String valveVolstatus) {
        this.valveVolstatus = valveVolstatus;
    }

    public String getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(String normalNum) {
        this.normalNum = normalNum;
    }

    public String getLastValveRoomTemp() {
        return lastValveRoomTemp;
    }

    public void setLastValveRoomTemp(String lastValveRoomTemp) {
        this.lastValveRoomTemp = lastValveRoomTemp;
    }

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
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

    public void setConcentCount(Integer concentCount) {
        this.concentCount = concentCount;
    }

    public String getFaultNum() {
        return faultNum;
    }

    public void setFaultNum(String faultNum) {
        this.faultNum = faultNum;
    }

    public Integer getConcentCount() {
        return concentCount;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
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
        this.concentCode = concentCode == null ? null : concentCode.trim();
    }

    public Long getConcentNum() {
        return concentNum;
    }

    public void setConcentNum(Long concentNum) {
        this.concentNum = concentNum;
    }

    public String getConcentAddress() {
        return concentAddress;
    }

    public void setConcentAddress(String concentAddress) {
        this.concentAddress = concentAddress == null ? null : concentAddress.trim();
    }

    public String getServerAddress1() {
        return serverAddress1;
    }

    public void setServerAddress1(String serverAddress1) {
        this.serverAddress1 = serverAddress1 == null ? null : serverAddress1.trim();
    }

    public String getServerAddress2() {
        return serverAddress2;
    }

    public void setServerAddress2(String serverAddress2) {
        this.serverAddress2 = serverAddress2 == null ? null : serverAddress2.trim();
    }

    public String getConcentType() {
        return concentType;
    }

    public void setConcentType(String concentType) {
        this.concentType = concentType == null ? null : concentType.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing == null ? null : housing.trim();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell == null ? null : cell.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum == null ? null : roomnum.trim();
    }

    public String getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(String phoneId) {
        PhoneId = phoneId;
    }

    public String getConcentGap() {
        return concentGap;
    }

    public void setConcentGap(String concentGap) {
        this.concentGap = concentGap == null ? null : concentGap.trim();
    }

    public String getMaterNum() {
        return materNum;
    }

    public void setMaterNum(String materNum) {
        this.materNum = materNum;
    }

    public String getValveNum() {
        return valveNum;
    }

    public void setValveNum(String valveNum) {
        this.valveNum = valveNum;
    }

    public String getConcentModal() {
        return concentModal;
    }

    public void setConcentModal(String ConcentModal) {
        this.concentModal = ConcentModal == null ? null : ConcentModal.trim();
    }

    public String getLastShortOut() {
        return lastShortOut;
    }

    public void setLastShortOut(String lastShortOut) {
        this.lastShortOut = lastShortOut;
    }

    public Date getLastCommunicationDate() {
        return lastCommunicationDate;
    }

    public void setLastCommunicationDate(Date lastCommunicationDate) {
        this.lastCommunicationDate = lastCommunicationDate;
    }

    public Integer getLastFaultMater() {
        return lastFaultMater;
    }

    public void setLastFaultMater(Integer lastFaultMater) {
        this.lastFaultMater = lastFaultMater;
    }

    public Integer getLastFaultValve() {
        return lastFaultValve;
    }

    public void setLastFaultValve(Integer lastFaultValve) {
        this.lastFaultValve = lastFaultValve;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}