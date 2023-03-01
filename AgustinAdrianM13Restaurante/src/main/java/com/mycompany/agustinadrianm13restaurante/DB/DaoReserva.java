/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agustinadrianm13restaurante.DB;
import Model.Reserva;
import Model.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author adrian
 */
public class DaoComanda {
    public static int afegirReserva(Reserva reserva) throws SQLException {
        // Fer connexió
        Connection con = DBConnector.getConnection();
        // Redactar la SQL
        String laSQL = "insert into Reserva (dia, hora, npersones, idTaula, nomclient, telefon) values (?,?,?,?,?,?)";
        // Preparar la SQL
        
        PreparedStatement reservaEntrant = con.prepareStatement(laSQL);
        String data = Utils.formatDateToBD(reserva.getData());
        reservaEntrant.setString(1, data);
        reservaEntrant.setString(2, reserva.getHora());
        reservaEntrant.setInt(3, reserva.getQuantPersones());
        reservaEntrant.setInt(4, reserva.getT().getIdTaula());
        reservaEntrant.setString(5, reserva.getNomClient());
        reservaEntrant.setInt(6, reserva.getTelf());
        
        
        // Executar la sentència. ExecuteUpdate => insert, delete, update.
        // retorn = número de fileres afectades.
        int retorn = reservaEntrant.executeUpdate();
        
        // Tancar connexió
        con.close();
        // Tornar número de fileres afectades.
        return retorn;
    }
    public static int esborrarReserva (int codi) throws SQLException{
        // Obrir connexió
        Connection con = DBConnector.getConnection();
        
        //Preparar la SQL
        String laSQL = "delete from empleats where codi=?";
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, codi);
        
        //Executar la consulta preparada
        int retorn = prestat.executeUpdate();
        
        //Tancar la connexió
        con.close();
        return retorn;   
    }
    public static int modificarReserva(Reserva reserva) throws SQLException{
        //Obrir connexió
        Connection con = DBConnector.getConnection();
        
        // Preparar la SQL
        String laSQL = "update empleats set nom=?, cognom=?, funcio=?, datacontracte=?, sou=? where codi=?";
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setString(1, reserva.getNom());
        prestat.setString(2, reserva.getCognom());
        prestat.setString(3, reserva.getFuncio());
        prestat.setString(4,reserva.getDatacontracte());
        prestat.setInt(5, reserva.getSou());
        prestat.setInt(6, reserva.getCodi());
        
        // Executar la sentència
        int retorn = prestat.executeUpdate();
        
        // Tancar la connexió
        con.close();
        
        return retorn;
    }
    
    public static ArrayList<Empleats> llistaTots() throws SQLException{
        ArrayList<Empleats> llista = new ArrayList<Empleats>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "Select * from empleats order by codi";
        // Executar la consulta.
        ResultSet rs = con.createStatement().executeQuery(laSQL);
        
        while (rs.next()){
            llista.add(
                    new Empleats(rs.getInt("codi"),
                                 rs.getString("nom"),
                                 rs.getString("cognom"),
                                 rs.getString("funcio"),
                                 rs.getString("datacontracte"),
                            rs.getInt("sou")
                    )
            );
        }
        con.close();
        return llista;
    }
//    public static List<Empleats> llistaPerFuncio(String funcio) throws SQLException {
//        List<Empleats> llista = new ArrayList<Empleats>();
//        
//        Connection con = DBConnector.getConnection();
//        String laSQL = "select * from empleats where funcio=?";
//        PreparedStatement prestat = con.prepareStatement(laSQL);
//        prestat.setString(1, funcio);
//        ResultSet rs = prestat.executeQuery();
//        while (rs.next()){
//            llista.add(
//                    new Empleats(rs.getInt("codi"),
//                                 rs.getString("nom"),
//                                 rs.getString("cognom"),
//                                 rs.getString("funcio"),
//                                 rs.getString("datacontracte"),
//                            rs.getInt("sou")
//                    )
//            );
//        }
//        con.close();
//        return llista;
//    }
}
