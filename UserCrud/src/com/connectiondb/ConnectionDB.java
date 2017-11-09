/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Paulo Ricardo
 */
public class ConnectionDB {
    
     public Connection getConnection() throws SQLException, ClassNotFoundException {
        
       try 
        {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/db_oficina_java";
                String usuario = "root";
                String senha = "system";
                return DriverManager.getConnection(url,usuario,senha);
        }       
                catch (SQLException e) 
                {
                    throw new RuntimeException(e);
                }
    }
}
