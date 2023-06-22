package org.example.conconcurrent.clz;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/30--@13:04
 */
public class MagicLongAdder {

    public static long test(){
        CountDownLatch downLatch = new CountDownLatch(1000);
        LongAdder adder = new LongAdder();
        for (int i = 0; i <1000; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    adder.add(1L);
                }
                downLatch.countDown();
            }).start();
        }
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return adder.longValue();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(test());
        }
    }
}
