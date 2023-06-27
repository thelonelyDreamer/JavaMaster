package org.example.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.BlockingDeque;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/17--@10:58
 */
public class SimpleClient {
    private String hostname;
    private Integer port;
    private BlockingDeque<Object> message;

    public SimpleClient(String hostname, Integer port, BlockingDeque<Object> message) {
        this.hostname = hostname;
        this.port = port;
        this.message = message;
    }

    public void start(){
        ChannelFuture channelFuture = null;
        try {
            channelFuture = new Bootstrap()
                    .group(new NioEventLoopGroup())
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringEncoder());
                        }
                    })
                    .connect(new InetSocketAddress(hostname, port))
                    .sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Channel channel = channelFuture.channel();
        while (true) {
            try {
                channel.writeAndFlush(message.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(){

    }
}
