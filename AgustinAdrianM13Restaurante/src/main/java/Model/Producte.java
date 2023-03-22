/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author adrian
 */
public class Producte {
    int idProducte;
    String nom;
    double preu;
    String categoria;

    public Producte(int idProducte, String nom, double preu, String categoria) {
        this.idProducte = idProducte;
        this.nom = nom;
        this.preu = preu;
        this.categoria = categoria;
    }

    public int getIdProducte() {
        return idProducte;
    }

    public void setIdProducte(int idProducte) {
        this.idProducte = idProducte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   

   

    
    
    
}
