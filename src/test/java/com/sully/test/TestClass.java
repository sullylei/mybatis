package com.sully.test;

/**
 * Created by Administrator on 2016/4/10.
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
         * ӳ��sql�ı�ʶ�ַ�����
         * com.sully.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement, 1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }

    @Test
    public void testGetClass2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * com.sully.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass2��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass2";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement, 1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
    }
}