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
                 FETCH_USER_INFO_QUERY = "SELECT * FROM accounts WHERE username=?",
                 FETCH_USER_ADDRESS_QUERY = "SELECT * FROM address WHERE address_id=? AND username=?",
                 FETCH_ORDER_DETAILS_QUERY = "SELECT * FROM details WHERE details_id=? AND order_id=?",
                 FETCH_BOOK_DETAILS_QUERY = "SELECT * FROM books WHERE isbn=?",
                 UPDATE_ORDER_QUERY = "UPDATE details SET processed=? WHERE details_id=? AND order_id=?",
                 COMPLETE_ORDER_QUERY = "UPDATE orders SET order_status=1 WHERE order_id=?",
                 LOCALHOST_URL = "localhost:3306/",
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
            PreparedStatement prepState = connect.prepareCall(LOG_IN_QUERY);
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
     * @param username  User whose information is needed
     * @return          User information via ResultSet
     */
    @WebMethod(operationName = "fetchUserInfo")
    public ResultSet fetchUserInfo(@WebParam(name = "username") String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
            prepState.setString(1, username);
            
            return prepState.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    /**
     * Web service operation
     * @param details_id    Details ID of current order
     * @param order_id      ID of current order
     * @return              ResultSet of details of current order    
     */
    @WebMethod(operationName = "fetchOrderDetails")
    public ResultSet fetchOrderDetails(@WebParam(name = "details_id") String details_id, @WebParam(name = "order_id") String order_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
            prepState.setString(1, details_id);
            prepState.setString(2, order_id);
            
            return prepState.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    /**
     * Web service operation
     * @param isbn  ISBN of book which needs details
     * @return      ResultSet of book details
     */
    @WebMethod(operationName = "fetchBookDetails")
    public ResultSet fetchBookDetails(@WebParam(name = "isbn") String isbn) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
            prepState.setString(1, isbn);
            
            return prepState.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param details_id
     * @param order_id
     * @param processed
     * @return 
     */
    @WebMethod(operationName = "updateOrder")
    public int updateOrder(@WebParam(name = "details_id") String details_id, @WebParam(name = "order_id") String order_id, @WebParam(name = "processed") boolean processed) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(UPDATE_ORDER_QUERY);

            if (processed)
                prepState.setInt(1, 1);
            else
                prepState.setInt(1, 0);

            prepState.setString(2, details_id);
            prepState.setString(3, order_id);
            
            return prepState.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }
    
    
}
