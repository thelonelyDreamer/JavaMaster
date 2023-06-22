package org.example.demo.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws  Exception{
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        map.put("one","1");
        new Thread(()->{
            try {
                while (true) {
                    countDownLatch.await();
                    System.out.println(1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Consumer<String> consumer = (s)-> System.out.println(s);
        consumer.andThen((e)-> System.out.println(1)).accept("1adfs");

    }
}