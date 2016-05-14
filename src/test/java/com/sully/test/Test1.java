package com.sully.test;

/**
 * Created by Administrator on 2016/4/9.
 */

import com.sully.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //mybatis�������ļ�
        String resource = "config.xml";
        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        InputStream is = Resources.getResourceAsStream(resource);;
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        //Reader reader = Resources.getResourceAsReader(resource);
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�sql
         */
        SqlSession session = sessionFactory.openSession();
        String statement = "com.sully.mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����һ��Ψһuser�����sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}