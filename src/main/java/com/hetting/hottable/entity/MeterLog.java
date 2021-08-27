package com.hetting.hottable.entity;

public class MeterLog {
    private Long meterId;

    private String meterAddr;

    private String cold;

    private String hot;

    private String power;

    private String flux;

    private String vol;

    private String intemp;

    private String outtemp;

    private String worktime;

    private String stat1;

    private String star2;

    private String coldunit;

    private String hotunit;

    private String openrate;

    private String stat;

    private String vintemp;

    private String vouttemp;

    private String ralval;

    private String opentime;

    private String shareHeat;

    // 点抄返回的数据类型
    private Integer resultType;


    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public String getMeterAddr() {
        return meterAddr;
    }

    public void setMeterAddr(String meterAddr) {
        this.meterAddr = meterAddr == null ? null : meterAddr.trim();
    }

    public String getCold() {
        return cold;
    }

    public void setCold(String cold) {
        this.cold = cold == null ? null : cold.trim();
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot == null ? null : hot.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getFlux() {
        return flux;
    }

    public void setFlux(String flux) {
        this.flux = flux == null ? null : flux.trim();
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol == null ? null : vol.trim();
    }

    public String getIntemp() {
        return intemp;
    }

    public void setIntemp(String intemp) {
        this.intemp = intemp == null ? null : intemp.trim();
    }

    public String getOuttemp() {
        return outtemp;
    }

    public void setOuttemp(String outtemp) {
        this.outtemp = outtemp == null ? null : outtemp.trim();
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime == null ? null : worktime.trim();
    }

    public String getStat1() {
        return stat1;
    }

    public void setStat1(String stat1) {
        this.stat1 = stat1 == null ? null : stat1.trim();
    }

    public String getStar2() {
        return star2;
    }

    public void setStar2(String star2) {
        this.star2 = star2 == null ? null : star2.trim();
    }

    public String getColdunit() {
        return coldunit;
    }

    public void setColdunit(String coldunit) {
        this.coldunit = coldunit == null ? null : coldunit.trim();
    }

    public String getHotunit() {
        return hotunit;
    }

    public void setHotunit(String hotunit) {
        this.hotunit = hotunit == null ? null : hotunit.trim();
    }

    public String getOpenrate() {
        return openrate;
    }

    public void setOpenrate(String openrate) {
        this.openrate = openrate == null ? null : openrate.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getVintemp() {
        return vintemp;
    }

    public void setVintemp(String vintemp) {
        this.vintemp = vintemp == null ? null : vintemp.trim();
    }

    public String getVouttemp() {
        return vouttemp;
    }

    public void setVouttemp(String vouttemp) {
        this.vouttemp = vouttemp == null ? null : vouttemp.trim();
    }

    public String getRalval() {
        return ralval;
    }

    public void setRalval(String ralval) {
        this.ralval = ralval == null ? null : ralval.trim();
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime == null ? null : opentime.trim();
    }

    public String getShareHeat() {
        return shareHeat;
    }

    public void setShareHeat(String shareHeat) {
        this.shareHeat = shareHeat == null ? null : shareHeat.trim();
    }
}