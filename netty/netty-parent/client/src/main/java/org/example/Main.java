package org.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.example.client.SimpleClient;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    private static final BlockingDeque<Object> MESSAGE_QUEUE
            =new LinkedBlockingDeque<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = startSimpleClient();
        Scanner scanner = new Scanner(System.in);
        boolean flag =true;
        while (flag){
            String message = scanner.next();
            if(Objects.isNull(message)|| (0==message.length())) continue;
            if("quit".equalsIgnoreCase(message)){
                thread.interrupt();
                flag=true;
            }else{
                MESSAGE_QUEUE.put(message);
            }
        }
    }


    public static Thread startSimpleClient(){
        Thread clientThead = new Thread(() -> {
            new SimpleClient("localhost",10000,MESSAGE_QUEUE).start();
        });
        return clientThead;
    }
}