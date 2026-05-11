/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reseau;

/**
 *
 * @author Mahone
 */

public class Smartphone extends MS {

    private String systemeExploitation;
    private double tailleEcran;

    public Smartphone(String nom, String prenom, String motDePasse,
                      String msisdn, String imsi, String systemeExploitation, double tailleEcran) {
        super(nom, prenom, motDePasse, msisdn, imsi);
        this.systemeExploitation = systemeExploitation;
        this.tailleEcran = tailleEcran;
    }

    @Override
    public void afficherType() {
        System.out.println("Smartphone | OS : " + systemeExploitation + " | Ecran : " + tailleEcran + " pouces");
    }

    public String getSystemeExploitation() {
        return systemeExploitation;
    }

    public double getTailleEcran() {
        return tailleEcran;
    }

    @Override
    public String toString() {
        return super.toString() + " [Smartphone | OS=" + systemeExploitation + " | Ecran=" + tailleEcran + "\"]";
    }
}