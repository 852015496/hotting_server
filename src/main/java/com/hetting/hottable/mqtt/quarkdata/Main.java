package com.hetting.hottable.mqtt.quarkdata;

import com.hetting.hottable.mqtt.quarkdata.heat.emqdatabroker.EMQUtility;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello world");
        EMQUtility utility = new EMQUtility();

        utility.initandStart("ws://42.159.87.162:8083/mqtt", "", "", 1);

    }
}
