/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.dao.UserDao;
import java.sql.SQLException;
import com.bean.User;

/**
 *
 * @author Paulo Ricardo
 */
public class UserController {
    
    private final UserDao usuDao;
    
    public UserController() throws SQLException, ClassNotFoundException
    
    {
        this.usuDao = new UserDao();
    }
     public boolean inserirUsuario(User usu) throws SQLException 
    {
        boolean sucesso;
        sucesso = usuDao.inserir(usu);
        return sucesso;
    }
    

    public User buscaUsuario(User usu) throws SQLException 
    {
        usu = usuDao.buscar(usu);
        return usu;
    }
    
    public boolean excluirUsuario(User usu) throws SQLException 
    {
       boolean sucesso; 
       sucesso = usuDao.excluir(usu);
       return sucesso;
    }
    
    public boolean alterarUsuario(User usu) throws SQLException
    {
        boolean sucesso;
        sucesso = usuDao.alterar(usu);
        return sucesso;
    }
}
