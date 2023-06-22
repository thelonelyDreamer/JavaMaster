package org.example;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put("12345678".getBytes());
        buffer.flip();
        System.out.println(new String(buffer.array()));
    }
}