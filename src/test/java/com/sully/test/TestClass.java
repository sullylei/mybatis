package com.sully.test;

/**
 * Created by Administrator on 2016/4/10.
 * http://www.cnblogs.com/xdp-gacl/p/4264440.html
 */

import com.sully.domain.Classes;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestClass {

    @Test
    public void testGetClass() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.sully.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement, 1);//查询class表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        MyBatisUtil.closeSqlSession();
        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }

    @Test
    public void testGetClass2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.sully.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass2";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement, 1);//查询class表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }
}