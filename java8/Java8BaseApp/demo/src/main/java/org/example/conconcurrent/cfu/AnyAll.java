package org.example.conconcurrent.cfu;

import java.util.concurrent.*;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/30--@13:21
 */
public class AnyAll {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3,8,1,TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                 while (true){
                     TimeUnit.SECONDS.sleep(1);
                     System.out.println("hello");
                 }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executor);
        TimeUnit.SECONDS.sleep(3);
        future.cancel(true);
//        future.get();
        System.out.println(future.isCompletedExceptionally());
        System.out.println(future.isDone());
    }
    public static void any() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                throw new NullPointerException();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(2);
            return "world";
        });
        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2);
        System.out.println(future.get());
        System.out.println(3);

        System.out.println(future.isCompletedExceptionally());
    }

    public static void and() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(1);
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(2);
            return "world";
        });
        CompletableFuture<Void> future = CompletableFuture.allOf(future1, future2);
        System.out.println(future.isDone());
        System.out.println(future.get());
        System.out.println(3);
    }

    public static void test(){

    }
}
