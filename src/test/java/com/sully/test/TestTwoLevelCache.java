package com.sully.test;

/**
 * Creator: lei.s
 * Create Date: 2017��05��09��
 * �๦��������
 */

import com.sully.domain.User;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author gacl
 * ���Զ�������
 */
public class TestTwoLevelCache {

    /*
     * ���Զ�������
     * ʹ��������ͬ��SqlSession����ȥִ����ͬ��ѯ�����Ĳ�ѯ���ڶ��β�ѯʱ�����ٷ���SQL��䣬����ֱ�Ӵӻ�����ȡ������
     */
    @Test
    public void testCache2() {
        String statement = "com.sully.mapping.userMapper.getUser";
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
        //����������ͬ��SqlSession
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        //ʹ�ö�������ʱ��User�����ʵ��һ��Serializable�ӿ�===> User implements Serializable
        User user = session1.selectOne(statement, 1);
        session1.commit();//����Ϊɶ������ط�һ��Ҫ�ύ����֮���������Ż�������
        System.out.println("user="+user);

        //����ʹ�õ���������ͬ��SqlSession�������Լ�ʹ��ѯ������ͬ��һ������Ҳ���Ὺ��ʹ��
        System.out.println("�鿴���������Ƿ���Ч");
        user = session2.selectOne(statement, 1);
        //session2.commit();
        System.out.println("user2="+user);
    }
}