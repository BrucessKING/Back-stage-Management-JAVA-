package top.bigking.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bigking.dao.StudentMapper;
import top.bigking.model.Student;
import top.bigking.service.StudentService;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 15:30
 * @Description:
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Integer selectCount() {
        Integer count = studentMapper.selectCount();
        return count;
    }

    @Override
    public List<Student> query() {
        List<Student> studentList = studentMapper.query();
        return studentList;
    }

    @Override
    public Integer delStudent(Integer id) {
        Integer result = studentMapper.delStudent(id);
        return result;
    }
}
