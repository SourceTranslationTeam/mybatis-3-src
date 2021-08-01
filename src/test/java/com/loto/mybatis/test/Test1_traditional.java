package com.loto.mybatis.test;

import com.loto.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test1_traditional {
    /**
     * 传统方式
     *
     * @throws IOException
     */
    @Test
    public void test1_traditional() throws IOException {
        // 1. 读取配置文件，读成字节输入流（现在还没解析）
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 2. 解析配置文件，封装Configuration对象（创建DefaultSqlSessionFactory对象）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 3. 生产了DefaultSqlsession实例对象（设置了事务不自动提交  完成了 executor 对象的创建）
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.(1)根据statementid来从Configuration中map集合中获取到了指定的MappedStatement对象
        //(2)将查询任务委派了executor执行器
        User user = sqlSession.selectOne("com.loto.mybatis.mapper.IUserMapper.findById", 1);
        System.out.println(user);

        User user2 = sqlSession.selectOne("com.loto.mybatis.mapper.IUserMapper.findById", 1);
        System.out.println(user2);

        // 5.释放资源
        sqlSession.close();
    }
}







