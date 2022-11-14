package com.company;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.company.Model;
import com.company.OracleJDBC;

@WebServlet("/")
public class Serverlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getServletPath();
        if(action.equals("listEmp"))
        {
            try {
                listEmp(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void listEmp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException
    {
        List<Model> listEmp = OracleJDBC.selectAllEmp();
        request.setAttribute("listEmp", listEmp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("emp-list.html");
        dispatcher.forward(request, response);
    }
}
