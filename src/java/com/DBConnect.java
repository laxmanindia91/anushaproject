//Db connection java class
package com;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect{
  public static Connection getConnection(){
        Connection con=null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/insert","root","");  
            }
            catch(ClassNotFoundException | SQLException e2)
            {
            }
         return con;
    }
}