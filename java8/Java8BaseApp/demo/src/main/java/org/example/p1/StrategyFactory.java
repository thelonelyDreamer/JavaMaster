package org.example.p1;

import org.example.p1.strategy.HelloStrategy;
import org.example.p1.strategy.HiStrategy;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/27--@19:00
 */
public class StrategyFactory {
    public static DoSomething getStrategy(int a){
        if(a==0) return new HelloStrategy();
        else if(a==1) return new HiStrategy();
        else return (str)->str;
    }

    public static void main(String[] args) {
        System.out.println(StrategyFactory.getStrategy(100).doSomething("hhe"));
    }
}
