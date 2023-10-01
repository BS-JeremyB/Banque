package Exo9;


public abstract class Compte implements IBanker, ICustomer {
    public Compte(String numero , Personne titulaire) {
        this.numero = numero;
        this.solde = 0;
        this.titulaire = titulaire;
    }

    private String numero;
    private double solde;
    private Personne titulaire;

    private Devise devise = Devise.EURO;

    public Devise getDevise() {return devise; }

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

    public void retrait(double montant, double ligneDeCredit) throws CustomException {
        if (montant <= 0)
            throw new CustomException("Le montant doit être supérieur à 0");
        if (montant > solde + ligneDeCredit)
            throw new CustomException("Le montant dépasse la limite de retrait autorisé");

        solde -= montant;

    }

    @Override
    public void retrait(double montant) throws CustomException {
        if (montant <= 0)
            throw new CustomException("Le montant doit être supérieur à 0");

        if (montant > solde)
            throw new CustomException("Le montant dépasse la limite de retrait autorisé");

        solde -= montant;

    }

    @Override
    public void depot(double montant) throws CustomException {
        if (montant <= 0)
            throw new CustomException("Le montant doit être supérieur à 0");

        solde += montant;
    }

    @Override
    public void appliquerInteret()
    {
        solde += CalculInteret();
    }

    @Override
    public void changerDevise(Devise devise){

        try {
            //Verifie si la devise fait partie de l'énumération
            Devise.valueOf(devise.name());

            //Si la nouvelle devise est égale à celle déjà utilisé
            if(this.devise.equals(devise))
                throw new CustomException("La devise ne peut être la même que celle acutellement utilisé");

            this.devise = devise;
            solde = Devise.EURO.equals(devise) ? solde * .94 : solde * 1.06 ;


        } catch (IllegalArgumentException e) {

            System.out.println("La devise n'est pas valide.");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }
}


