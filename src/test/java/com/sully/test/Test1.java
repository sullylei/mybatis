package com.sully.test;

/**
 * Created by Administrator on 2016/4/9.
 */

import com.sully.domain.User;
import com.sully.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.net.URL;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws IOException {

        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * com.sully.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.sully.mapping.userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����һ��Ψһuser�����sql
        User user = session.selectOne(statement, 1);
        System.out.println(user.getName());
        String statementList = "com.sully.mapping.userMapper.getList";//ӳ��sql�ı�ʶ�ַ���
        List<User> list = session.selectList(statementList);
        for(User tempUser:list){
            System.out.println(tempUser.getName());
        }
        MyBatisUtil.closeSqlSession();
    }
}