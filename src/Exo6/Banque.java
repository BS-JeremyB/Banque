package Exo6;

import java.util.HashMap;

public class Banque {

    private String nom;
    private HashMap<String, Compte> comptes = new HashMap<>();


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<String, Compte> getComptes() {
        return comptes;
    }


    public void ajouter(Compte compte){
        comptes.put(compte.getNumero(),compte);

    }

    public void supprimer(String numero){
        if(comptes.containsKey(numero)){
            comptes.remove(numero);
        }
    }

    public double avoirDesComptes(Personne p)
    {

        double avoir = 0;

        for (Compte c : comptes.values()) {
            if(c.getTitulaire().equals(p)){
                avoir = Courant.addSoldePositif(avoir, c);
            }
        }

        return avoir;
    }
}
