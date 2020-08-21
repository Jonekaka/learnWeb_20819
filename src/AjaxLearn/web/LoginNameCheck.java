package AjaxLearn.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/loginNameCheck")
public class LoginNameCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
//        设置响应数据格式
        response.setContentType("application/json;charset=utf-8");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        if("tom".equals(username)){
            stringObjectHashMap.put("userExsit",true);
            stringObjectHashMap.put("msg","用户名重复");
        }
        else{
            stringObjectHashMap.put("userExsit",false);
            stringObjectHashMap.put("msg","用户名可用");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),stringObjectHashMap);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
