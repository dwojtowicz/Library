package com.library.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Servled at: ").append(request.getContextPath());

        String user = "libraryuser";
        String pass = "libraryuser";
        String jdbcUrl = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();

            out.println("Connecting to database:" + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connect success");

            myConn.close();

        } catch(Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }

    }
}
