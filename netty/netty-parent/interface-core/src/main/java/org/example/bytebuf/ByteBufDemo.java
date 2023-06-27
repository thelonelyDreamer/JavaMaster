package org.example.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * in order to learn java!
 * created at 2022/10/16 20:28
 *
 * @author felixwc
 */
public class ByteBufDemo {
    public static void quickStart(){
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        System.out.println(buffer);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            builder.append("a");
        }
        buffer.writeBytes(builder.toString().getBytes());
        System.out.println(buffer);
    }
    public static void main(String[] args) {
        quickStart();
    }
}
