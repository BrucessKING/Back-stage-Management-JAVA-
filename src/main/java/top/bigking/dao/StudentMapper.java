package top.bigking.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.bigking.model.Student;

import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 15:24
 * @Description:
 **/
@Component
public interface StudentMapper {
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
     * @param id
     */
    public Integer delStudent(@Param("id") Integer id);
}
