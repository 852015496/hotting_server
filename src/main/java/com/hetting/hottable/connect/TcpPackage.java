package com.hetting.hottable.connect;

import java.util.Arrays;

/**
 * @author Mr.J
 * @Date 2020/2/27 - 10:04
 */
public class TcpPackage {

    private String jzq;
    private int packageCount;
    private int packageIndex;
    private byte cmd;
    private int dataLen;
    private byte[] data;

    public String getJzq() {
        return jzq;
    }

    public void setJzq(String jzq) {
        this.jzq = jzq;
    }

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    public int  getPackageIndex() {
        return packageIndex;
    }

    public void setPackageIndex(int packageIndex) {
        this.packageIndex = packageIndex;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public int getDataLen() {
        return dataLen;
    }

    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BasePackage{" +
                "jzq='" + jzq + '\'' +
                ", packageCount=" + packageCount +
                ", packageIndex=" + packageIndex +
                ", cmd=" + cmd +
                ", dataLen=" + dataLen +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
