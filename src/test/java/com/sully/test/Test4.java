package com.sully.test;

/**
 * Created by Administrator on 2016/4/10.
 */

import com.sully.domain.Classes;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test4 {

    @Test
    public void testGetClass3() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * com.sully.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass3��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass3";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement, 1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        //��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
        System.out.println(clazz);
    }

    @Test
    public void testGetClass4() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * com.sully.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass4��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.classMapper.getClass4";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement, 1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        //��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
        System.out.println(clazz);
    }
}