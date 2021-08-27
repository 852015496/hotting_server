package com.hetting.hottable.mqttEMQ.run;

import com.hetting.hottable.mqttEMQ.ConcentAutoSendClient;
import com.hetting.hottable.mqttEMQ.ConcentPitpatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Component
public class AutoStart implements CommandLineRunner {

    //项目启动时 开启订阅客户端
    @Override
    public void run(String... args) throws Exception {
        ConcentAutoSendClient.subscribe();
        ConcentPitpatClient.subscribe();
    }
}
