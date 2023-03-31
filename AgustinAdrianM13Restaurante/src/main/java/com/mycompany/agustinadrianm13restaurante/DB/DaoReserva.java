/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agustinadrianm13restaurante.DB;

import Model.Comanda;
import Model.Producte;
import Model.Reserva;
import Model.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class DaoReserva {

    public static int afegirReserva(Reserva reserva) throws SQLException {
        try {
            // Fer connexió
            Connection con = DBConnector.getConnection();
            // Redactar la SQL
            String laSQL = "insert into Reserva (dia, hora, npersones, idTaula, nomclient, telefon) values (?,?,?,?,?,?)";
            // Preparar la SQL

            PreparedStatement reservaEntrant = con.prepareStatement(laSQL);
            //String data = Utils.formatDateToBD(reserva.getData());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = formatter.parse(reserva.getData().toString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            reservaEntrant.setDate(1, sqlDate);
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
        } catch (ParseException ex) {
            Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
        try {
            //Obrir connexió
            Connection con = DBConnector.getConnection();

            // Preparar la SQL
            String laSQL = "update Reserva set dia=?, hora=?, npersones=?, idTaula=?, nomclient=?, telefon=? where idReserva=?";
            // String data = Utils.formatDateToBD(reserva.getData());
            PreparedStatement prestat = con.prepareStatement(laSQL);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = formatter.parse(reserva.getData().toString());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            prestat.setDate(1, sqlDate);
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
        } catch (ParseException ex) {
            Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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

    public static ArrayList<Integer> llistaTaules() throws SQLException {
        ArrayList<Integer> llistaTaules = new ArrayList<Integer>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "Select idTaula from Taula ";
        // Executar la consulta.
        ResultSet rs = con.createStatement().executeQuery(laSQL);

        while (rs.next()) {

            llistaTaules.add(rs.getInt("idTaula"));
        }
        con.close();
        return llistaTaules;
    }

    public static ArrayList<Producte> llistaProductesMenjar() throws SQLException {
        ArrayList<Producte> llistaProductesMenjar = new ArrayList<Producte>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "select * from Producte where categoria = 'Menjar'";
        // Executar la consulta.
        ResultSet rs = con.createStatement().executeQuery(laSQL);

        while (rs.next()) {
            Producte p = new Producte(rs.getInt("idProducte"), rs.getString("nom"), rs.getDouble("preu"), rs.getString("categoria"));
            llistaProductesMenjar.add(p);
        }
        con.close();
        return llistaProductesMenjar;
    }

    public static ArrayList<Producte> llistaProductesBeguda() throws SQLException {
        ArrayList<Producte> llistaProductesBeguda = new ArrayList<Producte>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "select * from Producte where categoria = 'Beguda'";
        // Executar la consulta.
        ResultSet rs = con.createStatement().executeQuery(laSQL);

        while (rs.next()) {
            Producte p = new Producte(rs.getInt("idProducte"), rs.getString("nom"), rs.getDouble("preu"), rs.getString("categoria"));
            llistaProductesBeguda.add(p);
        }
        con.close();
        return llistaProductesBeguda;
    }

    public static int afegirComanda(Comanda comanda) throws SQLException {
        try {
            // Fer connexió
            Connection con = DBConnector.getConnection();
            // Redactar la SQL
            String laSQL = "insert into Comanda (idTaula) values (?)";
            // Preparar la SQL

            PreparedStatement coman = con.prepareStatement(laSQL);

            coman.setInt(1, comanda.getTaula().getIdTaula());

            // Executar la sentència. ExecuteUpdate => insert, delete, update.
            // retorn = número de fileres afectades.
            int retorn = coman.executeUpdate();

            // Tancar connexió
            con.close();
            // Tornar número de fileres afectades.
            return retorn;
        } catch (Exception ex) {
            Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int afegirLineaComanda(int idComanda, Producte pro) throws SQLException {
        try {
            // Fer connexió
            Connection con = DBConnector.getConnection();
            // Redactar la SQL
            String laSQL = "insert into Comanda_has_Producte (Comanda_idComanda,Producte_idProducte) values (?,?)";
            // Preparar la SQL

            PreparedStatement coman = con.prepareStatement(laSQL);

            coman.setInt(1, idComanda);
            coman.setInt(2, pro.getIdProducte());

            // Executar la sentència. ExecuteUpdate => insert, delete, update.
            // retorn = número de fileres afectades.
            int retorn = coman.executeUpdate();

            // Tancar connexió
            con.close();
            // Tornar número de fileres afectades.
            return retorn;
        } catch (Exception ex) {
            Logger.getLogger(DaoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int getNumeroTaula(int idTaula) throws SQLException {
        // Obrim la connexió
        Connection con = DBConnector.getConnection();

        String laSQL = "SELECT idComanda FROM Restaurant.Comanda where idTaula = ? limit 1";
        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idTaula);
        ResultSet rs = prestat.executeQuery();
        int num = 0;
        while (rs.next()) {
            num = rs.getInt("idComanda");

        }
        con.close();
        return num;
    }

    public static ArrayList<Producte> llistaProductesComanda(int idTaula) throws SQLException {
        ArrayList<Producte> llista = new ArrayList<Producte>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "SELECT pro.* FROM Restaurant.Comanda co\n"
                + "inner join Restaurant.Comanda_has_Producte coh on co.idComanda=coh.Comanda_idComanda\n"
                + "inner join Restaurant.Producte pro on coh.Producte_idProducte = pro.idProducte\n"
                + "where co.idTaula = ?";
        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idTaula);
        ResultSet rs = prestat.executeQuery();

        while (rs.next()) {
            llista.add(
                    new Producte(rs.getInt("idProducte"),
                            rs.getString("nom"),
                            rs.getDouble("preu"),
                            rs.getString("categoria")
                    )
            );
        }
        con.close();
        return llista;
    }

    public static int getNumeroLineaComanda(int idProducte) throws SQLException {
        // Obrim la connexió
        Connection con = DBConnector.getConnection();

        String laSQL = "SELECT idLineaComanda FROM Restaurant.Comanda_has_Producte where Producte_idProducte = ? limit 1";
        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idProducte);
        ResultSet rs = prestat.executeQuery();
        int num = 0;
        while (rs.next()) {
            num = rs.getInt("idLineaComanda");

        }
        con.close();
        return num;
    }

    public static int esborrarLineaComanda(int lineaComanda) throws SQLException {
        // Obrir connexió
        Connection con = DBConnector.getConnection();

        //Preparar la SQL
        String laSQL = "DELETE FROM Restaurant.Comanda_has_Producte where idLineaComanda = ?";
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, lineaComanda);

        //Executar la consulta preparada
        int retorn = prestat.executeUpdate();

        //Tancar la connexió
        con.close();
        return retorn;
    }

    public static ArrayList<Double> getPreuTaula(int idTaula) throws SQLException {
        ArrayList<Double> llista = new ArrayList<Double>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "SELECT pro.preu FROM Restaurant.Comanda co\n"
                + "inner join Restaurant.Comanda_has_Producte coh on co.idComanda=coh.Comanda_idComanda\n"
                + "inner join Restaurant.Producte pro on coh.Producte_idProducte = pro.idProducte\n"
                + "where co.idTaula = ?";

        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idTaula);
        ResultSet rs = prestat.executeQuery();

        while (rs.next()) {
            double num = rs.getDouble("preu");
            llista.add(num);
        }
        con.close();
        return llista;
    }

    public static ArrayList<?> getAllProductsTaula(int idTaula) throws SQLException {
        ArrayList<Object> llista = new ArrayList<>();
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "SELECT nom,preu FROM Restaurant.Comanda co\n"
                + "inner join Restaurant.Comanda_has_Producte coh on co.idComanda=coh.Comanda_idComanda\n"
                + "inner join Restaurant.Producte pro on coh.Producte_idProducte = pro.idProducte\n"
                + "where co.idTaula = ?";

        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idTaula);
        ResultSet rs = prestat.executeQuery();

        while (rs.next()) {
            String nom = rs.getString("nom");
            double num = rs.getDouble("preu");
            llista.add(nom);
            llista.add(num);
        }
        con.close();
        return llista;
    }

    public static String getNomClient(int idTaula) throws SQLException {
        String nom = "";
        // Obrim la connexió
        Connection con = DBConnector.getConnection();
        String laSQL = "SELECT nomclient FROM Restaurant.Reserva where idTaula = ?";

        // Executar la consulta.
        PreparedStatement prestat = con.prepareStatement(laSQL);
        prestat.setInt(1, idTaula);
        ResultSet rs = prestat.executeQuery();

        while (rs.next()) {
            nom = rs.getString("nomclient");

        }
        con.close();
        return nom;
    }

    public static int esborrarRegistresReserva(int idTaula) throws SQLException {
        // Obrir connexió
        Connection con = DBConnector.getConnection();
        int idComanda = 0 ;
        String laSQLReserva = "DELETE FROM Restaurant.Reserva where idTaula = ?";
        PreparedStatement prestatReserva = con.prepareStatement(laSQLReserva);
        prestatReserva.setInt(1, idTaula);

        //Executar la consulta preparada
        int retornReserva = prestatReserva.executeUpdate();
        String sqlIdComanda = "SELECT ch.Comanda_idComanda FROM Restaurant.Comanda_has_Producte  ch\n"
                + "inner join Restaurant.Comanda co on co.idComanda = ch.Comanda_idComanda where co.idTaula = ?\n"
                + "group by ch.Comanda_idComanda";
        
         PreparedStatement prestatIdComanda = con.prepareStatement(sqlIdComanda);
        prestatIdComanda.setInt(1, idTaula);
        ResultSet rs = prestatIdComanda.executeQuery();

        while (rs.next()) {
            idComanda = rs.getInt("Comanda_idComanda");

        }

        //Preparar la SQL
        String laSQL = "DELETE FROM Restaurant.Comanda_has_Producte where Comanda_idComanda = ?";
        PreparedStatement prestatComandaProducte = con.prepareStatement(laSQL);
        prestatComandaProducte.setInt(1, idComanda);

        //Executar la consulta preparada
        int retorn = prestatComandaProducte.executeUpdate();

        String laSQLComanda = "DELETE FROM Restaurant.Comanda where idTaula = ?";
        PreparedStatement prestatComanda = con.prepareStatement(laSQLComanda);
        prestatComanda.setInt(1, idTaula);

        //Executar la consulta preparada
        int retornComanda = prestatComanda.executeUpdate();

        int sumaRetorn = retornReserva + retorn + retornComanda + idComanda;

        //Tancar la connexió
        con.close();
        return sumaRetorn;
    }

}
