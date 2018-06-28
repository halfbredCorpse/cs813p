package org.me.branch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;

/**
 *
 * @author leesa
 */
@WebService(serviceName = "BranchWS")
@Stateless()
public class BranchWS {
    final String LOG_IN_QUERY = "SELECT * FROM employees WHERE emp_id=? AND emp_pin=?",
                 FETCH_ORDER_QUERY = "SELECT * FROM orders",
                 SEARCH_ORDER_QUERY = "SELECT * FROM orders WHERE order_id=?",
                 UPDATE_ORDER_QUERY = "UPDATE <order_details_table> SET <attributes> WHERE order_id=?",
                 LOCAL_HOST_URL = "localhost:3306/",
                 PELIPAS_URL = "10.1.14.218:3306/",
                 DB_USERNAME = "java3",
                 DB_PASSWORD = "1234";
    final String CENTRAL_DB_URL = "jdbc:mysql//" + PELIPAS_URL + "central",
                 BRANCH_DB_URL = "jdbc:mysql//" + PELIPAS_URL + "branch";
    
    
    /**
     * Web service operation
     * @param empId     Employee ID
     * @param empPin    Employee PIN
     * @return boolean  True if log in is successful; false if log in fails
     */
    @WebMethod(operationName = "logIn")
    public boolean logIn(@WebParam(name = "empId") String empId, @WebParam(name = "empPin") String empPin) {
        ResultSet result;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(BRANCH_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareCall("{call login(?,?)}");
            prepState.setString(1, empId);
            prepState.setString(2, empPin);
            result = prepState.executeQuery();
            if (result.next())
                return true;
            else
                return false;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return false;
    }

    /**
     * Web service operation
     * @return ResultSet  Order ID's
     */
    @WebMethod(operationName = "fetchOrders")
    public ResultSet fetchOrders() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(BRANCH_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(FETCH_ORDER_QUERY);
    
            return prepState.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param orderId       String Order ID to be searched
     * @return ResultSet Searched order
     */
    @WebMethod(operationName = "searchOrder")
    public ResultSet searchOrder(@WebParam(name = "orderId") String orderId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(SEARCH_ORDER_QUERY);
            prepState.setString(1, orderId);
            
            return prepState.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param orderId       String Order ID to be updated
     * @return int Number of affected rows
     */
    @WebMethod(operationName = "updateOrder")
    public int updateOrder(@WebParam(name = "orderId") String orderId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(UPDATE_ORDER_QUERY);
            prepState.setString(1, orderId);
            
            return prepState.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }
    
}
