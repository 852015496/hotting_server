package com.hetting.hottable.utils;


import com.hetting.hottable.connect.TcpPackage;
import com.hetting.hottable.entity.Concent;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 报文接收校验工具类
 *
 * @author Mr.J
 * @Date 2019/12/6 - 9:38
 */
public class MessageUtil {

    private static final int CHECK_LENGTH = 32;
    private static final byte[] PACKAGE_START = {(byte) 0xAC, (byte) 0x97, (byte) 0x30, (byte) 0x63};
    private static final byte[] GPRS_START = {(byte) 0x20, (byte) 0x19, (byte) 0x00, (byte) 0x02};

    /**
     * 字节数组格式化，将字节数组转为字符串，方便打印
     *
     * @param bytes 字节数组
     * @return 字符串
     */
    public static String byteFormat(byte[] bytes) {
        StringBuilder builder = new StringBuilder("[");
        for (byte b : bytes) {
            /*      %02X的含义
             *  x 表示以十六进制形式输出
             *  02 表示不足两位,，前面补0输出，如果超过两位，则以实际输出
             *  根据前面得到的bytes的长度转换成String
             **/
            builder.append(String.format("%02X", b));
            builder.append(" ");
        }
        builder.append("] ");
        //得到循环出来数组长度
        builder.append(bytes.length);
        return builder.toString();
    }

    /**
     * 字节数组转文本，发送给前端展示
     *
     * @param bytes 数据
     * @return 字符串
     */
    public static String byteFormat1(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
            builder.append(" ");
        }
        return builder.toString();
    }

    /**
     * 字符串转int
     *
     * @param str 字符串
     * @return int值
     */
    public static int stringToInt(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        str = str.trim();
        return Integer.parseInt(str);
    }

    /**
     * 字符串转double
     *
     * @param str 字符串
     * @return double值
     */
    public static double stringToDouble(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0.0;
        }
        str = str.trim();
        return Double.parseDouble(str);
    }

    public static int pow(int a, int b) {
        return (int) Math.pow(a * 1.0, b * 1.0);
    }

    /**
     * 检查当前数据包是不是第一包
     *
     * @param bytes 数据包
     * @return 开始标志出现的位置（-1未找到）
     */
    public static int checkPackageStart(byte[] bytes) {
        //bytes数据包的长度,检验长度为32
        /**
         * 获取到数据包的长度,检验长度可随意设定,
         * 根据数据包的格式:FE FE AC 97 30进行比较
         *  如果可以找到这个开头的角标就说明是集中器发的有效数据包，
         *  如果找不到就说明是无效数据
         **/
        int len = Math.min(bytes.length, CHECK_LENGTH);
        for (int i = 0; i < len; i++) {
            if (bytes[i] == PACKAGE_START[0] && i + 3 < bytes.length) {
                if (bytes[i + 1] == PACKAGE_START[1] && bytes[i + 2] == PACKAGE_START[2]
                        && bytes[i + 3] == PACKAGE_START[3]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 分包接收-校验每包数据并拆分
     *
     * @param bytes 数据包
     * @return 拆分结果
     */
    public static TcpPackage verifyPackage(byte[] bytes) {
        //获得有效数据或者无效数据
        int start = checkPackageStart(bytes);
        //如果是无效数据代表集中器没有上报信息
        if (start == -1) {
            return null;
        }
        /*  & 0xff作用
         *    &表示按位与,只有两个位同时为1,才能得到1,
         *    0x代表16进制数,
         *    0xff表示的数二进制1111 1111 占一个字节.
         *    和其进行&操作的数,最低8位,不会发生变化
         *
         **/
        int len = (bytes[13 + start] & 0xff) + ((bytes[14 + start] & 0xff) << 8);
        bytes = Arrays.copyOfRange(bytes, start, start + len + 17);
        int crc = ByteUtil.getCrc16(bytes, 0, bytes.length - 2);
        int dataCrc = (bytes[bytes.length - 1] & 0xff) * 256 + (bytes[bytes.length - 2] & 0xff);
        if (crc != dataCrc) {
            return null;
        }
        //创建对象
        TcpPackage basePackage = new TcpPackage();
        //获取上报解析后的集中器地址
        basePackage.setJzq(MessageUtil.getAddress(bytes));
        int count = (bytes[8] & 0xff) + ((bytes[9] << 8) & 0xff);
        basePackage.setPackageCount(count);
        int index = (bytes[10] & 0xff) + ((bytes[11] << 8) & 0xff);
        basePackage.setPackageIndex(index);
        basePackage.setCmd(bytes[12]);
        basePackage.setDataLen(len);
        basePackage.setData(Arrays.copyOfRange(bytes, 15, bytes.length - 2));
        return basePackage;
    }

    /**
     * 从报文中获取集中器地址
     *
     * @param bytes 数据包
     * @return 集中器地址
     */
    private static String getAddress(byte[] bytes) {
        int addr = (bytes[7] & 0xff) << 24;
        addr += (bytes[6] & 0xff) << 16;
        addr += (bytes[5] & 0xff) << 8;
        addr += bytes[4] & 0xff;

        return String.format("%08d", addr);
    }

    /**
     * 文本转字节数组
     *
     * @param msg 文本
     * @return 字节数组
     */
    public static byte[] msgFormat(String msg) {
        msg = msg.trim();
        msg = msg.replace(" ", "");
        char[] array = msg.toCharArray();
        byte[] bytes = new byte[array.length / 2];
        for (int i = 0; i < bytes.length; i++) {
            int tmp = Integer.parseInt(array[i * 2] + "", 16) * 16;
            tmp += Integer.parseInt(array[i * 2 + 1] + "", 16);
            bytes[i] = (byte) tmp;
        }
        return bytes;
    }

    /**
     * 透传结结束标志检查
     *
     * @param bytes 透传收到的数据
     * @return 是否有结束标志
     */
    public static boolean withCloseFlag(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) == 'R') {
                if ((bytes[i + 1] & 0xff) == 'E' && (bytes[i + 2] & 0xff) == 'G') {
                    return true;
                }
            }
        }
        return false;
    }


    //校验插座
    /*public static int checkChazuoStart(byte[] bytes) {
        int len = Math.min(bytes.length, CHECK_LENGTH);
        for (int i = 0; i < len; i++) {
            if (bytes[i] == GPRS_START[0] && i + 3 < bytes.length) {
                if (bytes[i + 1] == GPRS_START[1] && bytes[i + 2] == GPRS_START[2]
                        && bytes[i + 3] == GPRS_START[3]) {
                    return i;
                }
            }
        }
        return -1;
    }*/


   //验证插座
    /*public static byte[] verifyChazuo(byte[] bytes) {
        int start = checkChazuoStart(bytes);
        if (start == -1) {
            return null;
        }
        int len = ((bytes[12 + start] & 0xff) << 8) + (bytes[13 + start] & 0xff);
        bytes = Arrays.copyOfRange(bytes, start, start + len + 15);
        int sum = ByteUtil.cs(bytes, 4, bytes.length - 1);
        if (bytes[bytes.length - 1] != (byte) sum) {
            return null;
        }
        return bytes;
    }*/

}
