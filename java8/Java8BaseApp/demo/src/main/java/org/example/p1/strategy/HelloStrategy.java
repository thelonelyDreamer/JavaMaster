package org.example.p1.strategy;

import org.example.p1.DoSomething;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/5/27--@19:02
 */
public class HelloStrategy implements DoSomething {
    @Override
    public String doSomething(String str) {
        return str+"_hello";
    }
}
