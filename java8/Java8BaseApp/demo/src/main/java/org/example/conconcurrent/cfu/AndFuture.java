package org.example.conconcurrent.cfu;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/30--@13:41
 */
@Slf4j
public class AndFuture {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 1,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    public static void test() throws ExecutionException, InterruptedException {
        CompletableFuture<String>[] arr = new CompletableFuture[10];

        for (int i = 0; i < 10; i++) {
            arr[i]=CompletableFuture.supplyAsync(()->{
                log.info(Thread.currentThread().getName());
                if(Math.random()>0.6) throw new NullPointerException();
                return "hello";
            },executor);
        }
        CompletableFuture<Void> future = CompletableFuture.allOf(arr);
//        future.get();
        Thread.sleep(1000);
        System.out.println(future.isCompletedExceptionally());
        Arrays.stream(arr).forEach((e)-> System.out.println(e.isDone()+":"+e.isCompletedExceptionally()));

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();

        executor.shutdownNow();
    }
}
