package com.hetting.hottable.connect;

import com.hetting.hottable.utils.Global;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Description TODO
 * @Date $
 * @Param $
 * @Author zhangwentao
 **/
@Controller
@RequestMapping("/nettyClient")
public class NettyClient {

    /**
     * @Author ZhangWenTao
     * @Description //TODO  建立 NettyServer 用于和集中器通信,建立握手协议
     * @Date 2020/9/9
     * @Param []
     * @return void
     **/
    @RequestMapping("/creatNettyServer")
    @ResponseBody
    public void createSocket() throws Exception {
        try {
            //获取到jeeplus.properites里面的属性
            //获取ip
            String ip= Global.getConfig("nettyServer");
            //获取端口
            int port = Integer.parseInt(Global.getConfig("nettyPort"));
            new NettyServerHandler(ip,port).run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }


}
