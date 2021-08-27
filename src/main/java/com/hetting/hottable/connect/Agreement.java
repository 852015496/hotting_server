package com.hetting.hottable.connect;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 协议常量类
 *
 * @author Mr.J
 * @Date 2019/12/13 - 16:38
 */
public class Agreement {

//    //总线号
//    public static final byte BUS_MBUS1 = 1;
//    public static final byte BUS_MBUS2 = 2;
//    public static final byte BUS_MBUS3 = 3;
//    public static final byte BUS_MBUS4 = 4;
//    public static final byte BUS_485 = 8;
//    public static final byte BUS_LORA = 10;
//    //波特率
//    public static final byte BAUD_RATE_300 = 1;
//    public static final byte BAUD_RATE_600 = 2;
//    public static final byte BAUD_RATE_1200 = 3;
//    public static final byte BAUD_RATE_2400 = 4;
//    public static final byte BAUD_RATE_4800 = 5;
//    public static final byte BAUD_RATE_9600 = 6;
//    public static final byte BAUD_RATE_19200 = 7;
//    public static final byte BAUD_RATE_38400 = 8;
//    public static final byte BAUD_RATE_57600 = 9;
//    public static final byte BAUD_RATE_115200 = 10;
//    public static final byte BAUD_RATE_B230400 = 11;
//    public static final byte BAUD_RATE_B460800 = 12;
//    public static final byte BAUD_RATE_B921600 = 13;
//    //校验位
//    public static final byte PARITY_NONE = 78;
//    public static final byte PARITY_ODD = 79;
//    public static final byte PARITY_EVEN = 69;
//    //停止位
//    public static final byte STOP_BITS_ONE = 1;
//    public static final byte STOP_BITS_TWO = 2;

    //通信命令码

    public static final byte REC_LOGIN = 1;
    public static final byte REC_HEART = 2;
    public static final byte REC_ADDRESS_REQ = 3;
    public static final byte REC_ADDRESS_RES = (byte) 0x10;
    public static final byte REC_DATA = (byte) 0x11;
    public static final byte REC_CALL_READ = (byte) 0x20;
    public static final byte REC_CALL_CTRL = (byte) 0x21;
    public static final byte REC_START_TRAN = (byte) 0x30;
    public static final byte REC_UPDATE = (byte) 0x41;

    public static final byte SEND_LOGIN = (byte) 0x81;
    public static final byte SEND_HEART = (byte) 0x82;
    public static final byte SEND_RES_ADDR = (byte) 0x83;
    public static final byte SEND_REQ_DATA = (byte) 0x84;
    public static final byte SEND_UPDATE_FLAG = (byte) 0x85;
    public static final byte SEND_ADDRESS = (byte) 0x90;
    public static final byte SEND_RES_DATA = (byte) 0x91;
    public static final byte SEND_CALL_READ = (byte) 0xA0;
    public static final byte SEND_CALL_CTRL = (byte) 0xA1;
    public static final byte SEND_START_TRAN = (byte) 0xB0;
    public static final byte SEND_FIRMWARE = (byte) 0xC1;

    //无线协议命令码

    public static final byte REC_W_LOGIN = 6;
    public static final byte REC_W_HEART = 7;
    public static final byte REC_W_DATA = 8;

    public static final byte SEND_W_LOGIN = (byte) 0x96;
    public static final byte SEND_W_HEART = (byte) 0x97;
    public static final byte SEND_W_DATA = (byte) 0x98;

    //插座协议命令码

    public static final byte REC_C_PARAM = (byte) 0x08;
    public static final byte SEND_C_PARAM = (byte) 0x98;
    public static final byte REC_C_DATA = (byte) 0x09;
    public static final byte SEND_C_DATA = (byte) 0x99;

    public static final Map<String, Integer> ADDRESS_INDEX_MAP = new HashMap<>();
    public static final Map<String, Integer> ADDRESS_COUNT_MAP = new HashMap<>();
    public static final Map<String, byte[][]> ADDRESS_MAP = new HashMap<>();
    public static final Map<String, Object> FIRMWARE_MAP = new HashMap<>();
    public static final Map<Integer, Integer> PACKED_COUNT = new HashMap<>();
//    public static final Map<String, List<QxnTableValveIntegration>> HISTORY_ERROR = new HashMap<>();

    //redis键名

    public static final String TCP_CONCENTRATOR = "tcp_concentrator:";
    public static final String TCP_METERS_LIST = "tcp_meters_list:";
    public static final String TCP_HISTORY_LIST = "tcp_history_list:";

    public static final String HTTP_CONCENTRATOR = "http_concentrator:";
    public static final String HTTP_METERS_LIST = "http_meters_list:";
    public static final String HTTP_VALVE_LIST = "http_valve_list:";

    public static final String WIRELESS_CONCENTRATOR = "wireless_concentrator:";
    public static final String WIRELESS_METER = "wireless_meter:";

    public static final String UPDATE_FIRMWARE_COUNT = "firmware_count:";

    public static final String CALL_READ_WRITE_FLAG = "call_time_flag:";
    public static final String HISTORY_INDEX_FLAG = "history_index_flag:";

}
