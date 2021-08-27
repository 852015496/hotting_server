package com.hetting.hottable.mqttEMQ;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/

import com.hetting.hottable.mqttEMQ.Util.PropertiesUtil;
import com.hetting.hottable.mqttEMQ.callBack.AutoSendCallback;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;

@Component
public class ConcentAutoSendClient {

    private Logger log = Logger.getLogger(ConcentAutoSendClient.class);

    private static final  Logger logger = Logger.getLogger(ConcentAutoSendClient.class);

//    public static final String HOST = "tcp://192.168.18.120:61613";
//    public static final String TOPIC = "/edge/autoreport/QDEdge_121E9607CAAE";
    public static final String TOPIC = "/edge/autoreport/#";
//    public static final String TOPIC = "demo/topics";
//    private static final String clientid = "client124";
    private MqttClient client;
//    private String userName = "admin";
//    private String passWord = "password";

    private ScheduledExecutorService scheduler;

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(PropertiesUtil.MQTT_HOST, PropertiesUtil.MQTT_CLIENTID, new MemoryPersistence());
            // MQTT的连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            // 设置连接的用户名
//            options.setUserName(userName);
            // 设置连接的密码
//            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(PropertiesUtil.MQTT_TIMEOUT);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(PropertiesUtil.MQTT_KEEP_ALIVE);
            // 设置回调
            try{
                client.setCallback(new AutoSendCallback());
//                MqttTopic topic = client.getTopic(TOPIC);
                //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
//                options.setWill(topic, "close".getBytes(), 0, true);
                options.setCleanSession(false);
                options.setConnectionTimeout(PropertiesUtil.MQTT_TIMEOUT);
                options.setKeepAliveInterval(PropertiesUtil.MQTT_KEEP_ALIVE);
                client.connect(options);
                //订阅消息
                int[] Qos  = {1};
                String[] topic1 = {TOPIC};
                client.subscribe(topic1, Qos);
                log.info("订阅成功");
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void subscribe(){
        ConcentAutoSendClient client = new ConcentAutoSendClient();
        client.start();
        logger.info("开始订阅topic");
    }


    public static void main(String[] args) throws MqttException {
        ConcentAutoSendClient client = new ConcentAutoSendClient();
        client.start();
    }
}
