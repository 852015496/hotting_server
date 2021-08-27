package com.hetting.hottable.mqttEMQ.Util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author
 * @date 2
 */


@Component
public class PropertiesUtil {

    public static String MQTT_HOST;
    public static String MQTT_CLIENTID;
    public static String MQTT_USER_NAME;
    public static String MQTT_PASSWORD;
    public static int MQTT_TIMEOUT;
    public static int MQTT_KEEP_ALIVE;
    public  static String prefixUrl;
    /**
     * 最大重连次数
     */
    public  static int MQTT_MAXRECONNECTTIMES;
    public static  int MQTT_RECONNINTERVAL;



    static {
       /* MQTT_HOST = loadMqttProperties().getProperty("host");
        MQTT_CLIENTID = loadMqttProperties().getProperty("clientid");
      *//*  MQTT_USER_NAME = loadMqttProperties().getProperty("username");
        MQTT_PASSWORD = loadMqttProperties().getProperty("password");*//*
        MQTT_TIMEOUT = Integer.valueOf(loadMqttProperties().getProperty("timeout"));
        MQTT_KEEP_ALIVE = Integer.valueOf(loadMqttProperties().getProperty("keepalive"));
        MQTT_MAXRECONNECTTIMES=Integer.valueOf(loadMqttProperties().getProperty("maxReconnectTimes"));
        MQTT_RECONNINTERVAL=Integer.valueOf(loadMqttProperties().getProperty("reconnInterval"));
        prefixUrl = String.valueOf(loadMqttProperties().getProperty("prefixUrl"));*/

        MQTT_HOST = "tcp://42.159.87.162:1883";
        MQTT_CLIENTID =  UUID.randomUUID().toString();
//        MQTT_CLIENTID = "JavaSample";
      /*  MQTT_USER_NAME = loadMqttProperties().getProperty("username");
        MQTT_PASSWORD = loadMqttProperties().getProperty("password");*/
        MQTT_TIMEOUT = 10;
        MQTT_KEEP_ALIVE = 20;
        MQTT_MAXRECONNECTTIMES= 5;
        MQTT_RECONNINTERVAL= 1;
        prefixUrl = "http://42.159.87.162:18083";
    }


      /* private static Properties loadMqttProperties() {
        InputStream inputstream = PropertiesUtil.class.getResourceAsStream("application.yml");
        Properties properties = new Properties();
        try {
            properties.load(inputstream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputstream != null) {
                    inputstream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/


}
