package org.example.pojo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/6/23--@14:37
 */
public class MyObject {
    private static AtomicInteger a = new AtomicInteger(0);
    static {
        System.out.println(a.incrementAndGet());
    }

    public MyObject() {
        System.out.println("MyObject constructor");
    }

    {
        System.out.println("匿名代码块");
    }
    public static void get(){
        System.out.println(a.get());
    }

    public static class MyO1 extends MyObject{
        public MyO1() {
            System.out.println("myo1 constructor");
        }
        {
            System.out.println("MYsqwe");
        }
        static {
            System.out.println("MyO1 static");
        }
    }
}
