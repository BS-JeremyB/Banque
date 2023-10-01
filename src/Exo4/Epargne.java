package Exo4;

import java.time.LocalDate;


public class Epargne {
    public Epargne(String numero, LocalDate dateDernierRetrait , Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.dateDernierRetrait  = dateDernierRetrait ;
        this.titulaire = titulaire;
    }

    private String numero;
    private double solde;
    private LocalDate dateDernierRetrait ;
    private Personne titulaire;


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {return titulaire; }

    public void setTitulaire(Personne titulaire) { this.titulaire = titulaire; }

    public LocalDate getDateDernierRetrait() {
        return dateDernierRetrait ;
    }

    public void setDateDernierRetrait(LocalDate dateDernierRetrait ) {
            this.dateDernierRetrait  = dateDernierRetrait ;
    }


    public void retrait(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        if (montant > solde)
            return; //à remplacer plus tard par une exception

        solde -= montant;

    }

    public void depot(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        solde += montant;
    }

    public static double addSoldePositif(double solde, Epargne e) {
        return solde + (e.getSolde() < 0.0 ? 0.0 : e.getSolde());
    }
}
