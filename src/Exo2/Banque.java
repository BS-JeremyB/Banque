package Exo2;

import java.util.HashMap;

public class Banque {

    private String nom;
    private HashMap<String, Courant> comptes = new HashMap<>();


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<String, Courant> getComptes() {
        return comptes;
    }


    public void ajouter(Courant compte){
        comptes.put(compte.getNumero(),compte);

    }

    public void supprimer(String numero){
        if(comptes.containsKey(numero)){
            comptes.remove(numero);
        }
    }
}
