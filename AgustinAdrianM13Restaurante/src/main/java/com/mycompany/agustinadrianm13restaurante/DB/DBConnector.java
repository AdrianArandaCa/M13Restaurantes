/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agustinadrianm13restaurante.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author adrian
 */
public class DBConnector {
    public static Connection getConnection() throws SQLException{
        //localhost:3306
        String url = "jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC";
        String usu = "agustin";
        String pw = "Adminroot95";
        Connection con = DriverManager.getConnection(url,usu,pw);
        return con;
    }
}