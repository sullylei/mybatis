package com.sully.test;

import com.sully.domain.Order;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Administrator on 2016/4/9.
 */
public class TestCRUDOrderByXmlMapper {
    @Test
    public void getOrderById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.orderMapper��orderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getOrderById��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.orderMapper.getOrderById";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
        Order order = sqlSession.selectOne(statement,2);//��ѯorders����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(order);//��ӡ�����null��Ҳ����û�в�ѯ����Ӧ�ļ�¼
    }

    @Test
    public void selectOrder() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.orderMapper��orderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getOrderById��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.orderMapper.selectOrder";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
        Order order = sqlSession.selectOne(statement,2);//��ѯorders����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(order);//��ӡ�����null��Ҳ����û�в�ѯ����Ӧ�ļ�¼
    }
}
