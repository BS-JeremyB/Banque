package Exo7;


public abstract class Compte implements IBanker, ICustomer{
    public Compte(String numero , Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.titulaire = titulaire;
    }

    private String numero;
    private double solde;
    private Personne titulaire;



    public String getNumero() {return numero; }

    public void setNumero(String numero) {this.numero = numero; }

    public double getSolde() {
        return solde;
    }

    public Personne getTitulaire() {return titulaire; }

    public void setTitulaire(Personne titulaire) { this.titulaire = titulaire; }


    public static double addSoldePositif(double solde, Compte c) {
        return solde + (c.getSolde() < 0.0 ? 0.0 : c.getSolde());
    }

    protected abstract double CalculInteret();

    public void retrait(double montant, double ligneDeCredit){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        if (montant > solde + ligneDeCredit)
            return; //à remplacer plus tard par une exception

        solde -= montant;

    }

    @Override
    public void retrait(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        if (montant > solde)
            return; //à remplacer plus tard par une exception

        solde -= montant;

    }

    @Override
    public void depot(double montant){
        if (montant <= 0)
            return; //à remplacer plus tard par une exception

        solde += montant;
    }

    @Override
    public void appliquerInteret()
    {
        solde += CalculInteret();
    }



}
