package org.example.demo;

public interface Demonstrable {

    void demo(String[] agrV);

    public static Demonstrable defaultDemo(){
        return (e)->{};
    }
}
