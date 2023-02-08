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
    String img;

    public Producte(int codi, String nom, double preu, String img) {
        this.idProducte = codi;
        this.nom = nom;
        this.preu = preu;
        this.img = img;
    }

    public int getCodi() {
        return idProducte;
    }

    public void setCodi(int codi) {
        this.idProducte = codi;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Producte{" + "codi=" + idProducte + ", nom=" + nom + ", preu=" + preu + ", img=" + img + '}';
    }
    
    
}
