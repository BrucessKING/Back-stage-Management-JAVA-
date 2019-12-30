package top.bigking.service;

import top.bigking.model.Student;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 15:29
 * @Description:
 **/
public interface StudentService {
    /**
     * 查询学生数量
     */
    public Integer selectCount();

    /**
     * 查询所有学生信息
     */
    public List<Student> query();

    /**
     * 删除学生信息
     */
    public Integer delStudent(Integer id);
}
