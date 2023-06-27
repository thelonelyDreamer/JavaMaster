package org.example.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/6/24--@12:05
 */
public class FileDemo {
    private static Logger log = Logger.getGlobal();
    public static void doExperiment1() throws IOException {
        try(FileChannel channel=new FileInputStream("a.txt").getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            int length =0;
            while (true){
                length= channel.read(byteBuffer);
                if(-1==length) break;
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    byte b = byteBuffer.get();
                    log.info(String.valueOf((char)b));
                }
                byteBuffer.clear();
            }
        }
    }


    public static void doExperiment() {
        log.info("hello fileBufferExperiment");
    }

    public static void main(String[] args) throws IOException {
        doExperiment1();
    }
}
