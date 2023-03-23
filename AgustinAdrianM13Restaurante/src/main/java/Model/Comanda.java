/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrian
 */
public class Comanda {
    int codi;
    Taula taula;
    ArrayList<Producte> productes;

    public Comanda(int codi, Taula taula) {
        this.codi = codi;
        this.taula = taula;
    }

    public Comanda(int codi, Taula taula, ArrayList<Producte> productes) {
        this.codi = codi;
        this.taula = taula;
        this.productes = productes;
    }
    

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public Taula getTaula() {
        return taula;
    }

    public void setTaula(Taula taula) {
        this.taula = taula;
    }

    public List<Producte> getProductes() {
        return productes;
    }

    public void setProductes(ArrayList<Producte> productes) {
        this.productes = productes;
    }

    @Override
    public String toString() {
        return "Comanda{" + "codi=" + codi + ", taula=" + taula + ", productes=" + productes + '}';
    }

    
    
    
}
