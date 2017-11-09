/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.connectiondb.ConnectionDB;
import java.sql.PreparedStatement;
import com.bean.User;
import java.sql.ResultSet;

/**
 *
 * @author Paulo Ricardo
 */
public class UserDao {
    
    private final Connection c;
    
    public UserDao() throws SQLException, ClassNotFoundException
    
    {
        this.c = new ConnectionDB().getConnection();
    }
    
     public User buscar(User usu) throws SQLException        
    {
       try{
           String sql = "select * from usuario where nome_usuario = ?";
       
       try ( 
             
             PreparedStatement stmt = this.c.prepareStatement(sql) 
           ) 
       {
            
            // seta os valores
            stmt.setString(1,usu.getNome_usuario());
            
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) 
            
            {
                // criando o objeto Produto
                usu.setId(rs.getInt(1));
                usu.setNome_usuario(rs.getString(2));
                usu.setEmail_usuario(rs.getString(3));
                
            }
        }
      
       return usu;
           
       }catch(SQLException ex)
       {
         throw ex;
       }
        
    }
    
    public boolean inserir(User usu) throws SQLException   
    {
        try{
        
        String sql = "insert into usuario (nome_usuario,email_usuario) values (?,?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        // seta os valores
        stmt.setString(1,usu.getNome_usuario());
        stmt.setString(2,usu.getEmail_usuario());
        // executa
        stmt.execute();
        stmt.close();
        return true;
            
        }catch(SQLException ex ){
           
            return false;
        }
       
    }
    
    public boolean excluir(User usu) throws SQLException
    {
        try{
        String sql = "delete from usuario where id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        //seta os valroes
        String id = String.valueOf(usu.getId());
        stmt.setString(1,id);
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return true;
            
        }catch (SQLException ex){
            return false;
        }
        
    }
     public boolean alterar(User usu) throws SQLException
    {
        
        try{
        String sql = "update usuario set nome_usuario = ?, email_usuario = ? WHERE id = ?";
        String id = String.valueOf(usu.getId());
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1,usu.getNome_usuario());
        stmt.setString(2,usu.getEmail_usuario());
        stmt.setString(3,id);

        
        stmt.execute();
        stmt.close();
        c.close();
        
        return true;
        
        }catch(SQLException ex){
            return false;
        }
    }
    
}
