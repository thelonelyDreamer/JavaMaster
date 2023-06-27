package org.example.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/6/24--@13:32
 */
@Data
@Accessors(chain = true)
public class Person {
    private String username;
    private String password;

    private List<String> hobbies;
    private Set<String> address;
    private Map<String,String> stringMap;
    private Date birthday;
}
