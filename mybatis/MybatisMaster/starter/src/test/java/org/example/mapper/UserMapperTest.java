package org.example.mapper;


import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

public class UserMapperTest {

      @Test
      public void test(){
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User byUser = mapper.findByUser(new User().setUserName("a"));
      }

}