package com.sully.test;

/**
 * Created by Administrator on 2016/4/9.
 */

import com.sully.domain.User;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws IOException {

        //创建能执行映射文件中sql的sqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.sully.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.sully.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user.getName());
        String statementList = "com.sully.mapping.userMapper.getList";//映射sql的标识字符串
        List<User> list = session.selectList(statementList);
        for(User tempUser:list){
            System.out.println(tempUser.getName());
        }
        MyBatisUtil.closeSqlSession();
    }
}