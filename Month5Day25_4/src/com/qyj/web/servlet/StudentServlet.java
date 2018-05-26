package com.qyj.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.qyj.domain.Student;
import com.qyj.service.StudentService;
import com.qyj.utils.MyJsonUtils;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentService();
    /**
     * 展示所有的学生的ajax
     */
    public void showStudent() throws IOException{
        // 在此完成代码
        List<Student> allStudent = studentService.findAllStudent();
        String jsonString = MyJsonUtils.getJsonString(allStudent);
        getResponse().getWriter().print(jsonString);
    }
}
