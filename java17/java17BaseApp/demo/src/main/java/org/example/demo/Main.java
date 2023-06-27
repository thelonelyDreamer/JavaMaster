package org.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Demonstrable demo = Demonstrable.defaultDemo();
        demo.demo(args);
    }
}