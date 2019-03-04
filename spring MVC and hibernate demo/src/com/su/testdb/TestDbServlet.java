package com.su.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String user = "test";
        String pass = "test";
        String url = "jdbc:mysql://localhost:3306/web_customer?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";


        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("Connecting to db >> " + url);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            printWriter.println("Connected.. all ok");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
