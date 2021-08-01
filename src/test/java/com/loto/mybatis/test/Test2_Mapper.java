package com.loto.mybatis.test;

import com.loto.mybatis.mapper.IUserMapper;
import com.loto.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2_Mapper {
    /**
     * mapper代理方式
     */
    @Test
    public void test2_Mapper() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用JDK动态代理对mapper接口产生代理对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

        // 代理对象调用接口中的任意方法，执行的都是动态代理中的invoke方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}







