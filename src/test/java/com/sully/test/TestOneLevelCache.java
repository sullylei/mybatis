package com.sully.test;

/**
 * Created by Administrator on 2016/4/10.
 */

import com.sully.domain.User;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author gacl
 *         ����һ������
 */
public class TestOneLevelCache {

    /*
     * һ������: Ҳ��Session���Ļ���(Ĭ�Ͽ���)
     */
    @Test
    public void testCache1() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "com.sully.mapping.userMapper.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        
        /*
         * һ������Ĭ�Ͼͻᱻʹ��
         */
        user = session.selectOne(statement, 1);
        System.out.println(user);
        MyBatisUtil.closeSqlSession();
        /*
         1. ������ͬһ��Session,���session�����Ѿ�close()���˾Ͳ��������� 
         */
        session = MyBatisUtil.getSqlSession();
        user = session.selectOne(statement, 1);
        System.out.println(user);
        
        /*
         2. ��ѯ������һ����
         */
        user = session.selectOne(statement, 2);
        System.out.println(user);
        
        /*
         3. û��ִ�й�session.clearCache()������
         */
        //session.clearCache(); 
        user = session.selectOne(statement, 2);
        System.out.println(user);
        
        /*
         4. û��ִ�й���ɾ�ĵĲ���(��Щ��������������)
         */
        session.update("com.sully.mapping.userMapper.updateUser",
                new User(2, "user", 23));
        user = session.selectOne(statement, 2);
        System.out.println(user);

    }
}
