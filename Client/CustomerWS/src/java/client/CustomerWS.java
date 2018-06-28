/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jasmin Rose
 */
@WebService(serviceName = "CustomerWS")
public class CustomerWS {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "username") String username, @WebParam(name = "pass") String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "java3", "1234");
            
            PreparedStatement pstmt = con.prepareStatement("select username, pass from accounts where username=? and pass=?");
            pstmt.setString(1, username);
            pstmt.setString(2, pass);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        
        return false;
    }

    /**
     * Web service operation
     * @param username
     */
    @WebMethod(operationName = "getAccountDetails")
    public List<Object> getAccountDetails(@WebParam(name = "username") String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "java3", "1234");
            
            PreparedStatement pstmt = con.prepareStatement("select * from accounts where username=?"    );
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                
                List<Object> user = new ArrayList<>();
                user.add(rs.getString(1));
                user.add(rs.getString(2));
                user.add(rs.getString(3));
                user.add(rs.getString(4));
                user.add(rs.getString(5));
                user.add(rs.getString(6));
                user.add(rs.getString(7));
                user.add(rs.getString(8));
                user.add(rs.getInt(9));
                user.add(rs.getInt(10));
                user.add(rs.getString(11));
                user.add(rs.getString(12));
                /*
                Map<String, Object> user = new HashMap<>();
                user.put("userID", rs.getString(1));
                user.put("username", rs.getString(2));
                user.put("email", rs.getString(3));
                user.put("pass", rs.getString(4));
                user.put("firstName", rs.getString(5));
                user.put("lastName", rs.getString(6));
                user.put("add1", rs.getString(7));
                user.put("add2", rs.getString(8));
                user.put("longitude", rs.getInt(9));
                user.put("latitude", rs.getString(10));
                user.put("creditCard", rs.getString(11));
                user.put("cvv", rs.getString(12));*/
                
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loadBooks")
    public ArrayList<Object> loadBooks(@WebParam(name = "genreId") int genreId, @WebParam(name = "sizeOfList") int sizeOfList, @WebParam(name = "index") int index) {
        List<ArrayList<Object>> listOfBooks = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/central", "root", "");
            
            PreparedStatement pstmt = con.prepareStatement("select * from books where genre_id=? order by img_path limit ?");
            pstmt.setInt(1, genreId);
            pstmt.setInt(2, sizeOfList);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                ArrayList<Object> book = new ArrayList<>();
                book.add(rs.getString(1));
                book.add(rs.getString(2));
                book.add(rs.getDouble(3));
                book.add(rs.getString(4));
                book.add(rs.getString(5));
                book.add(rs.getDate(6));
                book.add(rs.getString(7));
                book.add(rs.getString(8));
                book.add(rs.getString(9));
                book.add(rs.getString(10));
                
                listOfBooks.add(book);
            }
            
            return listOfBooks.get(index);
        } catch (Exception e) {
        }
        return null;
    }
    
}
