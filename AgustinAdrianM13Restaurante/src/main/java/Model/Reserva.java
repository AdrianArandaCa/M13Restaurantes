/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author adrian
 */
public class Reserva {
    int idReserva;
    Taula t;
    String nomClient;
    int telefon;
    Date dia;
    int npersones;

    public Reserva(int numReserva, Taula t, String nomClient, int telf, Date data, int quantPersones) {
        this.idReserva = numReserva;
        this.t = t;
        this.nomClient = nomClient;
        this.telefon = telf;
        this.dia = data;
        this.npersones = quantPersones;
    }

    public int getNumReserva() {
        return idReserva;
    }

    public void setNumReserva(int numReserva) {
        this.idReserva = numReserva;
    }

    public Taula getT() {
        return t;
    }

    public void setT(Taula t) {
        this.t = t;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public int getTelf() {
        return telefon;
    }

    public void setTelf(int telf) {
        this.telefon = telf;
    }

    public Date getData() {
        return dia;
    }

    public void setData(Date data) {
        this.dia = data;
    }

    public int getQuantPersones() {
        return npersones;
    }

    public void setQuantPersones(int quantPersones) {
        this.npersones = quantPersones;
    }

    @Override
    public String toString() {
        return "Reserva{" + "numReserva=" + idReserva + ", t=" + t + ", nomClient=" + nomClient + ", telf=" + telefon + ", data=" + dia + ", quantPersones=" + npersones + '}';
    }
    
    
}
