package com.hetting.hottable.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.mqttEMQ.bean.PushPayload;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description TODO
 * @Author zhangwentao
 **/
public class MySQLDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/heattable?autoReconnect=true&useSSL=false&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    static final String DB_URL = "jdbc:mysql://42.159.9.10:3306/heattable?autoReconnect=true&useSSL=false&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    static final String USER = "root";
//    static final String PASS = "root";
    static final String PASS = "Quarkdata!2020";

    //集中器心跳/注册
    public void addPant(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "update hot set hot_status = ? where hot_address = ? ";
        String sql2 = "update valve set valve_status = ? where valve_address = ? ";
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            System.out.println(" 实例化Statement对象...");
            conn.setAutoCommit(false);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("Device");
            for (int i = 0; i < jsonArray.size(); i++) {
                String hotAddress = jsonArray.getJSONObject(i).getString("MeterID"); //热表地址
                String hotStatus = jsonArray.getJSONObject(i).getString("meterStatus");   //热表状态
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, hotAddress);
                pstm.setString(2, hotStatus);
                pstm.executeUpdate();
                System.err.println("热表状态已更新!");
            }
            for (int i = 0; i < jsonArray.size(); i++) {
                pstm = conn.prepareStatement(sql2);
                String valveAddres = jsonArray.getJSONObject(i).getString("ValveID"); //阀门地址
                String valveStatus = jsonArray.getJSONObject(i).getString("valveStatus");   //阀门状态
                pstm.setString(1, valveAddres);
                pstm.setString(2, valveStatus);
                pstm.executeUpdate();
                System.err.println("阀门状态已更新!");
            }
            //提交事务
            conn.commit();
            System.out.println("集中器心跳注册成功!");
        } catch (Exception ex) {
            //回滚事务
            try {
                conn.rollback();
                System.out.println("回滚集中器心跳!");
                System.out.println("JDBC Transaction rolled back successfully");
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
                e1.printStackTrace();
            }
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void addConcentMessage(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer userId = null;
        String sql = "insert into concent_message (concent_code,work_time) values (?,?)";
        String sql2 = "insert into hot_message (hot_status,hot_status_name,cooling,hotting,power,sumflow,vol,hot_entrance,hot_exit,user_id) values (?,?,?,?,?,?,?,?,?,?)";
        String sql3 = "insert into valve_message (user_id,temp_adjust,valve_work_mode,valve_flag,test_pycle,vintemp,end_time,vouttemp,apportion_hot,start_time) values (?,?,?,?,?,?,?,?,?,?)";
        String sql4 = "update hot set hot_aisle = ?,hot_modal = ?,hot_type = ? ,last_cooling = ? ,last_hotting = ?,last_power = ?,last_sumflow = ? ,last_vol = ? ,last_hot_entrance = ?,last_hot_exit = ? where hot_address = ? ";
        String sql5 = " update valve set valve_chn = ?,valve_arrFlag = ?,last_valve_work_mode = ? ,last_flag = ? ,report_time = ?,last_vintemp = ?,last_vouttemp = ? ,last_updateDate = ? ,apportion_hot = ?,last_valve_open = ?,valve_status = ? where valve_address = ? ";
        String sql6 = " update user set user_area = ? where user_concent_code = ? ";
        String sql7 = "select user_id from user where user_concent_code = ? ";

        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            System.err.println("集中器上报开始");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行 集中器信息sql
            System.out.println(" 实例化Statement对象...");
//            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql7);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            String edgeId = jsonObject.getString("Edge_ID");
            //占位符赋值
            pstm.setString(1, edgeId);
            //执行query
            rs = pstm.executeQuery();
            System.err.println("结果集 ----->" + rs);
            //获取结果集
            while (rs.next()){
                userId = rs.getInt("user_id");    //设备id
                System.err.println(userId);
            }
//            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql);
            System.err.println(message.toString());
            String time = jsonObject.getString("TimeStamp");
            pstm.setString(1, edgeId);
            pstm.setString(2, time);
            pstm.executeUpdate();
            System.out.println("执行concent_messaget");
            //执行 热表信息表信息
//            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql2);
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String status = jsonArray.getJSONObject(0).getString("status"); //状态
            String rcdType = jsonArray.getJSONObject(0).getString("rcdType");   //状态类型
//            String shareMeterRcd = jsonArray.getJSONObject(0).getString("shareMeterRcd");
            String cold = jsonArray.getJSONObject(0).getString("cold"); //冷量
            String hot = jsonArray.getJSONObject(0).getString("hot");   //热量
            String power = jsonArray.getJSONObject(0).getString("power");   //功率
            String flux = jsonArray.getJSONObject(0).getString("flux"); //流速
            String vol = jsonArray.getJSONObject(0).getString("vol"); //流量
            String intemp = jsonArray.getJSONObject(0).getString("intemp");//进水温度
            String outTemp = jsonArray.getJSONObject(0).getString("outtemp");//回水温度
            pstm.setString(1, status);
            pstm.setString(2, rcdType);
            pstm.setString(3, cold);
            pstm.setString(4, hot);
            pstm.setString(5, power);
            pstm.setString(6, flux);
            pstm.setString(7, vol);
            pstm.setString(8, intemp);
            pstm.setString(9, outTemp);
            pstm.setInt(10, userId);
            pstm.executeUpdate();
            System.out.println("执行 hot_messaget");
            // 执行 阀门信息表
//            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql3);
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String arrFlag = jsonArray.getJSONObject(0).getString("arrFlag");//阀门接入通道
            String valveWorkMode = jsonArray.getJSONObject(0).getString("valveWorkMode");//阀门工作模式
            String mode = jsonArray.getJSONObject(0).getString("mode");//更新状态
            String workTime = jsonArray.getJSONObject(0).getString("worktime");//累计工作时间
            String vintemp = jsonArray.getJSONObject(0).getString("vintemp");//阀门进水温度
            String vOutTemp = jsonArray.getJSONObject(0).getString("vouttemp");//阀门回水温度
            String openTime = jsonArray.getJSONObject(0).getString("opentime");//阀门更新时间
            String shareHeat = jsonArray.getJSONObject(0).getString("shareHeat");//分摊热量
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            System.err.println(date);
            pstm.setInt(1, userId);
            pstm.setString(2, arrFlag);
            pstm.setString(3, valveWorkMode);
            pstm.setString(4, mode);
            pstm.setString(5, workTime);
            pstm.setString(6, vintemp);
            pstm.setString(7, vOutTemp);
            pstm.setString(8, openTime);
            pstm.setString(9, shareHeat);
            pstm.setDate(10,date);
            pstm.executeUpdate();
            System.out.println("执行 valve_messaget");
            // 更新 热表中的信息
            pstm = conn.prepareStatement(sql4);
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String meterChn = jsonArray.getJSONObject(0).getString("meterChn"); //热表接入通道
            String meterTypeAddr = jsonArray.getJSONObject(0).getString("meterTypeAddr");//热表地址
            String status1 = jsonArray.getJSONObject(0).getString(mode); //状态   status 暂无此值
            String rcdType1 = jsonArray.getJSONObject(0).getString(arrFlag);   //状态类型 rcdType 暂无此值
//            String shareMeterRcd = jsonArray.getJSONObject(0).getString("shareMeterRcd");
            String cold1 = jsonArray.getJSONObject(0).getString("cold"); //冷量
            String hot1 = jsonArray.getJSONObject(0).getString("hot");   //热量
            String power1 = jsonArray.getJSONObject(0).getString("power");   //功率
            String flux1 = jsonArray.getJSONObject(0).getString("flux"); //流速
            String vol1 = jsonArray.getJSONObject(0).getString("vol"); //流量
            String intemp1 = jsonArray.getJSONObject(0).getString("intemp");//进水温度
            String outTemp1 = jsonArray.getJSONObject(0).getString("outtemp");//回水温度
            pstm.setString(1, meterChn);
            pstm.setString(2, mode);
            pstm.setString(3, arrFlag); //
            pstm.setString(4, cold1);
            pstm.setString(5, hot1);
            pstm.setString(6, power1);
            pstm.setString(7, flux1);
            pstm.setString(8, vol1);
            pstm.setString(9, intemp1);
            pstm.setString(10, outTemp1);
            pstm.setString(11, meterTypeAddr);
            pstm.executeUpdate();
            System.out.println("更新 hot ");

            pstm = conn.prepareStatement(sql5);
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String valveChn = jsonArray.getJSONObject(0).getString("valveChn"); //阀门接入通道
            String arrFlag2 = jsonArray.getJSONObject(0).getString("arrFlag");//阀门欠费标志
            String valveWorkMode2 = jsonArray.getJSONObject(0).getString("valveWorkMode");//阀门工作模式
            String mode2 = jsonArray.getJSONObject(0).getString("mode");//更新状态
            String workTime2 = jsonArray.getJSONObject(0).getString("worktime");//累计工作时间
            String vintemp2 = jsonArray.getJSONObject(0).getString("vintemp");//阀门进水温度
            String vOutTemp2 = jsonArray.getJSONObject(0).getString("vouttemp");//阀门回水温度
            String openTime2 = jsonArray.getJSONObject(0).getString("opentime");//阀门更新时间
            String shareHeat2 = jsonArray.getJSONObject(0).getString("shareHeat");//分摊热量
            String openRate = jsonArray.getJSONObject(0).getString("openRate");//阀门开度
            String valveStatus = jsonArray.getJSONObject(0).getString("stat");//阀门状态
            String valveTypeAddr = jsonArray.getJSONObject(0).getString("valveTypeAddr");//阀门地址
            pstm.setString(1, valveChn);
            pstm.setString(2, arrFlag2);
            pstm.setString(3, valveWorkMode2);
            pstm.setString(4, mode2);
            pstm.setString(5, workTime2);
            pstm.setString(6, vintemp2);
            pstm.setString(7, vOutTemp2);
            pstm.setString(8, openTime2);
            pstm.setString(9, shareHeat2);
            pstm.setString(10, openRate);
            pstm.setString(11, valveStatus);
            pstm.setString(12, valveTypeAddr);
            pstm.executeUpdate();
            System.out.println("更新 valve ");
            //更新用户供热面积
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql6);
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String roomArea = jsonArray.getJSONObject(0).getString("roomArea"); //阀门接入通道
            pstm.setString(1, roomArea);
            pstm.setString(2, edgeId);
            pstm.executeUpdate();
            System.out.println("更新用户表 ");
            //提交事务
//            conn.commit();
            System.out.println("集中器上报成功成功!");
        } catch (Exception ex) {
            //回滚事务
           /* try {
                conn.rollback();
                System.out.println("回滚成功!");
                System.out.println("JDBC Transaction rolled back successfully");
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
                e1.printStackTrace();
            }*/
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //集中器上报增加热表信息
    public void addHotMessage(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            System.out.println(" 实例化Statement对象...");
            String sql = "insert into hot_message (hot_status,hot_status_name,cooling,hotting,power,sumflow,vol,hot_entrance,hot_exit) values (?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String status = jsonArray.getJSONObject(0).getString("status"); //状态
            String rcdType = jsonArray.getJSONObject(0).getString("rcdType");   //状态类型
//            String shareMeterRcd = jsonArray.getJSONObject(0).getString("shareMeterRcd");
            String cold = jsonArray.getJSONObject(0).getString("cold"); //冷量
            String hot = jsonArray.getJSONObject(0).getString("hot");   //热量
            String power = jsonArray.getJSONObject(0).getString("power");   //功率
            String flux = jsonArray.getJSONObject(0).getString("flux"); //流速
            String vol = jsonArray.getJSONObject(0).getString("vol"); //流量
            String intemp = jsonArray.getJSONObject(0).getString("intemp");//进水温度
            String outTemp = jsonArray.getJSONObject(0).getString("outtemp");//回水温度
            pstm.setString(1, status);
            pstm.setString(2, rcdType);
            pstm.setString(3, cold);
            pstm.setString(4, hot);
            pstm.setString(5, power);
            pstm.setString(6, flux);
            pstm.setString(7, vol);
            pstm.setString(8, intemp);
            pstm.setString(9, outTemp);
            pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("新增成功!");
    }

    //集中器上报增加热表信息
    public void addValveMessage(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            System.out.println(" 实例化Statement对象...");
            String sql = "insert into valve_message (temp_adjust,valve_work_mode,valve_flag,test_pycle,vintemp,vouttemp,end_time,apportion_hot) values (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String arrFlag = jsonArray.getJSONObject(0).getString("arrFlag");//阀门接入通道
            String valveWorkMode = jsonArray.getJSONObject(0).getString("valveWorkMode");//阀门工作模式
            String mode = jsonArray.getJSONObject(0).getString("mode");//更新状态
            String workTime = jsonArray.getJSONObject(0).getString("worktime");//累计工作时间
            String vintemp = jsonArray.getJSONObject(0).getString("vintemp");//阀门进水温度
            String vOutTemp = jsonArray.getJSONObject(0).getString("vouttemp");//阀门回水温度
            String openTime = jsonArray.getJSONObject(0).getString("opentime");//阀门更新时间
            String shareHeat = jsonArray.getJSONObject(0).getString("shareHeat");//分摊热量
            pstm.setString(1, arrFlag);
            pstm.setString(2, valveWorkMode);
            pstm.setString(3, mode);
            pstm.setString(4, workTime);
            pstm.setString(5, vOutTemp);
            pstm.setString(6, openTime);
            pstm.setString(7, shareHeat);
            pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("新增成功!");
    }

    //hot表信息
    public void updateHot(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            System.out.println(" 实例化Statement对象...");
            String sql = "update hot set hot_aisle = ?,hot_modal = ?,hot_type = ? ,last_cooling = ? ,last_hotting = ?,last_power = ?,last_sumflow = ? ,last_vol = ? ,last_hot_entrance = ?,last_hot_exit = ? where hot_address = ? ";
            pstm = conn.prepareStatement(sql);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String meterChn = jsonArray.getJSONObject(0).getString("meterChn"); //热表接入通道
            String meterTypeAddr = jsonArray.getJSONObject(0).getString("meterTypeAddr");//热表地址
            String status = jsonArray.getJSONObject(0).getString("status"); //状态
            String rcdType = jsonArray.getJSONObject(0).getString("rcdType");   //状态类型
//            String shareMeterRcd = jsonArray.getJSONObject(0).getString("shareMeterRcd");
            String cold = jsonArray.getJSONObject(0).getString("cold"); //冷量
            String hot = jsonArray.getJSONObject(0).getString("hot");   //热量
            String power = jsonArray.getJSONObject(0).getString("power");   //功率
            String flux = jsonArray.getJSONObject(0).getString("flux"); //流速
            String vol = jsonArray.getJSONObject(0).getString("vol"); //流量
            String intemp = jsonArray.getJSONObject(0).getString("intemp");//进水温度
            String outTemp = jsonArray.getJSONObject(0).getString("outtemp");//回水温度
            pstm.setString(1, meterChn);
            pstm.setString(2, status);
            pstm.setString(3, rcdType);
            pstm.setString(4, cold);
            pstm.setString(5, hot);
            pstm.setString(6, flux);
            pstm.setString(7, vol);
            pstm.setString(8, intemp);
            pstm.setString(9, outTemp);
            pstm.setString(10, meterTypeAddr);
            pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("新增成功!");
    }
    //valve 信息
    public void updateValve(MqttMessage message) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            System.out.println(" 实例化Statement对象...");
            String sql = " update valve set valve_chn = ?,valve_arrFlag = ?,last_valve_work_mode = ? ,last_flag = ? ,report_time = ?,last_vintemp = ?,last_vouttemp = ? ,last_updateDate = ? ,apportion_hot = ? where valve_address = ? ";
            pstm = conn.prepareStatement(sql);
            JSONObject jsonObject = JSONObject.parseObject(message.toString());
            JSONArray jsonArray = null;
            jsonArray = jsonObject.getJSONArray("dataRecords");
            String valveChn = jsonArray.getJSONObject(0).getString("valveChn"); //阀门接入通道
            String arrFlag = jsonArray.getJSONObject(0).getString("arrFlag");//阀门欠费标志
            String valveWorkMode = jsonArray.getJSONObject(0).getString("valveWorkMode");//阀门工作模式
            String mode = jsonArray.getJSONObject(0).getString("mode");//更新状态
            String workTime = jsonArray.getJSONObject(0).getString("worktime");//累计工作时间
            String vintemp = jsonArray.getJSONObject(0).getString("vintemp");//阀门进水温度
            String vOutTemp = jsonArray.getJSONObject(0).getString("vouttemp");//阀门回水温度
            String openTime = jsonArray.getJSONObject(0).getString("opentime");//阀门更新时间
            String shareHeat = jsonArray.getJSONObject(0).getString("shareHeat");//分摊热量
            String valveTypeAddr = jsonArray.getJSONObject(0).getString("valveTypeAddr");//阀门地址
            pstm.setString(1, valveChn);
            pstm.setString(2, arrFlag);
            pstm.setString(3, valveWorkMode);
            pstm.setString(4, mode);
            pstm.setString(5, workTime);
            pstm.setString(6, vintemp);
            pstm.setString(7, vOutTemp);
            pstm.setString(8, openTime);
            pstm.setString(9, shareHeat);
            pstm.setString(10, valveTypeAddr);
            pstm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("新增成功!");
    }

    //给集中器发送消息
    public PushPayload queryConcentMessage(String ConcentCode) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PushPayload pushMessage = null;
        String sql = " select * from concent c left join hot h on c.concent_id = h.concent_id left join  valve v on c.concent_id = v.concent_id left join user u on u.concent_id = c.concent_id where concent_code = ? ";
//        String sql2 = " select * from hot h left join valve v on h.concent_id = v.concent_id left join user u on u.concent_id = v.concent_id  where h.concent_id = ? ";
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            conn.setAutoCommit(false);
            System.out.println(" 实例化Statement对象...");
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,ConcentCode);
            rs = pstm.executeQuery();
            String concentId,concentCode,housing,cell,building,roomNum,address;
            System.err.println("结果集 ----->" + rs);
            while (rs.next()){
                concentId = rs.getString("concent_id");
                concentCode = rs.getString("concent_code");
                housing = rs.getString("housing");
                cell = rs.getString("cell");
                building = rs.getString("building");
                roomNum = rs.getString("roomNum");
                address = housing + cell + building + roomNum;
                System.err.println(concentId + "\t" + concentCode + "\t" + address );
                System.out.println("查询 concent");

                String type,meterFac,meterChn,meterTypeAddr,shareMeterRcd,roomArea,valveFlag,valveFac,valveChn,valveTypeAddr,
                        arrFlag,valveWorkMode,openRate,minOpenRate,maxOpenRate,antirustTmo,testTempIntv,tempAdjust,lowVar,highVar,
                        setTemp,setpower,setflux,CurveSapample,temp,open,shareHeat;
                JSONArrayBuilder jsonArry = new JSONArrayBuilder();
                    jsonArry.newObject();
//                    jsonArry.put("type",rs.getString("hot_modal")); //热表类型    web界面暂无
                    jsonArry.put("meterFac",rs.getString("hotVender_name"));  //热表厂家代码
                    jsonArry.put("meterChn",rs.getString("hot_aisle"));   //热表接入通道
                    jsonArry.put("meterTypeAddr",rs.getString("hot_address"));    //热表地址
//                    jsonArry.put("shareMeterRcd",rs.getString("暂无此数据"));//共享热表记录偏移编号
                    jsonArry.put("roomArea",rs.getString("user_area"));   //用户面积
//                    jsonArry.put("valveFlag",rs.getString("valve_update")); //阀门更新标志
                    jsonArry.put("valveFac",rs.getString("valveVender_name")); //阀门厂家代码
                    jsonArry.put("valveChn",rs.getString("valve_chn"));   //阀门接入通道
                    jsonArry.put("valveTypeAddr",rs.getString("valve_address"));  //阀门地址
//                    jsonArry.put("arrFlag",rs.getString("valve_arrFlag"));    //阀门欠费标志
                    jsonArry.put("valveWorkMode",rs.getString("valve_work_mode"));    //阀门工作模式
//                    jsonArry.put("openRate",rs.getString("opening")); //阀门开度
//                    jsonArry.put("minOpenRate",rs.getString("min_open"));//阀门最小开度
//                    jsonArry.put("maxOpenRate",rs.getString("max_open"));//阀门最大开度
//                    jsonArry.put("antirustTmo",rs.getString("rust_sport"));//阀门防锈动作
//                    jsonArry.put("testTempIntv",rs.getString("temp_interval"));//测温间隔
//                    jsonArry.put("tempAdjust",rs.getString("temp_adjust"));//温度调节
//                    jsonArry.put("lowVar",rs.getString("temp_lower"));//控温下限
//                    jsonArry.put("highVar",rs.getString("temp_upper"));//控温上限
//                    jsonArry.put("setTemp",rs.getString("set_temp_value"));//设置温度
//                    jsonArry.put("setpower",rs.getString("set_power"));//设置功率
//                    jsonArry.put("setflux",rs.getString("set_flow"));//设置流速
////                    jsonArry.put("CurveSapample",rs.getString("暂无此数据"));//热表图
//                    jsonArry.put("shareHeat",rs.getString("apportion_hot"));//分摊初始值
                    jsonArry.endObject();
                    pushMessage = PushPayload.getPushPayloadBuider()
                            .setEdge_ID(concentCode)
                            .setName(concentCode)
                            .setTimeStamp("157234221231")
                            .setAddress(address)
                            .setData(jsonArry.toJsonString())
                            .bulid();
                    System.err.println("集中器消息发布完成");
            }
            /*String type,meterFac,meterChn,meterTypeAddr,shareMeterRcd,roomArea,valveFlag,valveFac,valveChn,valveTypeAddr,
                    arrFlag,valveWorkMode,openRate,minOpenRate,maxOpenRate,antirustTmo,testTempIntv,tempAdjust,lowVar,highVar,
                    setTemp,setpower,setflux,CurveSapample,temp,open,shareHeat;
            JSONArrayBuilder jsonArry = new JSONArrayBuilder();
            while (rs.next()){
                jsonArry.newObject();
                jsonArry.put("type",rs.getString("hot_type")); //热表类型
                jsonArry.put("meterFac",rs.getString("hotVender_code"));  //热表厂家代码
                jsonArry.put("meterChn",rs.getString("hot_aisle"));   //热表接入通道
                jsonArry.put("meterTypeAddr",rs.getString("hot_address"));    //热表地址
//                    jsonArry.put("shareMeterRcd",rs.getString("暂无此数据"));//共享热表记录偏移编号
                jsonArry.put("roomArea",rs.getString("user_area"));   //用户面积
                jsonArry.put("valveFlag",rs.getString("valve_update")); //阀门更新标志
                jsonArry.put("valveFac",rs.getString("valve_code")); //阀门厂家代码
                jsonArry.put("valveChn",rs.getString("valve_chn"));   //阀门接入通道
                jsonArry.put("valveTypeAddr",rs.getString("valve_address"));  //阀门地址
                jsonArry.put("arrFlag",rs.getString("valve_arrFlag"));    //阀门欠费标志
                jsonArry.put("valveWorkMode",rs.getString("valve_work_mode"));    //阀门工作模式
                jsonArry.put("openRate",rs.getString("opening")); //阀门开度
                jsonArry.put("minOpenRate",rs.getString("min_open"));//阀门最小开度
                jsonArry.put("maxOpenRate",rs.getString("max_open"));//阀门最大开度
                jsonArry.put("antirustTmo",rs.getString("rust_sport"));//阀门防锈动作
                jsonArry.put("testTempIntv",rs.getString("temp_interval"));//测温间隔
                jsonArry.put("tempAdjust",rs.getString("temp_adjust"));//温度调节
                jsonArry.put("lowVar",rs.getString("temp_lower"));//控温下限
                jsonArry.put("highVar",rs.getString("temp_upper"));//控温上限
                jsonArry.put("setTemp",rs.getString("set_temp_value"));//设置温度
                jsonArry.put("setpower",rs.getString("set_power"));//设置功率
                jsonArry.put("setflux",rs.getString("set_flow"));//设置流速
//                    jsonArry.put("CurveSapample",rs.getString("暂无此数据"));//热表图
                jsonArry.put("shareHeat",rs.getString("apportion_hot"));//分摊初始值
                jsonArry.endObject();
                pushMessage = PushPayload.getPushPayloadBuider()
//                        .setEdge_ID(concentId)
//                        .setName(concentCode)
//                        .setTimeStamp("157234221231")
//                        .setAddress(address)
                        .setData(jsonArry.toJsonString())
                        .bulid();
                System.err.println("集中器消息发布完成");
            }*/
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return pushMessage;
    }

    //点名抄表
    public PushPayload queryMeterMessage(Integer userId) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PushPayload pushMessage = null;
        String sql = "select * from user u left join hot h on u.user_id = h.user_id left join concent c on c.concent_id = h.concent_id where u.user_id = ? ";
//        String sql2 = " select * from hot h left join valve v on h.concent_id = v.concent_id left join user u on u.concent_id = v.concent_id  where h.concent_id = ? ";
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            conn.setAutoCommit(false);
            System.out.println(" 实例化Statement对象...");
            pstm = conn.prepareStatement(sql);
            //占位符赋值
            pstm.setInt(1,userId);
            //执行query
            rs = pstm.executeQuery();
            String concentId;
            System.err.println("结果集 ----->" + rs);
            //获取结果集
            while (rs.next()){
                String edgeId = rs.getString("user_concent_code");    //设备id
                System.out.println("点名抄表 hot");
                //创建json数组
                JSONArrayBuilder jsonArry = new JSONArrayBuilder();
                jsonArry.newObject();
                jsonArry.put("vavleflag",rs.getString("hot_aisle_status")); //热表状态
                jsonArry.put("valvefac",rs.getString("hot_address"));  //热表地址
                jsonArry.put("valvechn",rs.getString("last_cooling"));   //冷量
                jsonArry.put("valvetypeaddr",rs.getString("last_hotting"));    //热量
                jsonArry.put("arrflag",rs.getString("last_power"));   //功率
                jsonArry.put("valveworkmode",rs.getString("last_sumflow")); //流速
                jsonArry.put("openrate",rs.getString("last_vol")); //累计流量
                jsonArry.put("minopenrate",rs.getString("last_hot_entrance"));   //进水温度
                jsonArry.put("maxopenrate",rs.getString("last_hot_exit"));  //回水温度
                jsonArry.put("antirusttmo",rs.getString("last_worktime"));    //累计工作时间
//                jsonArry.put("testtempintv",rs.getString("temp_interval"));    //stat1
//                jsonArry.put("lowvar",rs.getString("temp_lower")); //stat2
//                jsonArry.put("highvar",rs.getString("temp_upper"));//冷量单位
//                jsonArry.put("setTemp",rs.getString("set_temp_value"));//热量单位
                jsonArry.endObject();
                pushMessage = PushPayload.getPushPayloadBuider()
                        .setEdge_ID(edgeId)
                        .setMeterRecords(jsonArry.toJsonString())
                        .bulid();
                System.err.println("点名抄表发布完成");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return pushMessage;
    }

    public PushPayload readingValveCont(String valveWorkMode, Integer valveId,String concentCode) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PushPayload pushMessage = null;
        String sql = " select * from valve v left join concent c on c.concent_id = v.concent_id where v.valve_id = ? ";
//        String sql2 = " select * from hot h left join valve v on h.concent_id = v.concent_id left join user u on u.concent_id = v.concent_id  where h.concent_id = ? ";
        try {
            // JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 执行sql
            conn.setAutoCommit(false);
            System.out.println(" 实例化Statement对象...");
            pstm = conn.prepareStatement(sql);
            //占位符赋值
            pstm.setInt(1,valveId);
            //执行query
            rs = pstm.executeQuery();
            //定义接收参数类型
            String valveUpdate,venderCode,valveChn,valveAddress,valveArrFlag,valveWork,opening,minOpen,maxOpen,rustSport,tempInterval,tempLower,
                    tempUpper,setTempValue,setPower,setFlow,CurvenSapmle,apportionHot;
            System.err.println("结果集 ----->" + rs);
            //获取结果集
            while (rs.next()){
//                concentCode = rs.getString("concent_code");    //设备id
                valveWork = rs.getString("valve_work_mode");    //控制模式
                System.out.println("点名阀控 valve");
                //创建json数组
                JSONArrayBuilder jsonArry = new JSONArrayBuilder();
                jsonArry.newObject();
                jsonArry.put("vavleflag",rs.getString("valve_update")); //阀门更新标志
                jsonArry.put("valvefac",rs.getString("vender_code"));  //阀门生产厂家代码
                jsonArry.put("valvechn",rs.getString("valve_chn"));   //阀门接入通道
                jsonArry.put("valvetypeaddr",rs.getString("valve_address"));    //阀门类型地址
                jsonArry.put("arrflag",rs.getString("valve_arrFlag"));   //欠费标志
                jsonArry.put("valveworkmode",rs.getString("valve_work_mode")); //工作模式
                jsonArry.put("openrate",rs.getString("opening")); //开度
                jsonArry.put("minopenrate",rs.getString("min_open"));   //最小开度
                jsonArry.put("maxopenrate",rs.getString("max_open"));  //最大开度
                jsonArry.put("antirusttmo",rs.getString("rust_sport"));    //防锈周期
                jsonArry.put("testtempintv",rs.getString("temp_interval"));    //测温周期
                jsonArry.put("lowvar",rs.getString("temp_lower")); //温控值下限
                jsonArry.put("highvar",rs.getString("temp_upper"));//温控值上限
                jsonArry.put("setTemp",rs.getString("set_temp_value"));//设置温控值
                jsonArry.put("setpower",rs.getString("set_power"));//设置功率
                jsonArry.put("setflux",rs.getString("set_flow"));//设置流速
//                jsonArry.put("CurveSapample",rs.getString("暂无此数据"));//热表图
                jsonArry.put("shareHeat",rs.getString("apportion_hot"));//分摊热量初始值
                jsonArry.endObject();
                pushMessage = PushPayload.getPushPayloadBuider()
                        .setEdge_ID(concentCode)
                        .setType(valveWorkMode)
                        .setTimeStamp("157234221231")
                        .setGate(jsonArry.toJsonString())
                        .bulid();
                System.err.println("点名阀控发布完成");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return pushMessage;
    }
}
