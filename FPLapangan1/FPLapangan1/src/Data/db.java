/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author hangg
 */
public class db {
    
    public static Connection mycon() {
        Connection con = null;   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking_lapangan","root","");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        return con;
        
    }
    
}
