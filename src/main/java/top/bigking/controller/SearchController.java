package top.bigking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.bigking.model.Student;
import top.bigking.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: ABKing
 * @Date: 2019/12/29 15:33
 * @Description:
 **/
@Controller
public class SearchController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping("search")
    public String search(HttpSession session){
        Integer count = studentService.selectCount();
        List<Student> studentList = studentService.query();
        session.setAttribute("count", count);
        session.setAttribute("studentList", studentList);
        return "search";
    }
    @RequestMapping("delStudent")
    public String delStudent(Integer id){
        studentService.delStudent(id);
        return "search";
    }
}
