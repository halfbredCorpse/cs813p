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
import java.text.SimpleDateFormat;
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
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234");
            
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
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234");
            
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
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234");
            
            PreparedStatement pstmt = con.prepareStatement("select * from books where genre_id=? order by img_path limit ?");
            pstmt.setInt(1, genreId);
            pstmt.setInt(2, sizeOfList);
            
            ResultSet rs = pstmt.executeQuery();
            
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            
            while(rs.next()) {
                ArrayList<Object> book = new ArrayList<>();
                book.add(rs.getString(1));
                book.add(rs.getString(2));
                book.add(rs.getDouble(3));
                book.add(rs.getString(4));
                book.add(rs.getString(5));
                book.add(dt1.format(rs.getDate(6)));
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "returnSingleBook")
    public List<Object> returnSingleBook(@WebParam(name = "isbn") String isbn) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234");
            
            PreparedStatement pstmt = con.prepareStatement("select * from books where isbn=?");
            pstmt.setString(1, isbn);
            
            ResultSet rs = pstmt.executeQuery();
            
            List<Object> book = new ArrayList<>();
            
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            
            if(rs.next()) {
                book.add(rs.getString(1));
                book.add(rs.getString(2));
                book.add(rs.getDouble(3));
                book.add(rs.getString(4));
                book.add(rs.getString(5));
                book.add(dt1.format(rs.getDate(6)));
                book.add(rs.getString(7));
                book.add(rs.getString(8));
                book.add(rs.getString(9));
                book.add(rs.getString(10));
            }
            
            return book;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getGenre")
    public String getGenre(@WebParam(name = "genreId") int genreId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234");
            
            PreparedStatement pstmt = con.prepareStatement("select genre_name from genres where genre_id=?");
            pstmt.setInt(1, genreId);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "signUp")
    public boolean signUp(@WebParam(name = "username") String username, @WebParam(name = "email") String email, @WebParam(name = "pass") String pass, @WebParam(name = "first_name") String first_name, @WebParam(name = "last_name") String last_name,@WebParam(name = "street") String street, @WebParam(name = "city") String city, @WebParam(name = "province") String province, @WebParam(name = "zip") String zip, @WebParam(name = "longitude") String longitude, @WebParam(name = "latitude") String latitude, @WebParam(name = "creditCard") String creditCard, @WebParam(name = "cvv") String cvv) {
        try {
            
            String addressId = "", cart_id = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/central", "jas", "1234"); 
            Connection con2 = DriverManager.getConnection("jdbc:mysql://10.1.14.218:3306/client ", "jas", "1234");
            
            PreparedStatement pstmt = con2.prepareStatement("select cart_id from cart order by cart_id desc limit 1");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                addressId = String.valueOf(rs.getInt(1)+1);
                cart_id = addressId;         
            }
                    
            pstmt = con.prepareCall("call addUsers(?,?,?,?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, pass);
            pstmt.setString(4, first_name);
            pstmt.setString(5, last_name);
            pstmt.setString(6, addressId);
            pstmt.setString(7, longitude);
            pstmt.setString(8, latitude);
            pstmt.setString(9, creditCard);
            pstmt.setString(10, cvv);
            pstmt.setString(11, cart_id);
            
            pstmt.executeUpdate();
            
            pstmt = con.prepareCall("call addAddress(?,?,?,?,?,?)");
            pstmt.setInt(1, Integer.parseInt(addressId));
            pstmt.setString(2, street);
            pstmt.setString(3, city);
            pstmt.setString(4, province);
            pstmt.setString(5, zip);
            pstmt.setString(6, username);
            
            pstmt.executeUpdate();
            
            
            pstmt = con2.prepareStatement("insert into cart (cart_id) values (?)");
            pstmt.setString(1, cart_id);
            
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }
}
