package Exo9;

public interface ICustomer {
    double getSolde();
    void depot(double Montant) throws CustomException;
    void retrait(double Montant) throws CustomException;
}
