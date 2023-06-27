package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;

import java.util.List;

public class StarterApp {
    public static void main(String[] args) {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> allUser = mapper.getAllUser();
            SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
            UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
            System.out.println(mapper1==mapper);
    }
}