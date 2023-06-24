package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;

/**
 * in order to learn java!
 * created at 2022/4/18 14:57
 *
 * @author felixwc
 */
public interface UserMapper {
    List<User> getAllUser();
    int insertUser(User user);

    User getUserById(@Param("id") int id);

    int deleteById(@Param("id")int id);

    int updateUser(User user);

    User findByUser(@Param("user") User user);
}
