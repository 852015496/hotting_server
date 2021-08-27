package com.hetting.hottable.utils;


import com.hetting.hottable.connect.Agreement;
import com.hetting.hottable.entity.*;
import com.hetting.hottable.server.ConcentMessageService;
import com.hetting.hottable.server.ConcentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.J
 * @Date 2019/12/7 - 10:04
 */
public class ByteUtil {

    /**
     * 服务器回应集中器心跳，携带主机地址时的数据域长度
     */
    public static final int LEN_WITH_ADDRESS = 107;
    /**
     * 服务器回应集中器心跳，不携带主机地址时的数据域长度
     */
    public static final int LEN_WITHOUT_ADDRESS = 11;

    /**
     * 登录--数据包转集中器基本信息
     *
     * @param bytes 数据包
     */
    public static void bytesToQxnConcentratorInfo(Concent concentMessage, byte[] bytes) {
        String tmpString = new String(Arrays.copyOf(bytes, 8));
        concentMessage.setVersion(tmpString);//版本号
        concentMessage.setStatusMbus1((bytes[8] & 0xff) + "");//mbus1状态
        concentMessage.setVolMbus1((bytes[9] & 0xff) + "");//mbus1电压
        int tmpInt = (bytes[10] & 0xff) + (bytes[11] & 0xff) * 256; //获取电流值
        concentMessage.setCurMbus1(tmpInt + "");//mbus1 电流
        concentMessage.setStatusMbus2((bytes[12] & 0xff) + "");//mbus2状态
        concentMessage.setVolMbus2((bytes[13] & 0xff) + "");//mubs2电压
        tmpInt = (bytes[14] & 0xff) + (bytes[15] & 0xff) * 256;
        concentMessage.setCurMbus2(tmpInt + "");//mbus2电流（mA）
        concentMessage.setStatusMbus3((bytes[16] & 0xff) + "");//mbus3状态
        concentMessage.setVolMbus3((bytes[17] & 0xff) + "");//mubs3电压
        tmpInt = (bytes[18] & 0xff) + (bytes[19] & 0xff) * 256;//获取电流值
        concentMessage.setCurMbus3(tmpInt + "");//mbus3电流（mA）
        concentMessage.setStatusMbus4((bytes[20] & 0xff) + "");//mbus4状态
        concentMessage.setVolMbus4((bytes[21] & 0xff) + "");// mubs4电压
        tmpInt = (bytes[22] & 0xff) + (bytes[23] & 0xff) * 256;//获取电流值
        concentMessage.setCurMbus4(tmpInt + "");//mbus4电流（mA）
        concentMessage.setStatus485((bytes[24] & 0xff) + "");//485状态（1=485通信顺畅，0=通信不顺畅）
        concentMessage.setConcentStatus((bytes[25] & 0xff) + "");//通信成功率
        concentMessage.setWirType((bytes[26] & 0xff) + "");//无线类型（1=CMT2300，2=Lora，0=表示未装无线模块）
        concentMessage.setWirStatus((bytes[27] & 0xff) + "");//无线状态（0=未检测/到模块，1=检测到模块，2=已经通信成功过）
        concentMessage.setMaxSignal((bytes[28] & 0xff) + "");//最大信号强度
        concentMessage.setMinSignal((bytes[29] & 0xff) + "");//最小信号强度
        concentMessage.setBtStatus((bytes[30] & 0xff) + "");//蓝牙状态
        concentMessage.setBtLevel((bytes[31] & 0xff) + "");//蓝牙强度
        concentMessage.setGprs((bytes[32] & 0xff) + "");//4g强度
        tmpString = new String(Arrays.copyOfRange(bytes, 33, 53));//获取sim卡号
        concentMessage.setPhoneId(tmpString);//sim卡号
        concentMessage.setChaobiaojg((bytes[66] & 0xff) + "");//抄表间隔（单位分钟）
        concentMessage.setConcentPant((bytes[67] & 0xff) + "");//心跳间隔（单位秒）
        concentMessage.setConcentUpdatedate(DateUtil.getDateString());//更新时间
    }

    /**
     * 心跳--数据包转集中器状态信息
     *
     * @param qxnConcentrator
     * @param bytes 数据包
     */
    public static void bytesToQxnConcentratorStatus(Concent qxnConcentrator, byte[] bytes) {
        qxnConcentrator.setStatusMbus1((bytes[0] & 0xff) + "");//mbus1状态
        qxnConcentrator.setStatusMbus2((bytes[1] & 0xff) + "");//mbus2状态
        qxnConcentrator.setStatusMbus3((bytes[2] & 0xff) + "");//mbus3状态
        qxnConcentrator.setStatusMbus4((bytes[3] & 0xff) + "");//mbus4状态

        qxnConcentrator.setConcentProfessionalWork((bytes[4] & 0xff) + "");//485状态（1=485通信顺畅，0=通信不顺畅）
        qxnConcentrator.setConcentStatus((bytes[5] & 0xff) + "");//通信成功率

        qxnConcentrator.setWirStatus((bytes[6] & 0xff) + "");//无线状态（0=未检测到模块，1=检测到模块，2=已经通信成功过）
        qxnConcentrator.setMaxSignal((bytes[7] & 0xff) + "");//最大信号强度
        qxnConcentrator.setMinSignal((bytes[8] & 0xff) + "");//最小信号强度

        qxnConcentrator.setBtStatus((bytes[9] & 0xff) + "");//蓝牙状态
        qxnConcentrator.setGprs((bytes[10] & 0xff) + "");//蓝牙强度

        qxnConcentrator.setValveVolstatus((bytes[11] & 0xff) + "");//阀门电源状态（1字节，0=关闭，1=打开，2=故障）=====集中器上传
        qxnConcentrator.setVoltage((bytes[12] & 0xff) + "");//市电电压
        qxnConcentrator.setXiacitxrq(DateUtil.getDateString());//更新时间
    }

    /**
     * 登录&心跳--集中器信息转数据包
     *
     * @param packetLength 是否加载主机地址（11=不加载，127=下载）
     * @param entity       集中器信息
     * @return 数据包
     */
    public static byte[] concentratorInfoToBytes(int packetLength, Concent entity) {
        byte[] bytes = new byte[packetLength];
        if (StringUtils.isNotEmpty(entity.getValveStatus())) {//阀门控制状态====控制状态===需要创建时候给默认值1=========开：1关：0默认1
            bytes[0] = (byte) MessageUtil.stringToInt(entity.getValveStatus());
        } else {
            bytes[0] = (byte) MessageUtil.stringToInt(entity.getValveVolstatus());
        }
        int tmpInt = MessageUtil.stringToInt(entity.getReadIntervel());//抄表间隔（单位分钟）
        bytes[1] = (byte) tmpInt;
        bytes[2] = (byte) (tmpInt >> 8);
        tmpInt = MessageUtil.stringToInt(entity.getHeartIntervel());//心跳间隔（单位秒）
        bytes[3] = (byte) tmpInt;
        bytes[4] = (byte) (tmpInt >> 8);
        System.arraycopy(DateUtil.getDateBytes(), 0, bytes, 5, 6);
        if (packetLength == LEN_WITH_ADDRESS) {
            byte[] tmpBytes;
            String tmpString = entity.getAddr1();//主机地址1
            if (StringUtils.isNotEmpty(tmpString)) {
                tmpBytes = tmpString.getBytes();
                System.arraycopy(tmpBytes, 0, bytes, 11, tmpBytes.length);
            }
            tmpString = entity.getAddr2();//主机地址2
            if (StringUtils.isNotEmpty(tmpString)) {
                tmpBytes = tmpString.getBytes();
                System.arraycopy(tmpBytes, 0, bytes, 59, tmpBytes.length);
            }
        }
        return bytes;
    }

    /**
     * 地址表--记录转数据包
     *
     * @param list     地址表
     * @param start    开始位置
     * @param countAll 总记录数
     * @return 数据包
     */
    private static byte[] addressInfoToBytes(List<HotAndValve> list, int start, int countAll) {
        int recordCount = list.size();
        int packetRecordCount = Math.min(15, recordCount - start);
        int recordLength = 66;
        byte[] bytes = new byte[8 + recordLength * packetRecordCount];
        bytes[0] = (byte) countAll; //记录数2字节
        bytes[1] = (byte) (countAll >> 8);//记录数2字节
        byte[] dateTime = DateUtil.getDateBytes();//地址表建立时间
        System.arraycopy(dateTime, 0, bytes, 2, dateTime.length);
        for (int j = 0; j < packetRecordCount; j++) {
            HotAndValve qxn = list.get(start + j);
            int tmpInt = MessageUtil.stringToInt(qxn.getPydz()); //记录偏移编号
            bytes[8 + j * recordLength] = (byte) tmpInt;
            bytes[9 + j * recordLength] = (byte) (tmpInt >> 8);
            int type = MessageUtil.stringToInt(qxn.getFileType()) ;    //档案性质
            bytes[10 + j * recordLength] = (byte) type;
            /*if (type == 100) {
                bytes[10 + j * recordLength] = 2;
            }*/
            byte[] tmpBytes;
            //100=只有阀门，不需要热表信息
//            if (type != 100) {
//                String[] str = qxn.getMeterFac().split("-"); //热表生成厂商代码
//                tmpInt = MessageUtil.stringToInt(str[0]);
                bytes[11 + j * recordLength] = (byte) (tmpInt);
                bytes[12 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMeterChannel()));//热表接入的抄表通道
                bytes[13 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMeterType()));//热表类型代码+表码
                if (tmpInt == 160) {
                    tmpBytes = new byte[]{(byte) MessageUtil.stringToInt(qxn.getMeterAddr())};
                } else {
                    tmpBytes = analysisMeterCode(qxn.getMeterAddr());
                }
                if (tmpBytes != null) {
                    System.arraycopy(tmpBytes, 0, bytes, 14 + j * recordLength, tmpBytes.length);
                }
//            }
            tmpInt = MessageUtil.stringToInt(qxn.getShareTableNum()); //共享热表记录偏移编号
            bytes[21 + j * recordLength] = (byte) (tmpInt);
            bytes[22 + j * recordLength] = (byte) (tmpInt >> 8);
            tmpInt = MessageUtil.stringToInt(qxn.getArea()) * 100; //住房面积
            bytes[23 + j * recordLength] = (byte) tmpInt;
            bytes[24 + j * recordLength] = (byte) (tmpInt >> 8);
            bytes[25 + j * recordLength] = (byte) MessageUtil.stringToInt(qxn.getValveFlag());//阀门信息更新标志
            bytes[26 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getValveFac())); //阀门厂家代码
            bytes[27 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getValveChannel()));//阀门接入的抄表通道
            bytes[28 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getValveType()));//阀门类型代码+地址码
            tmpBytes = analysisMeterCode(qxn.getValveAddr());//阀门地址
            if (tmpBytes != null) {
                System.arraycopy(tmpBytes, 0, bytes, 29 + j * recordLength, tmpBytes.length);
            }
            bytes[36 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getArrFlag())); //欠费标志
            String mode = qxn.getValveMode(); //阀门工作模式
            if ("33".equals(mode)) {
                bytes[37 + j * recordLength] = (byte) (MessageUtil.stringToInt("1"));
            } else {
                bytes[37 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getValveMode()));
            }
            bytes[38 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getSetOpening()));//控制阀门开度
            bytes[39 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMinOpening()));//阀门最小开度
            bytes[40 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMaxOpening()));//阀门最大开度
            bytes[41 + j * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getAntirustTmo()));//阀门防锈动作时间间隔
            tmpInt = MessageUtil.stringToInt(qxn.getCwInterval());//测温间隔
            bytes[42 + j * recordLength] = (byte) tmpInt;
//            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getTempAdjust()) * 100);//温度调节
//            bytes[43 + j * recordLength] = (byte) tmpInt;
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getMinTempVal()) * 100);//温控下限
            bytes[44 + j * recordLength] = (byte) tmpInt;
            bytes[45 + j * recordLength] = (byte) (tmpInt >> 8);
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getMaxTempVal()) * 100);//温控上限
            bytes[46 + j * recordLength] = (byte) tmpInt;
            bytes[47 + j * recordLength] = (byte) (tmpInt >> 8);
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getSetTempVal()) * 100);//设置温度
            bytes[48 + j * recordLength] = (byte) tmpInt;
            bytes[49 + j * recordLength] = (byte) (tmpInt >> 8);
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getPowerUpper()) * 1000);//设置功率
            bytes[50 + j * recordLength] = (byte) tmpInt;
            bytes[51 + j * recordLength] = (byte) (tmpInt >> 8);
            bytes[52 + j * recordLength] = (byte) (tmpInt >> 16);
            bytes[53 + j * recordLength] = (byte) (tmpInt >> 24);
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getFluxUpper()) * 1000);//设置流速
            bytes[54 + j * recordLength] = (byte) tmpInt;
            bytes[55 + j * recordLength] = (byte) (tmpInt >> 8);
            bytes[56 + j * recordLength] = (byte) (tmpInt >> 16);
            bytes[57 + j * recordLength] = (byte) (tmpInt >> 24);
            tmpInt = MessageUtil.stringToInt(qxn.getWendu1());
            bytes[58 + j * recordLength] = (byte) tmpInt;
            tmpInt = MessageUtil.stringToInt(qxn.getKaidu1());
            bytes[59 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getWendu2());
//            bytes[60 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getKaidu2());
//            bytes[61 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getWendu3());
//            bytes[62 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getKaidu3());
//            bytes[63 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getWendu4());
//            bytes[64 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getKaidu4());
//            bytes[65 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getWendu5());
//            bytes[66 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getKaidu5());
//            bytes[67 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getWendu6());
//            bytes[68 + j * recordLength] = (byte) tmpInt;
//            tmpInt = MessageUtil.stringToInt(qxn.getKaidu6());
//            bytes[69 + j * recordLength] = (byte) tmpInt;
            tmpInt = (int) (MessageUtil.stringToDouble(qxn.getShareHotSet()) * 10); //分摊热量初始值
            bytes[70 + j * recordLength] = (byte) tmpInt;
            bytes[71 + j * recordLength] = (byte) (tmpInt >> 8);
            bytes[72 + j * recordLength] = (byte) (tmpInt >> 16);
            bytes[73 + j * recordLength] = (byte) (tmpInt >> 24);
        }
        return bytes;
    }

    /**
     * 上传数据--数据包转历史记录实体
     *
     * @param jzq   集中器地址
     * @param bytes 数据包
     * @return 历史记录实体集合
     */
    public static List<QxnHistory> bytesToHistory(String jzq, byte[] bytes) {
        int recordLength = 58;
        List<QxnHistory> list = new ArrayList<>();
        String date = DateUtil.getDateString();
        //bytes[0-1]记录总数（备用）
        //bytes[2-7]抄表时间（备用）
        for (int i = 0; i < bytes.length / recordLength; i++) {
            QxnHistory history = new QxnHistory();
            history.setJzqCode(jzq);
            history.setReadDate(date);
            int tmpInt = (bytes[8 + i * recordLength] & 0xff) + (bytes[9 + i * recordLength] & 0xff) * 256;
            history.setMeterAddr(tmpInt + "");
            tmpInt = ((bytes[10 + i * recordLength] & 0xff) + ((bytes[11 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[12 + i * recordLength] & 0xff) << 16) + ((bytes[13 + i * recordLength] & 0xff) << 24));
            if ((bytes[40 + i * recordLength] & 0xff) == 1) {
                history.setMeterCold((tmpInt / 10.0) + "GJ");
            } else {
                history.setMeterCold((tmpInt / 10.0) + "KWH");
            }
            tmpInt = ((bytes[14 + i * recordLength] & 0xff) + ((bytes[15 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[16 + i * recordLength] & 0xff) << 16) + ((bytes[17 + i * recordLength] & 0xff) << 24));
            if ((bytes[41 + i * recordLength] & 0xff) == 1) {
                history.setMeterHot((tmpInt / 10.0) + "GJ");
            } else {
                history.setMeterHot((tmpInt / 10.0) + "KWH");
            }
            tmpInt = ((bytes[18 + i * recordLength] & 0xff) + ((bytes[19 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[20 + i * recordLength] & 0xff) << 16) + ((bytes[21 + i * recordLength] & 0xff) << 24));
            history.setMeterPower((tmpInt / 1000.0) + "");
            tmpInt = ((bytes[22 + i * recordLength] & 0xff) + ((bytes[23 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[24 + i * recordLength] & 0xff) << 16) + ((bytes[25 + i * recordLength] & 0xff) << 24));
            history.setMeterFlux((tmpInt / 1000.0) + "");
            tmpInt = ((bytes[26 + i * recordLength] & 0xff) + ((bytes[27 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[28 + i * recordLength] & 0xff) << 16) + ((bytes[29 + i * recordLength] & 0xff) << 24));
            history.setMeterVol((tmpInt / 10.0) + "");
            tmpInt = (bytes[30 + i * recordLength] & 0xff) + (bytes[31 + i * recordLength] & 0xff) * 256;
            history.setMeterIntemp((tmpInt / 100.0) + "");
            tmpInt = (bytes[32 + i * recordLength] & 0xff) + (bytes[33 + i * recordLength] & 0xff) * 256;
            history.setMeterOutemp((tmpInt / 100.0) + "");
            tmpInt = ((bytes[34 + i * recordLength] & 0xff) + ((bytes[35 + i * recordLength] & 0xff) << 8));
            tmpInt += (((bytes[36 + i * recordLength] & 0xff) << 16) + ((bytes[37 + i * recordLength] & 0xff) << 24));
            history.setMeterWorkTime(tmpInt + "");
            tmpInt = (bytes[38 + i * recordLength] & 0xff);
            history.setMeterStatus1(tmpInt + "");
            tmpInt = (bytes[39 + i * recordLength] & 0xff);
            history.setMeterStatus2(tmpInt + "");
            tmpInt = (bytes[42 + i * recordLength] & 0xff) & 0xff;
            history.setActualOpening(tmpInt + "");
            tmpInt = ((bytes[43 + i * recordLength] & 0xff) & 0xff) / 16;
            history.setValveStatus(tmpInt + "");
            int cwq = ((bytes[43 + i * recordLength] & 0xff) & 0xff) % 16;
            history.setCwqStatus(cwq + "");
            tmpInt = (bytes[44 + i * recordLength] & 0xff) + (bytes[45 + i * recordLength] & 0xff) * 256;
            history.setValveIntemp((tmpInt / 100.0) + "");
            tmpInt = (bytes[46 + i * recordLength] & 0xff) + (bytes[47 + i * recordLength] & 0xff) * 256;
            history.setValveOutemp((tmpInt / 100.0) + "");
            tmpInt = (bytes[48 + i * recordLength] & 0xff) + (bytes[49 + i * recordLength] & 0xff) * 256;
            if (tmpInt == 0 && cwq == 1) {
                history.setCwqStatus("3");
            }
            history.setRoomTemp1((tmpInt / 100.0) + "");
            tmpInt = (bytes[50 + i * recordLength] & 0xff) + (bytes[51 + i * recordLength] & 0xff) * 256;
            history.setRoomTemp2((tmpInt / 100.0) + "");
            tmpInt = (bytes[52 + i * recordLength] & 0xff) + (bytes[53 + i * recordLength] & 0xff) * 256;
            history.setRoomTemp3((tmpInt / 100.0) + "");
            tmpInt = (bytes[54 + i * recordLength] & 0xff) + (bytes[55 + i * recordLength] & 0xff) * 256;
            history.setRoomTemp4((tmpInt / 100.0) + "");
            tmpInt = (bytes[56 + i * recordLength] & 0xff) + (bytes[57 + i * recordLength] & 0xff) * 256;
            history.setCwqTemp((tmpInt / 100.0) + "");
            tmpInt = (bytes[58 + i * recordLength] & 0xff) + ((bytes[59 + i * recordLength] & 0xff) << 8);
            tmpInt += ((bytes[60 + i * recordLength] & 0xff) << 16) + ((bytes[61 + i * recordLength] & 0xff) << 24);
            history.setValveOpenTime(tmpInt + "");
            tmpInt = (bytes[62 + i * recordLength] & 0xff) + ((bytes[63 + i * recordLength] & 0xff) << 8);
            tmpInt += ((bytes[64 + i * recordLength] & 0xff) << 16) + ((bytes[65 + i * recordLength] & 0xff) << 24);
            history.setShareHotNow((tmpInt / 10.0) + "");
            list.add(history);
        }
        return list;
    }

    /**
     * 点名抄表信息转数据包
     *
     * @param list 要抄表的表信息
     * @return 数据包
     */
    public static byte[] callMetersToBytes(byte type, List<MeterData> list) {
        int recordLength = 10;
        int readCount = list.size();
        byte[] bytes = new byte[3 + readCount * recordLength];
        bytes[0] = (byte) readCount;
        bytes[1] = (byte) (readCount >> 8);
        bytes[2] = type;
        for (int i = 0; i < readCount; i++) {
            MeterData qxn = list.get(i);
            String str = qxn.getMeterFac();
            bytes[3 + i * recordLength] = (byte) (MessageUtil.stringToInt(str));
            bytes[4 + i * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMeterChannel()));
            bytes[5 + i * recordLength] = (byte) (MessageUtil.stringToInt(qxn.getMeterType()));
            byte[] tmpBytes = analysisMeterCode(qxn.getMeterAddr());
            if (tmpBytes != null) {
                System.arraycopy(tmpBytes, 0, bytes, 6 + i * recordLength, tmpBytes.length);
            }
        }
        return bytes;
    }

    /**
     * 点名控阀信息转数据包
     *
     * @param valves 点控信息
     * @return 数据包
     */
    public static byte[] callValvesToBytes(List<MeterData> valves) {
        int recordLength = 49;
        int recordCount = Math.min(10, valves.size());
        byte[] bytes = new byte[3 + recordCount * recordLength];
        bytes[0] = (byte) (recordCount);
        bytes[1] = (byte) (recordCount << 8);
        bytes[2] = 0;
        for (int i = 0; i < recordCount; i++) {
            MeterData qxn = valves.get(i);
            int tmpInt = MessageUtil.stringToInt(qxn.getValveFlag());
            bytes[3 + i * recordLength] = (byte) tmpInt;
            tmpInt = MessageUtil.stringToInt(qxn.getValveFac());
            bytes[4 + i * recordLength] = (byte) tmpInt;
            tmpInt = MessageUtil.stringToInt(qxn.getValveChannel());
            bytes[5 + i * recordLength] = (byte) tmpInt;
            tmpInt = MessageUtil.stringToInt(qxn.getValveType());
            bytes[6 + i * recordLength] = (byte) tmpInt;
            byte[] tmpBytes = analysisMeterCode(qxn.getValveAddr());
            if (tmpBytes != null) {
                System.arraycopy(tmpBytes, 0, bytes, 7 + i * recordLength, tmpBytes.length);
            }
            tmpInt = MessageUtil.stringToInt(qxn.getSetOpening());
            bytes[16 + i * recordLength] = (byte) tmpInt;
            //以下内容为了兼容长春客户带走的样品
            bytes[15 + i * recordLength] = (byte) 1;
            bytes[18 + i * recordLength] = (byte) 100;
            bytes[19 + i * recordLength] = (byte) 60;
            bytes[20 + i * recordLength] = (byte) 30;
        }
        return bytes;
    }

    /**
     * 点抄数据包转实体
     *
     * @param jzq   集中器地址
     * @param bytes 数据包
     * @return 实体列表
     */
    public static List<MeterData> bytesToCallReadData(String jzq, byte[] bytes) {
        List<MeterData> qxnCallReadings = new ArrayList<>();

        int recordType = bytes[0] & 0xff;
        int recordLength = (bytes[1] & 0xff) + ((bytes[2] & 0xff) << 8);
        int recordCount = (bytes[3] & 0xff) + ((bytes[4] & 0xff) << 8);
        recordLength = recordLength / recordCount;
        String date = DateUtil.getDateString();

        for (int i = 0; i < recordCount; i++) {
            MeterData qxnCallReading = new MeterData();
            qxnCallReading.setNum(i + "");
            qxnCallReading.setJzqCode(jzq);
            qxnCallReading.setStatus("1");
            qxnCallReading.setResponseTime(date);
            if (recordType == 0) {
                byte[] tmp = Arrays.copyOfRange(bytes, 6 + i * recordLength, 10 + i * recordLength);
                qxnCallReading.setMeterAddr(analysisMeterCode(tmp));
                int tmpInt = (bytes[13 + i * recordLength] & 0xff) + ((bytes[14 + i * recordLength] & 0xff) << 8)
                        + ((bytes[15 + i * recordLength] & 0xff) << 16) + ((bytes[16 + i * recordLength] & 0xff) << 24);
                if ((bytes[41 + i * recordLength] & 0xff) == 1) {
                    qxnCallReading.setCold((tmpInt / 10.0) + "GJ");
                } else {
                    qxnCallReading.setCold((tmpInt / 10.0) + "KWH");
                }
                tmpInt = (bytes[17 + i * recordLength] & 0xff) + ((bytes[18 + i * recordLength] & 0xff) << 8)
                        + ((bytes[19 + i * recordLength] & 0xff) << 16) + ((bytes[20 + i * recordLength] & 0xff) << 24);
                if ((bytes[42 + i * recordLength] & 0xff) == 1) {
                    qxnCallReading.setHot((tmpInt / 10.0) + "GJ");
                } else {
                    qxnCallReading.setHot((tmpInt / 10.0) + "KWH");
                }
                tmpInt = (bytes[21 + i * recordLength] & 0xff) + ((bytes[22 + i * recordLength] & 0xff) << 8)
                        + ((bytes[23 + i * recordLength] & 0xff) << 16) + ((bytes[24 + i * recordLength] & 0xff) << 24);
                qxnCallReading.setMeterPower((tmpInt / 1000.0) + "");
                tmpInt = (bytes[25 + i * recordLength] & 0xff) + ((bytes[26 + i * recordLength] & 0xff) << 8)
                        + ((bytes[27 + i * recordLength] & 0xff) << 16) + ((bytes[28 + i * recordLength] & 0xff) << 24);
                qxnCallReading.setSpeed((tmpInt / 1000.0) + "");
                tmpInt = (bytes[29 + i * recordLength] & 0xff) + ((bytes[30 + i * recordLength] & 0xff) << 8)
                        + ((bytes[31 + i * recordLength] & 0xff) << 16) + ((bytes[32 + i * recordLength] & 0xff) << 24);
                qxnCallReading.setVol((tmpInt / 10.0) + "");
                tmpInt = (bytes[33 + i * recordLength] & 0xff) + ((bytes[34 + i * recordLength] & 0xff) << 8);
                qxnCallReading.setInTemp((tmpInt / 100.0) + "");
                tmpInt = (bytes[35 + i * recordLength] & 0xff) + ((bytes[36 + i * recordLength] & 0xff) << 8);
                qxnCallReading.setOuTemp((tmpInt / 100.0) + "");
                tmpInt = (bytes[37 + i * recordLength] & 0xff) + ((bytes[38 + i * recordLength] & 0xff) << 8);
                tmpInt += ((bytes[39 + i * recordLength] & 0xff) << 16) + ((bytes[40 + i * recordLength] & 0xff) << 24);
                qxnCallReading.setWorkTime(tmpInt + "");
                tmpInt = (bytes[43 + i * recordLength] & 0xff);
                qxnCallReading.setReadStatus(tmpInt + "");
                tmpInt = (bytes[44 + i * recordLength] & 0xff);
                qxnCallReading.setMeterStatus(tmpInt + "");

            } else {
                byte[] tmpBytes = Arrays.copyOfRange(bytes, 5 + i * recordLength, 5 + (i + 1) * recordLength);
                qxnCallReading.setOriginalData(MessageUtil.byteFormat(tmpBytes));
            }
            qxnCallReadings.add(qxnCallReading);
        }
        return qxnCallReadings;
    }

    /**
     * 点名控阀数据包转实体
     *
     * @param jzq   集中器地址
     * @param bytes 数据包
     * @return 实体列表
     */
    public static List<MeterData> bytesToCallControlData(String jzq, byte[] bytes) {
        List<MeterData> qxnCallControls = new ArrayList<>();
//        int resultType = bytes[0];
        int recordLength = (bytes[1] & 0xff) + ((bytes[2] & 0xff) << 8);
        int recordCount = (bytes[3] & 0xff) + ((bytes[4] & 0xff) << 8);
        recordLength = recordLength / recordCount;
        String time = DateUtil.getDateString();
        for (int i = 0; i < recordCount; i++) {
            MeterData qxnCallControl = new MeterData();
            qxnCallControl.setJzqCode(jzq);         //集中器地址
            qxnCallControl.setResponseTime(time);   //应答时间

            int tmpInt = bytes[5 + i * recordLength] & 0xff;
            qxnCallControl.setValveType(tmpInt + "");   //阀门类型
            byte[] tmp = Arrays.copyOfRange(bytes, 6 + i * recordLength, 10 + i * recordLength);
            qxnCallControl.setValveAddr(analysisMeterCode(tmp));    //阀门地址
            tmpInt = bytes[13 + i * recordLength] & 0xff;
            qxnCallControl.setActualOpening(tmpInt + "");   //当前开度
            tmpInt = (bytes[14 + i * recordLength] & 0xff) / 16;
            qxnCallControl.setValveStatus(tmpInt + "");     // 阀门状态
            tmpInt = (bytes[14 + i * recordLength] & 0xff) % 16;
            qxnCallControl.setCwqStatus(tmpInt + "");       //无线测温器状态
            tmpInt = (bytes[15 + i * recordLength] & 0xff) + ((bytes[16 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setValveIntemp((tmpInt / 100.0) + "");   //阀门进水温度
            tmpInt = (bytes[17 + i * recordLength] & 0xff) + ((bytes[18 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setValveOutemp((tmpInt / 100.0) + "");   //阀门回水温度
            tmpInt = (bytes[19 + i * recordLength] & 0xff) + ((bytes[20 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setRoomTemp1((tmpInt / 100.0) + "");     //实测量1
            tmpInt = (bytes[21 + i * recordLength] & 0xff) + ((bytes[22 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setRoomTemp2((tmpInt / 100.0) + "");     //实测量2
            tmpInt = (bytes[23 + i * recordLength] & 0xff) + ((bytes[24 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setRoomTemp3((tmpInt / 100.0) + "");     //实测量3
            tmpInt = (bytes[25 + i * recordLength] & 0xff) + ((bytes[26 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setRoomTemp4((tmpInt / 100.0) + "");     //实测量4
            tmpInt = (bytes[27 + i * recordLength] & 0xff) + ((bytes[28 + i * recordLength] & 0xff) << 8);
            qxnCallControl.setCwqTemp((tmpInt / 100.0) + "");        //设置量
            tmpInt = (bytes[29 + i * recordLength] & 0xff) + ((bytes[30 + i * recordLength] & 0xff) << 8)
                    + ((bytes[31 + i * recordLength] & 0xff) << 16) + ((bytes[32 + i * recordLength] & 0xff) << 24);
            qxnCallControl.setValveOpenTime(tmpInt + "");            //累计开阀时间
            tmpInt = (bytes[33 + i * recordLength] & 0xff) + ((bytes[34 + i * recordLength] & 0xff) << 8)
                    + ((bytes[35 + i * recordLength] & 0xff) << 16) + ((bytes[36 + i * recordLength] & 0xff) << 24);
            qxnCallControl.setShareHotNow((tmpInt / 10.0) + "");      //分摊热量
            qxnCallControls.add(qxnCallControl);
        }
        return qxnCallControls;
    }

    /**
     * 生成升级通知
     *
     * @param len 固件总长度
     * @param sum 固件总校验
     * @return 通知
     */
    public static byte[] generateUpdateKey(int len, int sum) {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) len;
        bytes[1] = (byte) (len >> 8);
        bytes[2] = (byte) (len >> 8);
        bytes[3] = (byte) (len >> 8);
        bytes[4] = (byte) sum;
        bytes[5] = (byte) (sum >> 8);
        bytes[6] = (byte) (sum >> 8);
        bytes[7] = (byte) (sum >> 8);
        return bytes;
    }

    /**
     * 将字符串形式的表码转换成字节码
     *
     * @param code 表码
     * @return 字节数组
     */
    public static byte[] analysisMeterCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        int codeLen = code.length();
        char[] array = code.toCharArray();
        byte[] bytes = new byte[codeLen / 2];
        for (int i = 0; i < codeLen; i++) {
            if (i % 2 == 0) {
                bytes[i / 2] = (byte) (MessageUtil.stringToInt(array[i] + "") * 16);
            } else {
                bytes[i / 2] += (byte) MessageUtil.stringToInt(array[i] + "");
            }
        }
        return bytes;
    }

    private static String analysisMeterCode(byte[] code) {
        StringBuilder builder = new StringBuilder();
        for (byte b : code) {
            builder.append(String.format("%02X", b & 0xff));
        }
        return builder.toString();
    }

    /**
     * 组织要发送的数据包
     *
     * @param addr  集中器地址
     * @param cmd   命令码
     * @param count 总包号
     * @param index 当前包号
     * @param date  数据区域
     * @return 完整数据包
     */
    public static byte[] formatSendBytes(String addr, byte cmd, int count, int index, byte... date) {
        int packetLen = date.length;
        byte[] bytes = new byte[packetLen + 22];
        bytes[0] = (byte) 0xFE;
        bytes[1] = (byte) 0xFE;
        bytes[2] = (byte) 0xFE;
        bytes[3] = (byte) 0xFE;
        bytes[4] = (byte) 0xAC;
        bytes[5] = (byte) 0x97;
        bytes[6] = (byte) 0x30;
        bytes[7] = (byte) 0x63;
        //集中器地址
        int tmp = MessageUtil.stringToInt(addr);
        bytes[8] = (byte) tmp;
        bytes[9] = (byte) (tmp >> 8);
        bytes[10] = (byte) (tmp >> 16);
        bytes[11] = (byte) (tmp >> 24);
        //总包数
        bytes[12] = (byte) count;
        bytes[13] = (byte) (count >> 8);
        //当前包号
        bytes[14] = (byte) index;
        bytes[15] = (byte) (index >> 8);
        //命令码
        bytes[16] = cmd;
        //数据长度
        bytes[17] = (byte) packetLen;
        bytes[18] = (byte) (packetLen >> 8);
        System.arraycopy(date, 0, bytes, 19, packetLen);
        tmp = getCrc16(bytes, 4, bytes.length - 3);
        bytes[bytes.length - 3] = (byte) tmp;
        bytes[bytes.length - 2] = (byte) (tmp >> 8);
        bytes[bytes.length - 1] = (byte) 0x16;
        return bytes;
    }

    public static byte[] formatSendBytes(String addr, byte cmd, byte... date) {
        return formatSendBytes(addr, cmd, 1, 1, date);
    }

    /**
     * 地址表记录分包
     *
     * @param addr     集中器地址
     * @param list     地址表记录
     * @param countAll 总记录数
     * @return 数据包
     */
    public static byte[][] formatSendAddress(String addr, List<HotAndValve> list, int countAll) {
        int recordCount = list.size();
        int packetCount = (int) Math.ceil(recordCount / 15.0);
        byte[][] bytes = new byte[packetCount][];
        for (int i = 0; i < packetCount; i++) {
            byte[] tmp = addressInfoToBytes(list, i * 15, countAll);
            tmp = formatSendBytes(addr, Agreement.SEND_ADDRESS, packetCount, (i + 1), tmp);
            bytes[i] = tmp;
        }
        return bytes;
    }

    /**
     * 获取 ModBus crc16校验
     *
     * @param bytes 要校验的数据
     * @param from  开始位置
     * @param to    校验长度
     * @return 校验码
     */
    public static int getCrc16(byte[] bytes, int from, int to) {
        int crc = 0xffff;
        for (int i = from; i < to; i++) {
            crc = crc ^ (bytes[i] & 0xff);
            for (int j = 0; j < 8; j++) {
                if ((crc & 0x0001) > 0) {
                    crc = crc >> 1;
                    crc = crc ^ 0xA001;
                } else {
                    crc = crc >> 1;
                }
            }
        }
        return crc;
    }

    /**
     * 获取和校验
     *
     * @param bytes 要校验的数据
     * @param from  开始位置
     * @param to    校验长度
     * @return 校验码
     */
    public static byte cs(byte[] bytes, int from, int to) {
        byte sum = 0;
        int ss = 0;
        for (int i = from; i < to; i++) {
            sum += bytes[i];
            ss += bytes[i] & 0xff;
        }
        return sum;
    }
}
