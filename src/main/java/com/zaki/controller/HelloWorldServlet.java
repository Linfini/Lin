package com.zaki.controller;

import com.alibaba.fastjson.JSONObject;
import com.zaki.model.UserExpand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 需要在Application 添加@ServletComponentScan注解才能扫描到servlet
 */
@WebServlet(name = "/helloWorld", urlPatterns = "/helloWorld")
public class HelloWorldServlet extends HttpServlet {
    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        UserExpand userExpand = new UserExpand();
        userExpand.setUserName("张三");
        userExpand.setCreateTime(new Date());
        String json = JSONObject.toJSONString(userExpand);
        writer.write(json);
    }


    @Override
    public void init() throws ServletException {
        message = "你好";
    }
}
