package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal(Joueur joueur, List<Ennemi> monstres, Random random) {
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Combattre un ennemi");
            System.out.println("2. Acheter un objet");
            System.out.println("3. Afficher l'inventaire");
            System.out.println("4. Quitter");

            System.out.println("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme le caractère de fin de ligne

            switch (choix) {
                case 1:
                    // Choisissez un ennemi aléatoire
                    Ennemi ennemi = monstres.get(random.nextInt(monstres.size()));
                    joueur.combattre(ennemi);
                    break;
                case 2:
                    // Implémentez la logique pour acheter un objet
                    break;
                case 3:
                    // Affichez l'inventaire du joueur
                    joueur.afficherInventaire();
                    break;
                case 4:
                    // Quittez le jeu
                    System.out.println("Merci d'avoir joué !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }
}