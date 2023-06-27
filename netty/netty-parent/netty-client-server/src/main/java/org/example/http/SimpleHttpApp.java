package org.example.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.nio.charset.StandardCharsets;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/17--@11:28
 */
public class SimpleHttpApp {
    private int port;
    private NioEventLoopGroup work;
    private NioEventLoopGroup boss;

    public SimpleHttpApp(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        work = new NioEventLoopGroup(8);
        boss = new NioEventLoopGroup(1);
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,work)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new HttpRequestDecoder())
                                .addLast(new HttpResponseEncoder())
                                .addLast(new HttpObjectAggregator(104896))
                                .addLast(new HttpHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.bind().sync();
        channelFuture.channel().closeFuture().sync();
    }


    private static class HttpHandler extends SimpleChannelInboundHandler<Object> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            if(msg instanceof FullHttpRequest){
                System.out.println(((FullHttpRequest) msg).uri());
            }else {
                System.out.println("非http请求");
            }
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/json;charset=UTF-8");
            response.content().writeBytes("{\"name\":\"zhangsan\"}".getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new SimpleHttpApp(20000).start();
    }
}
