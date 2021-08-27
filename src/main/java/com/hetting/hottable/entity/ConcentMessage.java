package com.hetting.hottable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ConcentMessage {
    private Long concentMid;

    private Integer concentId;

    private String address;

    private String concentCode;

    private String concentIp1;

    private String concentIp2;

    private String concentUpdatedate;

    private String workTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private Date lastTime;

    private String shortOut;

    private Integer materNum;

    private Integer faultMater;

    private Integer valveNum;

    private Integer faultValve;

    private String phoneId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:ss:mm")
    private Date communicationDate;

    private String concentProfessionalWork;

    private String concentPant;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    //--------------------------------------------

    //信号强度
    private String gprs;
    //抄表方式
    private String chaobiaofs;
    //抄表间隔 实时上传 间隔上传
    private String chaobiaojg;
    //集中器通讯成功率
    private String concentStatus;
    //下次通讯日期
    private String xiacitxrq;
    // 通讯日期
    private String tongxunrq;
    //服务器地址选择日期
    private String fuwuqdzxzrq;



//    ------------------Netty--------------------------


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

    public String getChaobiaojg() {
        return chaobiaojg;
    }

    public void setChaobiaojg(String chaobiaojg) {
        this.chaobiaojg = chaobiaojg;
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

    public String getChaobiaofs() {
        return chaobiaofs;
    }

    public void setChaobiaofs(String chaobiaofs) {
        this.chaobiaofs = chaobiaofs;
    }



//    ---------------------------------------------------------------

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getConcentMid() {
        return concentMid;
    }

    public void setConcentMid(Long concentMid) {
        this.concentMid = concentMid;
    }

    public Integer getConcentId() {
        return concentId;
    }

    public void setConcentId(Integer concentId) {
        this.concentId = concentId;
    }

    public String getConcentCode() {
        return concentCode;
    }

    public void setConcentCode(String concentCode) {
        this.concentCode = concentCode;
    }

    public String getConcentIp1() {
        return concentIp1;
    }

    public void setConcentIp1(String concentIp1) {
        this.concentIp1 = concentIp1 == null ? null : concentIp1.trim();
    }

    public String getConcentIp2() {
        return concentIp2;
    }

    public void setConcentIp2(String concentIp2) {
        this.concentIp2 = concentIp2 == null ? null : concentIp2.trim();
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
        this.workTime = workTime == null ? null : workTime.trim();
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
        this.shortOut = shortOut == null ? null : shortOut.trim();
    }

    public Integer getMaterNum() {
        return materNum;
    }

    public void setMaterNum(Integer materNum) {
        this.materNum = materNum;
    }

    public Integer getFaultMater() {
        return faultMater;
    }

    public void setFaultMater(Integer faultMater) {
        this.faultMater = faultMater;
    }

    public Integer getValveNum() {
        return valveNum;
    }

    public void setValveNum(Integer valveNum) {
        this.valveNum = valveNum;
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
        this.phoneId = phoneId == null ? null : phoneId.trim();
    }

    public Date getCommunicationDate() {
        return communicationDate;
    }

    public void setCommunicationDate(Date communicationDate) {
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

    public String getConcentStatus() {
        return concentStatus;
    }

    public void setConcentStatus(String concentStatus) {
        this.concentStatus = concentStatus;
    }
}