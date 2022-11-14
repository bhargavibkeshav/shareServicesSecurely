package com.company;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.company.Model;
public class OracleJDBC {

    public static List<Model> selectAllEmp() throws SQLException {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:oracle:thin:@acaddbprod-2.uta.edu:1523/pcse1p.data.uta.edu", "bxb5763", "Ramababa2403");
        List<Model> Emp = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from F21_003_10_EMPLOYEE;");
        while (rs.next())
        {
            String eid = rs.getString("EID");
            String ename = rs.getString("ENAME");
            String dept = rs.getString("EMPLOYEEDEPT");
            Emp.add(new Model(eid,ename,dept));
        }
        rs.close();
        stmt.close();
        connection.close();
        return Emp;
    }

}
