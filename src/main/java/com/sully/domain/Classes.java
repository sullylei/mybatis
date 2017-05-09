package com.sully.domain;

/**
 * Created by Administrator on 2016/4/10.
 */

import java.io.Serializable;
import java.util.List;

/**
 * ����class���Ӧ��ʵ����
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

    //����ʵ��������ԣ���class���е��ֶζ�Ӧ
    private int id;            //id===>c_id
    private String name;    //name===>c_name

    /**
     * class������һ��teacher_id�ֶΣ�������Classes���ж���һ��teacher���ԣ�
     * ����ά��teacher��class֮���һ��һ��ϵ��ͨ�����teacher���ԾͿ���֪������༶�����ĸ���ʦ�����
     */
    private Teacher teacher;
    //ʹ��һ��List<Student>�������Ա�ʾ�༶ӵ�е�ѧ��
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
