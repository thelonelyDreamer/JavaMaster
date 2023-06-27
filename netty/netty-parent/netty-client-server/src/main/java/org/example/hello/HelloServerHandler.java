package org.example.hello;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/17--@10:35
 */
@ChannelHandler.Sharable
public class HelloServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println(msg.toString(StandardCharsets.UTF_8));
        ctx.channel().writeAndFlush("server").addListener(ChannelFutureListener.CLOSE);
    }
}
