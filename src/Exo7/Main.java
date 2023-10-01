package Exo7;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        //EXO2 Test

        //Création d'une banque
        Banque banque = new Banque();
        banque.setNom("TechnoBanque");

        //Création de personnes
        Personne client1 = new Personne("Bazin","Jérémy", LocalDate.of(1990,6,19));
        Personne client2 = new Personne("Miler","Jean-Christophe", LocalDate.of(1984,7,22));

        //Création de comptes
        Courant compte1 = new Courant("BE00001",1000,client1);
        Courant compte2 = new Courant("BE00002",500,client2);

        //Utilisation de la Méthode "ajouter" à la banque
        banque.ajouter(compte1);
        banque.ajouter(compte2);

        //Utilisation de la Méthode "depot"
        compte1.depot(500);
        compte2.depot(1500);


        //Utilisation de la Méthode "retrait"
        compte1.retrait(300);
        compte2.retrait(900);

        //Mise en forme et affichage des information des comptes

        banque.getComptes().forEach((key,value)->{

            System.out.println(value.getTitulaire().getNom()+" "+value.getTitulaire().getPrenom()+"\n" +
                    "Compte : " + key+"\n" +
                    "Solde : " + value.getSolde() );

            System.out.println("\n---------------------\n");
        });

        // EXO 3 TEST

        //Ajout d'un nouveau compte ave un titulaire existant déjà
        Courant compte3 = new Courant("BE00003",500,client1);

        //Utilisation de la Méthode "depot"
        compte3.depot(2000);

        //Ajout du compte à la banque
        banque.ajouter(compte3);

        //EXO 5 TEST

        //Création d'un compte "Epargne"
        Epargne epargne1 = new Epargne("BE0001E", client2);

        // Ajout du compte epargne à la banque
        banque.ajouter(epargne1);

        //Utilisation de la Méthode "depot" via "Banque"
        banque.getComptes().get(epargne1.getNumero()).depot(100);
        //Utilisation de la Méthode "retrait" via "Banque"
        banque.getComptes().get(epargne1.getNumero()).retrait(50);
        //Depuis ma banque je recupere le compte qui possèle clé égale au numero du compte
        // que je passe comme valeur, sur le compte récupéré je fais un depot/retrait


        // Définition du variable personne pour les tests
        Personne clientATester = client1;

        //Utilisation de la Méthode "avoirDesComptes"
        double totalAvoir = banque.avoirDesComptes(clientATester);

        //Mise en forme et affichage du total des avoirs d'un client
        System.out.println(clientATester.getNom()+" "+clientATester.getPrenom()+"\n" +
                           "---------------------");

        banque.getComptes().forEach((key,value)->{
            if(value.getTitulaire().equals(clientATester)){

                if (value instanceof Epargne){
                    System.out.println("Compte : " + key+" | Dernier retrait : "+ ((Epargne) value).getDateDernierRetrait()+"");
                }
                else{
                    System.out.println( "Compte : " + key+"");
                }
            }
        });

        System.out.println("---------------------\n" +
                           "Total des avoirs avant interets: "+ totalAvoir);

        //EXO 6 TEST

        //Appliquer les intérêts

        for(Compte c : banque.getComptes().values()){
            c.appliquerInteret();
        }

        //Re-calculer les avoirs
        totalAvoir = banque.avoirDesComptes(clientATester);

        System.out.println("---------------------\n" +
                "Total des avoirs apres interets: "+ totalAvoir);


        //EXO 7 TEST

        IBanker banker = compte1;
        ICustomer customer = compte2;

    }
}
