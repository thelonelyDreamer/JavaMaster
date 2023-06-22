package org.example.demo;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        double asDouble = Stream.generate(Math::random).limit(10000).mapToDouble((e) -> e * 2).average().getAsDouble();
        System.out.println(asDouble);
    }
}