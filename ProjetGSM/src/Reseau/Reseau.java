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

public class Reseau {
 
    private String nom;
    private double frequenceUplink;
    private double frequenceDownlink;
    private String typeAccesMultiple;
    private double debitMaxUplink;
    private double debitMaxDownlink;
    private double delaiMax;
    private ArrayList<BTS> listeBTS;

    public Reseau(String nom, double frequenceUplink, double frequenceDownlink,
                  String typeAccesMultiple, double debitMaxUplink,
                  double debitMaxDownlink, double delaiMax) {
        this.nom = nom;
        this.frequenceUplink = frequenceUplink;
        this.frequenceDownlink = frequenceDownlink;
        this.typeAccesMultiple = typeAccesMultiple;
        this.debitMaxUplink = debitMaxUplink;
        this.debitMaxDownlink = debitMaxDownlink;
        this.delaiMax = delaiMax;
        this.listeBTS = new ArrayList<>();
    }

    public void ajouterBTS(BTS bts) {
        if (bts != null) {
            listeBTS.add(bts);
            System.out.println("RESEAU " + nom + " : BTS " + bts.getNumero() + " ajoutee.");
        } else {
            System.out.println("ERREUR : Impossible d'ajouter une BTS nulle.");
        }
    }

    public boolean supprimerBTS(String numero) {
        for (int i = 0; i < listeBTS.size(); i++) {
            if (listeBTS.get(i).getNumero().equals(numero)) {
                listeBTS.remove(i);
                System.out.println("RESEAU " + nom + " : BTS " + numero + " supprimee.");
                return true;
            }
        }
        System.out.println("RESEAU " + nom + " : BTS " + numero + " introuvable.");
        return false;
    }

    public BTS rechercherBTS(String numero) throws MSIntrouvableException {
        for (BTS bts : listeBTS) {
            if (bts.getNumero().equals(numero)) {
                System.out.println("RESEAU " + nom + " : BTS " + numero + " trouvee.");
                return bts;
            }
        }
        throw new MSIntrouvableException("BTS " + numero + " introuvable dans le reseau " + nom);
    }

    public int calculerNombreBTSParMilieu(String typeMilieu) {
        int compteur = 0;
        for (BTS bts : listeBTS) {
            if (bts.getTypeMilieu().equalsIgnoreCase(typeMilieu)) {
                compteur++;
            }
        }
        return compteur;
    }

    public int calculerNombreAbonnesInscrits() {
        int total = 0;
        for (BTS bts : listeBTS) {
            total += bts.getMsAttaches().size();
        }
        return total;
    }

    public BTS rechercherLocalisationUtilisateur(String msisdn) {
        for (BTS bts : listeBTS) {
            try {
                MS msTrouve = bts.rechercherMS(msisdn);
                if (msTrouve != null) {
                    System.out.println("UTILISATEUR " + msisdn + " localise dans BTS " + bts.getNumero());
                    return bts;
                }
            } catch (MSIntrouvableException e) {
                // On continue
            }
        }
        System.out.println("UTILISATEUR " + msisdn + " introuvable sur le reseau " + nom);
        return null;
    }

    public void afficherPerformances() {
        System.out.println("============================================");
        System.out.println("  PERFORMANCES DU RESEAU " + nom);
        System.out.println("============================================");
        System.out.println("Bande Uplink        : " + frequenceUplink + " MHz");
        System.out.println("Bande Downlink      : " + frequenceDownlink + " MHz");
        System.out.println("Acces multiple      : " + typeAccesMultiple);
        System.out.println("Debit max Uplink    : " + debitMaxUplink + " Mbps");
        System.out.println("Debit max Downlink  : " + debitMaxDownlink + " Mbps");
        System.out.println("Delai max           : " + delaiMax + " ms");
        System.out.println("--------------------------------------------");
        System.out.println("Nombre total de BTS : " + listeBTS.size());
        System.out.println("BTS en zone urbaine : " + calculerNombreBTSParMilieu("urbain"));
        System.out.println("BTS en zone rurale  : " + calculerNombreBTSParMilieu("rural"));
        System.out.println("Abonnes inscrits    : " + calculerNombreAbonnesInscrits());
        System.out.println("============================================\n");
    }

    public ArrayList<BTS> getListeBTS() {
        return listeBTS;
    }

    public String getNom() {
        return nom;
    }
}
