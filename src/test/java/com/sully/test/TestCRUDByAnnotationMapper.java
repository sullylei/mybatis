package com.sully.test;


import java.util.List;

import com.sully.domain.User;
import com.sully.mapping.UserMapperI;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
/**
 * Creator: lei.s
 * Create Date: 2017��05��09��
 * �๦��������
 */
public class TestCRUDByAnnotationMapper {
    Logger logger = Logger.getLogger(TestCRUDByAnnotationMapper.class);
    @Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user = new User();
        user.setName("�û�test");
        user.setAge(20);
        int add = mapper.add(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user = new User();
        user.setId(7);
        user.setName("sully_test");
        user.setAge(18);
        //ִ���޸Ĳ���
        int retResult = mapper.update(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        System.out.println(retResult);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.deleteById(7);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        System.out.println(retResult);
    }

    @Test
    public void testGetUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        User user = mapper.getById(2);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        logger.info(user);
    }

    @Test
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<User> lstUsers = mapper.getAll();
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        MyBatisUtil.closeSqlSession();
        System.out.println(lstUsers);
    }
}