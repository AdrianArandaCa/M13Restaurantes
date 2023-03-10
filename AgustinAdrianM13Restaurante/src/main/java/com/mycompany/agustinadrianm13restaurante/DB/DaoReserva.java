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
public class DaoReserva {

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
        reservaEntrant.setInt(4, reserva.getT());
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

    public static int esborrarReserva(int codi) throws SQLException {
        // Obrir connexió
        Connection con = DBConnector.getConnection();

        //Preparar la SQL
        String laSQL = "delete from Reserva where idReserva=?";
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, codi);

        //Executar la consulta preparada
        int retorn = prestat.executeUpdate();

        //Tancar la connexió
        con.close();
        return retorn;
    }

    public static int modificarReserva(Reserva reserva) throws SQLException {
        //Obrir connexió
        Connection con = DBConnector.getConnection();

        // Preparar la SQL
        String laSQL = "update Reserva set dia=?, hora=?, npersones=?, idTaula=?, nomclient=?, telefon=? where idReserva=?";
        String data = Utils.formatDateToBD(reserva.getData());
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setString(1, data);
        prestat.setString(2, reserva.getHora());
        prestat.setInt(3, reserva.getQuantPersones());
        prestat.setInt(4, reserva.getT());
        prestat.setString(5, reserva.getNomClient());
        prestat.setInt(6, reserva.getTelf());
        prestat.setInt(7, reserva.getNumReserva());

        // Executar la sentència
        int retorn = prestat.executeUpdate();

        // Tancar la connexió
        con.close();

        return retorn;
    }

    public static ArrayList<Reserva> llistaTots() throws SQLException {
        ArrayList<Reserva> llista = new ArrayList<Reserva>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "Select * from Reserva order by idReserva";
        // Executar la consulta.
        ResultSet rs = con.createStatement().executeQuery(laSQL);
 
        while (rs.next()) {
            String data = Utils.formatDateToTable(rs.getString("dia"));
            llista.add(
                    new Reserva(rs.getInt("idReserva"),
                            rs.getString("dia"),
                            rs.getString("hora"),
                            rs.getInt("npersones"),
                            rs.getInt("idTaula"),
                            rs.getString("nomclient"),
                            rs.getInt("telefon")
                    )
            );
        }
        con.close();
        return llista;
    }
}
