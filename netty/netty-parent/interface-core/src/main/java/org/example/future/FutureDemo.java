package org.example.future;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * in order to learn java!
 * created at 2022/10/16 18:40
 *
 * @author felixwc
 */
@Slf4j
public class FutureDemo {

    public static void main(String[] args) {
        quickstart();
    }


    public static void detail(){

    }

    public static void quickstart(){
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        EventLoop eventLoop = group.next();
        Future<String> future = eventLoop.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("开始计算");
                TimeUnit.SECONDS.sleep(1);
                log.info("计算结束");
                return "成功";
            }
        });
        log.info("等待结果");
        future.addListeners((f)->{
            log.debug("接收结果是1：{}",f.getNow());
        },(f)->{
            log.debug("接收结果是2：{}",f.getNow());
        });
        try {
            log.info("结束是:{}",future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
