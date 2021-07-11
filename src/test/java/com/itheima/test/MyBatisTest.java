package com.itheima.test;

import com.gdx.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //参数是那个namespace
        List<User> userList = sqlSession.selectList("com/itheima/mapper/UserMapper.findAll");

        System.out.println(userList);
        sqlSession.close();
    }
    @Test
    public void test_insert() throws IOException {

        User user = new User();

        user.setUsername("Towwm");
        user.setPassword("ssppwe");
        user.setEmail("11@qq.com");
        //获得核心配置文件


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //参数是那个namespace
        sqlSession.insert("com/itheima/mapper/UserMapper.save", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_update() throws IOException {

        User user = new User();
        user.setId(11);
        user.setUsername("Towwmnnnn");
        user.setPassword("ssppwe23");
        user.setEmail("1111@qq.com");
        //获得核心配置文件


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //参数是那个namespace
        sqlSession.update("com/itheima/mapper/UserMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test_delete() throws IOException {

        User user = new User();
        user.setId(11);
        user.setUsername("Towwmnnnn");
        user.setPassword("ssppwe23");
        user.setEmail("1111@qq.com");
        //获得核心配置文件


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //参数是那个namespace
        sqlSession.delete("com/itheima/mapper/UserMapper.delete", user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_selectById() throws IOException {


        //获得核心配置文件


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得sql session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //参数是那个namespace
        User user = sqlSession.selectOne("com/itheima/mapper/UserMapper.findById", 5);
        System.out.println(user);

        sqlSession.close();
    }
}
