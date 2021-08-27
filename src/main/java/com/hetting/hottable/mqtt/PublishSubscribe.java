package com.hetting.hottable.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.hetting.hottable.utils.MySQLDemo;
import com.hetting.hottable.utils.SpringContextUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import springfox.documentation.spring.web.json.Json;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @Description TODO mqtt的发布和订阅
 * @Author zhangwentao
 **/
public class PublishSubscribe {
    private static MqttClient client;
    private static String serviceURI = "tcp://42.159.87.162:1883";
    private static String clientID = UUID.randomUUID().toString();
    private static MqttClientPersistence persistence = new MemoryPersistence();
    //如果mqtt服务配置了匿名访问，则不需要使用用户名和密码就可以实现消息的订阅和发布
//    private static String username = "username";
//    private static String password = "password";
    private static String topic = "1234";
//    private static Json message = ""
    /*
        消息服务质量，一共有三个：
        0：尽力而为。消息可能会丢，但绝不会重复传输
        1：消息绝不会丢，但可能会重复传输
        2：恰好一次。每条消息肯定会被传输一次且仅传输一次
     */
    private static int qos = 2;

  /**
   * @Author ZhangWenTao
   * @Description //TODO    消息发布
   **/
    public static void publish() {
        try {
            MqttClient client = new MqttClient(serviceURI, clientID, persistence);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
//            connectOptions.setUserName(username);
//            connectOptions.setPassword(password.toCharArray());
            connectOptions.setCleanSession(false);
            //发布者连接服务
            client.connect(connectOptions);
            System.out.println("发布者连接状态： " + client.isConnected());
            MqttTopic mqttTopic = client.getTopic(topic);
            //MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            int i = 1;
            String message = ("[{       \n" +
                    "\t\"type\":\"\",\t\t\t//档案性质\n" +
                    "\t\"meterFac\":\"\",\t\t//热表生产厂商代码\n" +
                    "\t\"meterChn\":\"\",\t\t//热表接入的抄表通道1-4 MBUS  8=485   10=Lora\n" +
                    "\t\"meterTypeAddr\":\"\",//热表类型代码+表码\n" +
                    "\t\"shareMeterRcd\":\"\",\t//共享热表的记录偏移编号\n" +
                    "\t\"roomArea\":\"\",\t\t//住房面积\n" +
                    "\t\"valveFlag\":\"\",\t\t//阀门信息更新标志\n" +
                    "\t\"valveFac\":\"\",\t\t//阀门厂家代码\n" +
                    "\t\"valveChn\":\"\",\t\t//阀门接入的抄表通道\n" +
                    "\t\"valveTypeAddr\":\"\",\t//阀门类型代码+地址码\n" +
                    "\t\"arrFlag\":\"\",\t\t\t//欠费标志,0=不欠费，1=欠费，2=报停\n" +
                    "\t\"valveWorkMode\":\"\",\t//阀门工作模式\n" +
                    "\t\"openRate\":\"\",\t\t//阀门开度控制\n" +
                    "\t\"minOpenRate\":\"\",\t    //阀门最小开度限制\n" +
                    "\t\"maxOpenRate\":\"\",\t    //阀门最大开度限制\n" +
                    "\t\"antirustTmo\":\"\",\t\t//阀门防锈动作时间单位天\n" +
                    " \t\"testTempIntv\":\"\",\t//测温间隔，单位分钟\n" +
                    "\t\"tempAdjust\":\"\", \t\t\t//温度调节*100\n" +
                    "\t\"lowVar\":\"\",\t\t    //控温下限 int( temp * 100)\n" +
                    "\t\"highVar\":\"\",\t\t    //控温上限 int( temp * 100)\n" +
                    "\t\"setTemp\":\"\",\t\t    //设置温度int( temp * 100)\n" +
                    "\t\"setpower\":\"\",          //设置功率*1000\n" +
                    "\t\"setflux\":\"\",         \t//设置流速*1000\n" +
                    "\t\"CurveSapmple\": {\n" +
                    "\"temp\":[1,3,7,9],\n" +
                    "\"open\":[3,2,17,9]\n" +
                    "},\n" +
                    "\t\"shareHeat\":\"\",\t\t//分摊热量初始值int( heat * 10)\n" +
                    "   } }]");
            while (true) {
                String payLoad = message + i++;
                mqttMessage.setPayload(payLoad.getBytes());
                MqttDeliveryToken deliveryToken = mqttTopic.publish(mqttMessage);
                if (!deliveryToken.isComplete()) {
                    System.out.println("发布者发布消息： " + payLoad + " 失败");
                    deliveryToken.waitForCompletion();
                } else {
                    System.out.println("发布者发布消息： " + payLoad + " 成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author ZhangWenTao
     * @Description //TODO  消息订阅
     **/
    public static void subscribe() {
        try {
            MqttClient client = new MqttClient(serviceURI, clientID, persistence);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("订阅者连接丢失...");
                    System.out.println(cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("订阅者接收到消息： " + message.toString());
                    try{
                        JSONObject jsonObject = JSONObject.parseObject(message.toString());
                        String msg = jsonObject.getString("msg");
                        System.err.println(msg);
                        MySQLDemo mySQLDemo = new MySQLDemo();
//                        mySQLDemo.add(msg);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });
            MqttConnectOptions connectOptions = new MqttConnectOptions();
//            connectOptions.setUserName(username);
//            connectOptions.setPassword(password.toCharArray());
            connectOptions.setCleanSession(false);
            //订阅者连接订阅主题
            client.connect(connectOptions);
            client.subscribe(topic, qos);
            System.out.println("订阅者连接状态： " + client.isConnected());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
            /**
             ** t推送消息
            */
        public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException, MqttException {
            MqttDeliveryToken token = topic.publish(message);
            token.waitForCompletion();
            System.out.println("测试成功为true失败为false " + token.isComplete());
        }

}
