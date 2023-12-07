import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Entrez votre nom : ");
        String nomJoueur = scanner.nextLine();

        // Créez un joueur avec des points de vie et de force initiaux
        Joueur joueur = new Joueur(nomJoueur, 100, 6, new ArrayList<potion>());
        potion potionVie = new potion("vie", "potion qui redonne des hp");
        potion potionForce = new potion("force", "potion qui donne de la force");
        potion potionMana = new potion("mana", "potion qui donne du mana");
        joueur.addInventaire(potionForce);

        // Liste des monstres disponibles
        List<Ennemi> monstres = new ArrayList<>();
        monstres.add(new Ennemi("Slime", 10, 2, "Slime"));
        monstres.add(new Ennemi("Demon", 50, 10, "Demon"));
        monstres.add(new Ennemi("Gobelin", 25, 5, "Gobelin"));
        monstres.add(new Ennemi("Orc", 35, 8, "Orcs"));

        Menu menu = new Menu();
        //potionVie.interagire(joueur);
        // Afficher le menu principal avant le combat
        menu.afficherMenuPrincipal(joueur, monstres, random);

        Ennemi ennemi = monstres.get(random.nextInt(monstres.size()));

        joueur.combattre(ennemi);
        // Affichez le résultat du combat
        System.out.println("Résultat du combat : ");
        System.out.println("Points de vie du joueur : " + joueur.getPointsDeVie());
        System.out.println("Points de vie de l'ennemi : " + ennemi.getPointsDeVie());

        // Ne retournez pas au menu principal dans ce cas, car vous sortez du jeu après le combat
        System.out.println("Merci d'avoir joué !");
    }
}
