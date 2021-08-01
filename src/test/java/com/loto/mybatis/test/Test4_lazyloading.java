package com.loto.mybatis.test;

import com.loto.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test4_lazyloading {
    /**
     * mybatis嵌套效果测试
     */
    @Test
    public void test4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = factory.openSession();

        User user = sqlSession.selectOne("com.loto.mybatis.mapper.IUserMapper.findById", 1);

        System.out.println(user.getUsername());
        System.out.println(user.getOrderList());

    }
}







