package com.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author leesa
 */
@WebService(serviceName = "OrdersWS")
@Stateless()
public class OrdersWS {
    Connection connect;
    ResultSet result;
    PreparedStatement prepState;
    String query,
           branchDBUrl = "jdbc:mysql://localhost:3306/branch0";
    
    /**
     * Web service operation
     * @param emp_id    Employee ID
     * @param emp_pin   Employee PIN
     * @return boolean  (if "true", successful log in; else failed log in)
     */
    @WebMethod(operationName = "logInEmployee")
    public boolean logInEmployee(@WebParam(name = "emp_id") String emp_id, @WebParam(name = "emp_pin") String emp_pin) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(branchDBUrl, "root", "");
            
            prepState = connect.prepareStatement("SELECT * FROM employees WHERE emp_id=? AND emp_pin=?");
            prepState.setString(1, emp_id);
            prepState.setString(2, emp_pin);
            result = prepState.executeQuery();
            
            if (result.next())
                return true;
            else
                return false;
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return false;
    }
    
}
