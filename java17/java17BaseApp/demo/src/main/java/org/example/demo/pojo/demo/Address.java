package org.example.demo.pojo.demo;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/6/24--@14:30
 */
public class Address {
    private String province;
    private String city;
    private String distinct;
    private DistinctType distinctType;


    public enum DistinctType{
        COUNTY,
    }
}
