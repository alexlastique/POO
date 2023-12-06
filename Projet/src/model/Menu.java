package model;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal(Joueur joueur) {
        System.out.println("1. Créer un personnage");
        System.out.println("2. Acheter des objets");
        System.out.println("3. Quitter");

        int choix = obtenirChoixUtilisateur();

        switch (choix) {
            case 1:
                creerPersonnage(joueur);
                break;
            case 2:
                // Logique pour acheter des objets
                break;
            case 3:
                System.out.println("Merci d'avoir joué. Au revoir !");
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                afficherMenuPrincipal(joueur);
        }
    }

    public void creerPersonnage(Joueur joueur) {
        System.out.println("Création d'un nouveau personnage :");

        System.out.print("Nom du personnage : ");
        String nom = scanner.next();

        System.out.print("Points de vie du personnage : ");
        int pointsDeVie = scanner.nextInt();

        System.out.print("Force du personnage : ");
        int force = scanner.nextInt();

        Personnage nouveauPersonnage = new Personnage(nom, pointsDeVie, force);
        joueur.addInventaire(nouveauPersonnage.toString());

        System.out.println("Personnage créé avec succès !");
    }


    private int obtenirChoixUtilisateur() {
        System.out.print("Veuillez choisir une option : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez saisir un nombre.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
