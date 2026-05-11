/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reseau;

/**
 *
 * @author Mahone
 */
public class Tablette extends MS {
    private boolean supportCarteSim;
    private double tailleEcran;

    public Tablette(String nom, String prenom, String motDePasse,
                    String msisdn, String imsi, boolean supportCarteSim, double tailleEcran) {
        super(nom, prenom, motDePasse, msisdn, imsi);
        this.supportCarteSim = supportCarteSim;
        this.tailleEcran = tailleEcran;
    }

    @Override
    public void afficherType() {
        System.out.println("Tablette | SIM : " + (supportCarteSim ? "Oui" : "Non") + " | Écran : " + tailleEcran + " pouces");
    }

    public boolean isSupportCarteSim() {
        return supportCarteSim;
    }

    public double getTailleEcran() {
        return tailleEcran;
    }

    @Override
    public String toString() {
        return super.toString() + " [Tablette | SIM=" + (supportCarteSim ? "Oui" : "Non") + " | Écran=" + tailleEcran + "\"]";
    }
    
}
