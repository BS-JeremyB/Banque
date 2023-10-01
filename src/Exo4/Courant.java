package Exo4;

public class Courant {
    public Courant(String numero, double ligneDeCredit, Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.ligneDeCredit = ligneDeCredit;
        this.titulaire = titulaire;
    }

    private String numero;
    private double solde;
    private double ligneDeCredit;
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

    public double getLigneDeCredit() {
        return ligneDeCredit;
    }

    public void setLigneDeCredit(double ligneDeCredit) {
        if(ligneDeCredit >= 0) {
            this.ligneDeCredit = ligneDeCredit;
        }
    }


    public void retrait(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        if (montant > solde + ligneDeCredit)
            return; //à remplacer plus tard par une exception

        solde -= montant;

    }

    public void depot(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        solde += montant;
    }

    public static double addSoldePositif(double solde, Courant c) {
        return solde + (c.getSolde() < 0.0 ? 0.0 : c.getSolde());
    }
}
