/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author adrian
 * 
 */
public class ReservaTV {
    private SimpleIntegerProperty numReserva = new SimpleIntegerProperty();
    private SimpleIntegerProperty t = new SimpleIntegerProperty();
    private SimpleStringProperty nomClient = new SimpleStringProperty();
    private SimpleIntegerProperty telf= new SimpleIntegerProperty();
    private SimpleStringProperty data= new SimpleStringProperty();
    private SimpleIntegerProperty quantPersones = new SimpleIntegerProperty();
    private SimpleStringProperty hora= new SimpleStringProperty();

    public ReservaTV(int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora) {
        this.numReserva.set(numReserva);
        this.t.set(t);
        this.nomClient.set(nomClient);
        this.telf.set(telf);
        this.data.set(data);
        this.quantPersones.set(quantPersones);
        this.hora.set(hora);
    }

    public ReservaTV() {
    }
    
    public int getNumReserva(){
        return numReserva.get();
    }

    public void setNumReserva(int numReserva) {
        this.numReserva.set(numReserva);
    }

    public int getT() {
        return t.get();
    }

    public void setT(int t) {
        this.t.set(t);
    }

    public String getNomclient() {
        return nomClient.get();
    }

    public void setNomClient(String nomClient) {
        this.nomClient.set(nomClient);
    }

    public int getTelf() {
        return telf.get();
    }

    public void setTelf(int telf) {
        this.telf.set(telf);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public int getQuantPersones() {
        return quantPersones.get();
    }

    public void setQuantPersones(int quantPersones) {
        this.quantPersones.set(quantPersones);
    }
    
    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }
}
