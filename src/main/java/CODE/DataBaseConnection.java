/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * this class is the connection established  with database
 * @author lahiru yasas
 */
public class DataBaseConnection {
    
      public static Connection DBConnection(){

        Connection con;
        
        try{
           //set the database connection using JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cisproject","root","");
            System.out.println("Connection established with the Database...");
            return con;
            
        } 
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException \n"+e);
            return null;
        }
        catch(SQLException e)
        {
            System.out.println("SQLException \n"+e);
            return null;
        }
        catch(NullPointerException ex){
            System.out.println("Null pointer Error \n"+ex);
            return null;
        }
        
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
    
    
    
    
}
