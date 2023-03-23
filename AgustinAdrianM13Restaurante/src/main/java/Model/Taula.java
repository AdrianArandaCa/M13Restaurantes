/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author adrian
 */
public class Taula {
    int idTaula;
    Comanda comanda;

    public Taula(int idTaula, Comanda comanda) {
        this.idTaula = idTaula;
        this.comanda = comanda;
    }
    public Taula(int idTaula) {
        this.idTaula = idTaula;
        
    }
    public int getIdTaula() {
        return idTaula;
    }

    public void setIdTaula(int idTaula) {
        this.idTaula = idTaula;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    @Override
    public String toString() {
        return "Taula{" + "idTaula=" + idTaula + ", comanda=" + comanda + '}';
    }    
}
