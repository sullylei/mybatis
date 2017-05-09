package com.sully.domain;

/**
 * Created by Administrator on 2016/4/10.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 定义class表对应的实体类
 CREATE TABLE teacher(
 t_id INT PRIMARY KEY AUTO_INCREMENT,
 t_name VARCHAR(20)
 );
 CREATE TABLE class(
 c_id INT PRIMARY KEY AUTO_INCREMENT,
 c_name VARCHAR(20),
 teacher_id INT
 );
 ALTER TABLE class ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher(t_id);

 INSERT INTO teacher(t_name) VALUES('teacher1');
 INSERT INTO teacher(t_name) VALUES('teacher2');

 INSERT INTO class(c_name, teacher_id) VALUES('class_a', 1);
 INSERT INTO class(c_name, teacher_id) VALUES('class_b', 2);
 */
public class Classes implements Serializable {

    //定义实体类的属性，与class表中的字段对应
    private int id;            //id===>c_id
    private String name;    //name===>c_name

    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    private Teacher teacher;
    //使用一个List<Student>集合属性表示班级拥有的学生
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
