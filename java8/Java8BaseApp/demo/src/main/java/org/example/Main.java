package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DoubleAdder doubleAdder = new DoubleAdder();
        doubleAdder.add(1);
        double v = doubleAdder.sum();
        new DoubleAccumulator((r,t)->r+t,0);
        System.out.println(v);
    }

}