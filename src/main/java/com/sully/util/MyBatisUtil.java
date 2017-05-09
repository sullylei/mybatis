package com.sully.util;

/**
 * Created by Administrator on 2016/4/9.
 */

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<SqlSession>();

    static{
        String resource = "config.xml";
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        MyBatisUtil.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     *
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            sqlSessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 获取SqlSession
     *
     * @param isAutoCommit true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *                     false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession(isAutoCommit);
            sqlSessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession
     *
     * 切记需要从ThreadLocal中remove掉SqlSession
     */
    public static void closeSqlSession(){
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if(sqlSession != null){
            sqlSession.close();
            sqlSessionThreadLocal.remove();
        }
    }
}