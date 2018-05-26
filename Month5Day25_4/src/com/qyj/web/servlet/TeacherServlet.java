package com.qyj.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.qyj.domain.Teacher;
import com.qyj.service.TeacherService;
import com.qyj.utils.MyJsonUtils;

import java.io.IOException;
import java.util.List;

public class TeacherServlet extends BaseServlet {
    private TeacherService teacherService = new TeacherService();
    /**
     * 展示所有老师的ajax
     * @throws IOException
     */
    public void showTeacher() throws IOException{
        // 在此完成代码
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        String jsonString = MyJsonUtils.getJsonString(allTeacher);
        getResponse().getWriter().print(jsonString);
    }
}
