package org.example.hello;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/16--@21:58
 */
public class HelloClientApp {
    private final String host;
    private final int port;

    private NioEventLoopGroup loopGroup;

    public HelloClientApp(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public  void start() throws InterruptedException {
       loopGroup = new NioEventLoopGroup();
        Bootstrap bs = new Bootstrap();
        bs.group(loopGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host,port))
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new HelloClientHandler());
                    }
                });
        ChannelFuture channelFuture = bs.connect().sync();
        Channel channel = channelFuture.channel();
        channel.writeAndFlush("Hello".getBytes(StandardCharsets.UTF_8));
//        channel.close().sync();
    }

    public void shutdown(){
        if(Objects.nonNull(loopGroup)){
            loopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HelloClientApp clientApp = new HelloClientApp("localhost", 20110);
        try {
            clientApp.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            clientApp.shutdown();
        }
    }
}
