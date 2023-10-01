package Exo8;

public interface IBanker {
    Personne getTitulaire();
    String getNumero();
    void appliquerInteret();
    void changerDevise(Devise devise);
}
