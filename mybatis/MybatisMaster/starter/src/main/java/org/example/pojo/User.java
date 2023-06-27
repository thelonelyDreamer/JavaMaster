package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * in order to learn java!
 * created at 2022/4/18 14:58
 *
 * @author felixwc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private int id;
    private String userName;
    private String password;

    private Gender gender;
    public enum Gender{
        MALE,
        FEMALE,
        UNDEFINED,
        undefined,
        male,
        female
    }
}
