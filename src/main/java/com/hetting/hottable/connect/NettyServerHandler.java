package com.hetting.hottable.connect;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.log4j.Logger;
import sun.security.krb5.Config;

public class NettyServerHandler {

    public static Logger log = Logger.getLogger(NettyServerHandler.class);

    private int port;
    private String ip;

    public String getIp() {
       return ip;
   }

   public void setIp(String ip) {
       this.ip = ip;
   }


   public int getPort() {
       return port;
   }

   public void setPort(int port) {
       this.port = port;
   }

   public NettyServerHandler(String ip,int port) {
       this.ip = ip;

        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();        // 用来接收进来的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();      // 用来处理已经被接收的连接
        System.out.println("准备运行端口：" + port);

        try {
            ServerBootstrap b = new ServerBootstrap();   //建立连接
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)            // 这里告诉Channel如何接收新的连接
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 以下两行代码为了解决半包读问题
//                	 ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                	 ch.pipeline().addLast(new StringDecoder());
                            //当客户端创建成功时,获取ip和端口建立服务端连接
                            ch.pipeline().addLast(new NettyServer());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接  监听 绑定ip 和端口
            // 绑定ip地址与端口号   b.bind("192.168.0.25", 8092);
            ChannelFuture f = b.bind(ip,port).sync();
            if(f.isSuccess()){
                System.err.println("Server,启动Netty服务端成功,端口号:"+port+"------>"+"ip:"+ip);
                log.info("Server,启动Netty服务端成功,端口号:"+port+"ip:"+ip);
            }
            // 等待服务器socket关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        try {
            String ip="127.0.0.1";
            int port = 8092;
            new NettyServerHandler(ip,port).run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 测温插座
     * @throws Exception
     */
    /*public void run1() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();        // 用来接收进来的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();    // 用来处理已经被接收的连接
        System.out.println("准备运行端口：" + port);

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel.class)            // 这里告诉Channel如何接收新的连接
            .childHandler( new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {

                       // 以下两行代码为了解决半包读问题
//                	 ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                	 ch.pipeline().addLast(new StringDecoder());

                    ch.pipeline().addLast(new NettyServer1());
                }
            })
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口，开始接收进来的连接
            // 绑定ip地址与端口号   b.bind("192.168.0.25", 8092);
            ChannelFuture f = b.bind(ip,port).sync();

            // 等待服务器socket关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }*/


}