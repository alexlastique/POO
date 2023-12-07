package model;
import java.util.*;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenuPrincipal(Joueur joueur, List<Ennemi> monstres, Random random) {
        while (true) {
            System.out.println("\n=== Menu Principal ===        "+joueur.getGold()+"G");
            System.out.println("1. Combattre un ennemi");
            System.out.println("2. Acheter un objet");
            System.out.println("3. Afficher l'inventaire");
            System.out.println("4. Quitter");

            System.out.println("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme le caractère de fin de ligne

            switch (choix) {
                case 1:
                    for (int i = 0; i<50; i++){
                        System.out.println();
                    }
                    // Choisissez un ennemi aléatoire
                    Ennemi ennemi = monstres.get(random.nextInt(monstres.size()));
                    joueur.combattre(ennemi);
                    break;
                case 2:
                    for (int i = 0; i<50; i++){
                        System.out.println();
                    }
                    potion potionVie = new potion("vie", "potion qui redonne des hp");
                    potion potionForce = new potion("force", "potion qui donne de la force");
                    potion potionMana = new potion("mana", "potion qui donne du mana");
                    int achat = joueur.removeGold(50);
                    System.out.println("Que voulez-vous acheter entre:");
                    System.out.println("1. Potion de vie");
                    System.out.println("2. Potion de force");
                    System.out.println("3. Potion de mana");
                    System.out.println("4. Retour");
                    int choixItem = scanner.nextInt();
                    switch (choixItem) {
                        case 1:
                            if (achat!=0){
                                System.out.println("Le joueur perd "+achat+" G");
                                joueur.getInventaire().add(potionVie);
                            }
                            else {
                                System.out.println("Le joueur n'a pas assez de G.");
                            }
                            break;
                        case 2:
                            if (achat!=0){
                                System.out.println("Le joueur perd "+achat+" G");
                                joueur.getInventaire().add(potionForce);
                            }
                            else {
                                System.out.println("Le joueur n'a pas assez de G.");
                            }
                            break;
                        case 3:
                            if (achat!=0){
                                System.out.println("Le joueur perd "+achat+" G");
                                joueur.getInventaire().add(potionMana);
                            }
                            else {
                                System.out.println("Le joueur n'a pas assez de G.");
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Choix invalide. Veuillez choisir 1, 2 , 3 ou 4.");
                    }
                    break;
                case 3:
                    for (int i = 0; i<50; i++){
                        System.out.println();
                    }
                    // Affichez l'inventaire du joueur
                    joueur.afficherInventaire();
                    break;
                case 4:
                    for (int i = 0; i<50; i++){
                        System.out.println();
                    }
                    // Quittez le jeu
                    System.out.println("Merci d'avoir joué !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }
}