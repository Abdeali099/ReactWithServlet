package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetStudentData extends HttpServlet {

    Connection connection=null;
    ResultSet resultSet=null;
    Statement statement=null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* To accept/send request from all origin */
        response.addHeader("Access-Control-Allow-Origin", "*");

        try {

            /* Load Driver class */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* Getting Connection */
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube",your_user_name,your_password);

            /* Creating statement */
            statement=connection.createStatement();

            /* Fetch Data from database */
            resultSet=statement.executeQuery("SELECT * FROM studentInfo");

            /* Create a JSON array to send response */
            JSONArray jsonArray = new JSONArray();
            JSONObject student=null;

            /* Iterating fetched data */
            while (resultSet.next()){

                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                int marks=resultSet.getInt(3);

                /* Creating JSON and store into Array */
                student = new JSONObject();
                student.put("id",id);
                student.put("name",name);
                student.put("marks",marks);

                jsonArray.put(student);
            }

            /* Setting response */

            response.setContentType("application/json");
            response.setStatus(200);
            response.getWriter().print(jsonArray);

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }finally {

            try {

                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
