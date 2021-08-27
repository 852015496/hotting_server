package com.hetting.hottable.mqttEMQ.callBack;

import com.hetting.hottable.utils.MySQLDemo;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
public class PitpatCallback implements MqttCallback {
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("订阅者连接丢失...");
        System.out.println(cause.getMessage());
    }


    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("发布消息成功---------" + token.isComplete());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //服务端不用关心，客户端的业务
        // subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + message.getQos());
        System.out.println("接收消息内容 : " + new String(message.getPayload()));
        System.out.println("订阅者接收到消息： " + message.toString());
        MySQLDemo concentPant = new MySQLDemo();
        concentPant.addPant(message);
    }
}
