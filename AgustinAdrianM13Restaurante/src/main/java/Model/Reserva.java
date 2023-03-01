/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author adrian
 */
public class Reserva {
    int idReserva;
    int t;
    String nomClient;
    int telefon;
    String dia;
    String hora;
    int npersones;

    public Reserva(int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora) {
        this.idReserva = numReserva;
        this.t = t;
        this.nomClient = nomClient;
        this.telefon = telf;
        this.dia = data;
        this.npersones = quantPersones;
        this.hora = hora;
    }
    
    public int getNumReserva() {
        return idReserva;
    }

    public void setNumReserva(int numReserva) {
        this.idReserva = numReserva;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
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

    public String getData() {
        return dia;
    }

    public void setData(String data) {
        this.dia = data;
    }

    public int getQuantPersones() {
        return npersones;
    }

    public void setQuantPersones(int quantPersones) {
        this.npersones = quantPersones;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", t=" + t + ", nomClient=" + nomClient + ", telefon=" + telefon + ", dia=" + dia + ", hora=" + hora + ", npersones=" + npersones + '}';
    }
}
