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
}
