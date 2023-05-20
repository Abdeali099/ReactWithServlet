package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", "*");

        String name=request.getParameter("user_name");
        String mobile=request.getParameter("user_mobile");

        PrintWriter printWriter=response.getWriter();

        printWriter.println("<h5>Name : "+ name +" </h5>");
        printWriter.println("<h5>Mobile : "+ mobile +" </h5>");

    }
}
