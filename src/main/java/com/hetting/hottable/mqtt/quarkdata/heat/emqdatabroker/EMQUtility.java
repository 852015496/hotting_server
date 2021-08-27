package com.hetting.hottable.mqtt.quarkdata.heat.emqdatabroker;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import java.sql.Timestamp;
import java.util.Arrays;

public class EMQUtility implements MqttCallback {
    private String heartbeatTopic = "/edge/online";
    private String settingsEdgeTopic = "/edge/settings/";
    private String settingsValveTopic ;
    private String readMeterTopic;
    private String edgeAutoReportTopic = "/edge/autoreport/#";

    private String broker;
    private String clientId;;
    private String username;
    private String password;
    private int innerTopic;


    MemoryPersistence persistence = new MemoryPersistence();

    int state = BEGIN;

    static final int BEGIN = 0;
    static final int CONNECTED = 1;
    static final int PUBLISHED = 2;
    static final int SUBSCRIBED = 3;
    static final int DISCONNECTED = 4;
    static final int FINISH = 5;
    static final int ERROR = 6;
    static final int DISCONNECT = 7;

    //for subscribe msg
    static final int AUTOREPORT = 0;
    static final int ONLINE = 1;
    static final int CTRLGATE = 2;

    //for publish msg
    //static final int

    private MqttConnectOptions 	conOpt;
    private boolean 			clean;
    private MqttAsyncClient 	client;
    private boolean 			quietMode;
    private Throwable 			ex = null;
    private Object 				waiter = new Object();
    private boolean 			donext = false;


    public EMQUtility()
    {

    }

    public void initandStart(String accessPoint, String userName, String passWord, int topic)
    {
        broker = accessPoint;
        username = userName;
        password = passWord;
        innerTopic =topic;
        clientId = "Client for " + String.valueOf(topic);

        String tmpDir = System.getProperty("java.io.tmpdir");
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(tmpDir);

        try {
            // Construct the object that contains connection parameters
            // such as cleanSession and LWT
            conOpt = new MqttConnectOptions();
            conOpt.setCleanSession(clean);
            if(password != null ) {
                conOpt.setPassword(this.password.toCharArray());
            }
            if(userName != null) {
                conOpt.setUserName(username);
            }

            // Construct the MqttClient instance
            client = new MqttAsyncClient(accessPoint,clientId, dataStore);

            // Set this wrapper as the callback handler
            client.setCallback(this);

        } catch (MqttException e) {
            e.printStackTrace();
            //log("Unable to set up client: "+e.toString());
            System.exit(1);
        }

        try
        {
            cleanConnect();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            System.out.println(ex.getStackTrace().toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(throwable.toString());
        }
    }

    public void StarttoPublic()
    {
        //TODO: handle publish msg
    }

    public void StarttoSubscribe()
    {
        String topic = "";
        if (innerTopic == AUTOREPORT)
        {
            topic = "edge/autoreport/#";
        }

        if (innerTopic == ONLINE)
        {
            topic = "edge/online";
        }

        if (innerTopic == CTRLGATE)
        {
            topic = " edge/rpc/ctrlGate/#";
        }
        try {
            subscribe(topic, 0);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public void cleanDisconnect()
    {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void cleanConnect()
    {
        int num = 0;//retry 5 times
        while(!client.isConnected() && num <= 5) {
            try {
                client.connect(conOpt);
                Thread.sleep(1000);
                System.out.println("Connection status: " + String.valueOf(client.isConnected()));
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            num ++;
        }
    }

    public void publish(String topicName, int qos, byte[] payload) throws MqttException {

        // Connect to the MQTT server
        log("Connecting to "+ broker + " with client ID "+client.getClientId());

        log(String.valueOf(client.isConnected()));
        String time = new Timestamp(System.currentTimeMillis()).toString();
        log("Publishing at: "+time+ " to topic \""+topicName+"\" qos "+qos);

        // Create and configure a message
        MqttMessage message = new MqttMessage(payload);
        message.setQos(qos);

        // Send the message to the server, control is not returned until
        // it has been delivered to the server meeting the specified
        // quality of service.
        client.publish(topicName, message);

        // Disconnect the client
    }

    public void subscribe(String topicName, int qos) throws Throwable {
        // Use a state machine to decide which step to do next. State change occurs
        // when a notification is received that an MQTT action has completed

        log("Connected to "+ broker +" with client ID "+client.getClientId());

        // Subscribe to the requested topic
        // The QoS specified is the maximum level that messages will be sent to the client at.
        // For instance if QoS 1 is specified, any messages originally published at QoS 2 will
        // be downgraded to 1 when delivering to the client but messages published at 1 and 0
        // will be received at the same level they were published at.
        log("Subscribing to topic \""+topicName+"\" qos "+qos);
        client.subscribe(topicName, qos);
    }

    //the below are utility funcs.

    private void log(String message) {
        if (!quietMode) {
            System.out.println(message);
        }
    }


    //The below are override funcs

    public void connectionLost(Throwable cause) {
        // Called when the connection to the server has been lost.
        // An application may choose to implement reconnection
        // logic at this point. This sample simply exits.
        log("Connection to " + broker + " lost!" + cause);

        //TODO: change to retry
        System.exit(1);
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        // Called when a message has been delivered to the
        // server. The token passed in here is the same one
        // that was returned from the original call to publish.
        // This allows applications to perform asynchronous
        // delivery without blocking until delivery completes.
        //
        // This sample demonstrates asynchronous deliver, registering
        // a callback to be notified on each call to publish.
        //
        // The deliveryComplete method will also be called if
        // the callback is set on the client
        //
        // note that token.getTopics() returns an array so we convert to a string
        // before printing it on the console
        log("Delivery complete callback: Publish Completed "+ Arrays.toString(token.getTopics()));
    }

    public void messageArrived(String topic, MqttMessage message) throws MqttException {
        // Called when a message arrives from the server that matches any
        // subscription made by the client
        String time = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println("Time:\t" +time +
                "  Topic:\t" + topic +
                "  Message:\t" + new String(message.getPayload()) +
                "  QoS:\t" + message.getQos());

        if (innerTopic == ONLINE)
        {
          handleONLINEMSG(message);
        }

        if (innerTopic == AUTOREPORT)
        {
            handleAUTOREPORTMSG(message);
        }

        if (innerTopic == CTRLGATE)
        {
            handleCTRLGATEMSG(message);
        }

    }

    void handleONLINEMSG(MqttMessage msg)
    {

    }


    void handleAUTOREPORTMSG(MqttMessage msg)
    {

    }


    void handleCTRLGATEMSG(MqttMessage msg)
    {

    }



}
