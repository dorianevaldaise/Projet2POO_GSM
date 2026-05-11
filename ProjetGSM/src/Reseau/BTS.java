/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reseau;

/**
 *
 * @author Mahone
 */
import java.util.ArrayList;
public class BTS {
 
    private String numero;
    private String emplacement;
    private double hauteur;
    private String typeMilieu;
    private double rayonCouverture;
    private double puissanceEmission;
    private int nbMaxUtilisateurs;
    private ArrayList<MS> msAttaches;

    public BTS(String numero, String emplacement, double hauteur, String typeMilieu,
               double rayonCouverture, double puissanceEmission, int nbMaxUtilisateurs) {
        this.numero = numero;
        this.emplacement = emplacement;
        this.hauteur = hauteur;
        this.typeMilieu = typeMilieu;
        this.rayonCouverture = rayonCouverture;
        this.puissanceEmission = puissanceEmission;
        this.nbMaxUtilisateurs = nbMaxUtilisateurs;
        this.msAttaches = new ArrayList<>();
    }

    public boolean ajouterMS(MS ms) {
        if (msAttaches.size() < nbMaxUtilisateurs) {
            msAttaches.add(ms);
            return true;
        }
        return false;
    }

    public boolean supprimerMS(MS ms) {
        return msAttaches.remove(ms);
    }

    public MS rechercherMS(String msisdn) throws MSIntrouvableException {
        for (MS ms : msAttaches) {
            if (ms.getMsisdn().equals(msisdn)) {
                return ms;
            }
        }
        throw new MSIntrouvableException("Aucun MS trouve avec le numero " + msisdn);
    }

    public boolean estSaturee() {
        return msAttaches.size() >= nbMaxUtilisateurs;
    }

    public void afficherInfos() {
        System.out.println("============================================");
        System.out.println("BTS Numero      : " + numero);
        System.out.println("Emplacement     : " + emplacement);
        System.out.println("Type de milieu  : " + typeMilieu);
        System.out.println("Hauteur         : " + hauteur + " m");
        System.out.println("Rayon couverture: " + rayonCouverture + " km");
        System.out.println("Puissance emis. : " + puissanceEmission + " dBm");
        System.out.println("Utilisateurs    : " + msAttaches.size() + " / " + nbMaxUtilisateurs);
        System.out.println("Etat cellule    : " + (estSaturee() ? "SATURÉE" : "DISPONIBLE"));
        System.out.println("--------------------------------------------");
        if (msAttaches.isEmpty()) {
            System.out.println("  Aucun utilisateur attache.");
        } else {
            System.out.println("  Liste des utilisateurs attaches :");
            for (MS ms : msAttaches) {
                System.out.println("    - " + ms.getNom() + " " + ms.getPrenom() + " | " + ms.getMsisdn());
            }
        }
        System.out.println("============================================\n");
    }

    public ArrayList<MS> getMsAttaches() {
        return msAttaches;
    }

    public int getNbMaxUtilisateurs() {
        return nbMaxUtilisateurs;
    }

    public String getNumero() {
        return numero;
    }

    public String getTypeMilieu() {
        return typeMilieu;
    }

    public String getEmplacement() {
        return emplacement;
    }
}
