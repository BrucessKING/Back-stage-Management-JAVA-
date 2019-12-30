package top.bigking.model;

import java.io.Serializable;

/**
 * @author: ABKing
 * @Date: 2019/12/29 15:16
 * @Description:
 **/
public class Student implements Serializable {
    private Integer id;
    private String studentId;
    private String name;
    private Integer age;
    private String gender;


    public Student() {
    }

    public Student(String studentId, String name, Integer age, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
