package Exo9;

public interface IBanker {
    Personne getTitulaire();
    String getNumero();
    void appliquerInteret();
    void changerDevise(Devise devise);
}
