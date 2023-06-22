package org.example.demo.test;

/**
 * in order to learn java!
 * created at 2022/12/30 15:16
 *
 * @author felixwc
 */
public sealed class A extends Object implements Runnable permits B, C {
    @Override
    public void run() {

    }
}
