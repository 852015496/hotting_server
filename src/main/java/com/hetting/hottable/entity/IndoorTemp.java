package com.hetting.hottable.entity;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class IndoorTemp {

    //用户ID
    private Integer userId;
    //用户名称
    private String userName;
    //用户联系方式
    private String userContactWay;
    //用户楼栋
    private String userBuilding;
    //用户单元
    private String userCell;
    //用户房间号
    private String userDoorNum;
    //用户类型
    private String userType;
    //用户面积
    private String userArea;
    //用户编码
    private String userCode;

    //----------- 小区  --------------
    //小区ID
    private Integer plotId;
    //小区详情名称
    private String plotName;
    //小区地址
    private String plotAddress;
    //----------  阀门  ---------------
    //阀门ID
    private Integer valveId;
    //阀门地址
    private String valveAddress;
    //阀门状态
    private String valveStatus;
    //阀门工作模式
    private String valveWorkModal;
    //阀门最后一次更新时间
    private String lastUpdateDate;
    //阀门更新状态
    private String lastFlag;
    //最后一次进水温度
    private String lastVintemp;
    //最后一次回水温度
    private String lastOuttemp;
    //供暖状态
    private String heatingStatus;
    //设定温度
    private String setIndoorTemp;
    //室内温度
    private String lastValveRoomTemp;
    //开度值
    private String opening;


    //-----------------get and set-----------------------------


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

    public String getUserContactWay() {
        return userContactWay;
    }

    public void setUserContactWay(String userContactWay) {
        this.userContactWay = userContactWay;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getPlotId() {
        return plotId;
    }

    public void setPlotId(Integer plotId) {
        this.plotId = plotId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getPlotAddress() {
        return plotAddress;
    }

    public void setPlotAddress(String plotAddress) {
        this.plotAddress = plotAddress;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public String getValveAddress() {
        return valveAddress;
    }

    public void setValveAddress(String valveAddress) {
        this.valveAddress = valveAddress;
    }

    public String getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(String valveStatus) {
        this.valveStatus = valveStatus;
    }

    public String getValveWorkModal() {
        return valveWorkModal;
    }

    public void setValveWorkModal(String valveWorkModal) {
        this.valveWorkModal = valveWorkModal;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(String lastFlag) {
        this.lastFlag = lastFlag;
    }

    public String getLastVintemp() {
        return lastVintemp;
    }

    public void setLastVintemp(String lastVintemp) {
        this.lastVintemp = lastVintemp;
    }

    public String getLastOuttime() {
        return lastOuttemp;
    }

    public void setLastOuttime(String lastOuttime) {
        this.lastOuttemp = lastOuttime;
    }

    public String getHeatingStatus() {
        return heatingStatus;
    }

    public void setHeatingStatus(String heatingStatus) {
        this.heatingStatus = heatingStatus;
    }

    public String getSetIndoorTemp() {
        return setIndoorTemp;
    }

    public void setSetIndoorTemp(String setIndoorTemp) {
        this.setIndoorTemp = setIndoorTemp;
    }

    public String getLastOuttemp() {
        return lastOuttemp;
    }

    public void setLastOuttemp(String lastOuttemp) {
        this.lastOuttemp = lastOuttemp;
    }

    public String getLastValveRoomTemp() {
        return lastValveRoomTemp;
    }

    public void setLastValveRoomTemp(String lastValveRoomTemp) {
        this.lastValveRoomTemp = lastValveRoomTemp;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }
}
