package org.example.conconcurrent.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/30--@14:46
 */
public class SemaphoreDemo {
    private static final int THREAD_COUNT=30;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int temp = i;
            EXECUTOR_SERVICE.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println("save data"+ temp);
                    Thread.sleep(1000);
                    System.out.println(semaphore.getQueueLength());
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        EXECUTOR_SERVICE.shutdown();
    }

}
