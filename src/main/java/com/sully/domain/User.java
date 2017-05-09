package com.sully.domain;

import java.io.Serializable;

/**
 * @author gacl
 * users表所对应的实体类
 *SQL脚本如下：
 * create database mybatis;
 * use mybatis;
 * CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
 * INSERT INTO users(NAME, age) VALUES('ruly', 27);
 * INSERT INTO users(NAME, age) VALUES('sully', 27);
 */
public class User implements Serializable{

    //实体类的属性和表的字段名称一一对应
    private int id;
    private String name;
    private int age;
    public User(){}
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}