package com.hetting.hottable.connect;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;


import com.hetting.hottable.connect.SpringContextHolder;
import com.hetting.hottable.connect.TcpPackage;
import com.hetting.hottable.connect.TcpService;
import com.hetting.hottable.utils.MessageUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * netty消息接收器
 *
 * @author Mr.J
 * @Date 2019/11/30 - 15:10
 */
public class NettyServer extends ChannelHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    /**
     * 用于存放集中器链接
     * 集中器发送消息时，根据集中器地址保存
     * 集中器断开连接时删除
     */
    public static final Map<String, ChannelHandlerContext> SERVER_MAP = new HashMap<>();

    private final TcpService agreementService = SpringContextHolder.getBean(TcpService.class);

    private String address;
    private byte[] receiveBuffer;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("收到链接:" + ctx.channel().remoteAddress() + ctx);
        super.channelRegistered(ctx);
    }
    /**
     * @Author ZhangWenTao
     * @Description //TODO  channelRead的方法作用
     * @Date 2020/9/17
     * @Param [ctx, msg]
     * @return void
     **/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /**
         *获取msg中的数据,向Channel 写入一个 ByteBuf ；每一次读取，就是从 Channel 读到一个 ByteBuf 。
         * ByteBuf中的概念:粘包和半包，指的都不是一次是正常的 ByteBuf 缓存区接收。
         * 粘包，就是接收端读取的时候，多个发送过来的 ByteBuf “粘”在了一起。
         * 换句话说，接收端读取一次的 ByteBuf ，读到了多个发送端的 ByteBuf ，是为粘包。
         * 半包，就是接收端将一个发送端的ByteBuf “拆”开了，形成一个破碎的包，我们定义这种 ByteBuf 为半包。
         * 换句话说，接收端读取一次的 ByteBuf ，读到了发送端的一个 ByteBuf的一部分，是为半包。
         *
         * 同时还有一个拆包的含义:
         * 1.接收端应用层不断从底层的TCP 缓冲区中读取数据。
         * 2.每次读取完，判断一下是否为一个完整的应用层数据包。如果是，上层应用层数据包读取完成。
         * 3.如果不是，那就保留该数据在应用层缓冲区，然后继续从 TCP 缓冲区中读取，直到得到一个完整的应用层数据包为止。
         **/
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        receiveBuffer = ArrayUtils.addAll(receiveBuffer, bytes);
        //得到bytes的长度
        logger.debug("channelRead:" + bytes.length);
    }

    /**
     * channelReadComplete方法根据上下文的消息
     * ChannelHandlerContext下的ChannelHandlerContext read();方法读取完以后才会进入Complete方法
     * Complete会根据LineBasedFrameDecoder和LengthFieldBasedFrameDecoder进行编解码
     * LineBasedFrameDecoder:按照每一行进行分割,也就是特殊的分割符解码器,他的分隔符为\n或者\r\n
     *LengthFieldBasedFrameDecoder:通过消息中设置的长度字段来进行粘包处理.该解码器总共有5个参数
     **/
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //当一个连接断开时会执行此回调，这种情况下不做解析，直接退出
        if (receiveBuffer == null) {
            return;
        }

        //数据不为null时,通过byteFormat方法,将字节数组格式化，将字节数组转为字符串
        logger.info("收到数据：" + MessageUtil.byteFormat(receiveBuffer));
        //校验并拆分数据包
        TcpPackage basePackage = MessageUtil.verifyPackage(receiveBuffer);
        if (basePackage == null) {
            /*
              有线网卡上网的方式下，模块会自动分包，一包最大800字节
              这种情况下要进行拼包
             */
            if (receiveBuffer.length <= 800) {
                return;
            }
            logger.error("数据校验失败" + MessageUtil.byteFormat(receiveBuffer));
            receiveBuffer = null;
            return;
        }
        receiveBuffer = null;
		/*if (basePackage.getCmd() == Agreement.REC_LOGIN) {
			//登陆标志检验
			address = basePackage.getJzq();
			SERVER_MAP.put(address, ctx);
		}*/
        address = basePackage.getJzq();
        SERVER_MAP.put(address, ctx);
		agreementService.handleMessage(basePackage);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        logger.info("链接： " + ctx + " 超时");
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("链接： " + ctx + " 发生异常，" + cause.getMessage(), cause);
        if (cause instanceof IOException) {
            ctx.close();
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        SERVER_MAP.entrySet().removeIf(entry -> entry.getValue() == ctx);
        logger.info("链接： " + ctx + " 与主机断开，集中器号： " + address);
    }

    /**
     * 向集中器发送数据
     *
     * @param addr 集中器地址
     * @param msg  要发送的数据
     */
    public static void sendMessage(String addr, byte[] msg) {
        ChannelHandlerContext ctx = SERVER_MAP.get(addr);
        if (ctx != null) {
            ChannelFuture future = ctx.writeAndFlush(Unpooled.wrappedBuffer(msg));
            logger.debug("发送数据 " + future.isSuccess() + " ：" + ctx + " " + MessageUtil.byteFormat(msg));
            System.err.println("发送数据 " + future.isSuccess() + " ：" + ctx + " " + MessageUtil.byteFormat(msg));
        } else {
            logger.error("集中器 " + addr + " 的链接丢失，发送失败！！！");
        }
    }
}
