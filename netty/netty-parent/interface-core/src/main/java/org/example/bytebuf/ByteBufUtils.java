package org.example.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * in order to learn java!
 * created at 2022/10/16 20:39
 *
 * @author felixwc
 */
public class ByteBufUtils {
    public static ByteBuf directByteBuf(){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer(16, 1024);
        return byteBuf;
    }
}
