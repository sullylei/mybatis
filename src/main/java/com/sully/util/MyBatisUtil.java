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
     * ��ȡSqlSession
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
     * ��ȡSqlSession
     *
     * @param isAutoCommit true ��ʾ������SqlSession������ִ����SQL֮����Զ��ύ����
     *                     false ��ʾ������SqlSession������ִ����SQL֮�󲻻��Զ��ύ������ʱ����Ҫ�����ֶ�����sqlSession.commit()�ύ����
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
     * �ر�SqlSession
     *
     * �м���Ҫ��ThreadLocal��remove��SqlSession
     */
    public static void closeSqlSession(){
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if(sqlSession != null){
            sqlSession.close();
            sqlSessionThreadLocal.remove();
        }
    }
}