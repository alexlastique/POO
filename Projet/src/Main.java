import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Liste des monstres disponibles
        List<Ennemi> monstres = new ArrayList<>();
        monstres.add(new Ennemi("Slime", 10, 2, "Slime", 10));
        monstres.add(new Ennemi("Demon", 50, 10, "Demon", 50));
        monstres.add(new Ennemi("Gobelin", 25, 5, "Gobelin", 25));
        monstres.add(new Ennemi("Orc", 35, 8, "Orcs", 35));

        potion potionVie = new potion("vie", "potion qui redonne des hp");
        potion potionForce = new potion("force", "potion qui donne de la force");
        potion potionMana = new potion("mana", "potion qui donne du mana");

        System.out.println("1. Nouvelle Partit");
        System.out.println("2. Reprendre");

        System.out.println("Choisissez une option : ");
        int choixSauvegarde = scanner.nextInt();
        scanner.nextLine();
        switch (choixSauvegarde) {
            case 1:
                System.out.println("Entrez votre nom : ");
                String nomJoueur = scanner.nextLine();

                // Créez un joueur avec des points de vie et de force initiaux
                Joueur joueur = new Joueur(nomJoueur, 100, 6, new ArrayList<potion>());
                joueur.addInventaire(potionVie);
                joueur.addInventaire(potionVie);
                joueur.addInventaire(potionForce);

                int prixPotion = 10;

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
                break;
            case 2:
                try {
                    File fichier = new File("PlayerSave");
                    FileReader fileReader = new FileReader(fichier);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String ligne;
                    ArrayList<String> lignes = new ArrayList<>();
                    while ((ligne = bufferedReader.readLine()) != null){
                        lignes.add(ligne);
                    }
                    bufferedReader.close();

                    String nomJoueurSauv = lignes.get(0);
                    String chaine = lignes.get(2);

                    String[] elements = chaine.substring(1, chaine.length() - 1).split(", ");

                    ArrayList<String> inventaireSauv = new ArrayList<>(Arrays.asList(elements));

                    ArrayList<potion> inventairefin = new ArrayList<>();
                    for (int i=0;i<inventaireSauv.size();i++){
                        if (Objects.equals(inventaireSauv.get(i), "vie")){
                            inventairefin.add(potionVie);
                        }
                        if (Objects.equals(inventaireSauv.get(i), "force")){
                            inventairefin.add(potionForce);
                        }
                        if (Objects.equals(inventaireSauv.get(i), "mana")){
                            inventairefin.add(potionMana);
                        }
                    }

                    // Créez un joueur avec des points de vie et de force initiaux
                    Joueur joueurSauv = new Joueur(nomJoueurSauv, Integer.parseInt(lignes.get(4)), Integer.parseInt(lignes.get(3)), inventairefin);
                    joueurSauv.addGold(Integer.parseInt(lignes.get(1)));

                    Menu menuSauv = new Menu();
                    //potionVie.interagire(joueur);
                    // Afficher le menu principal avant le combat
                    menuSauv.afficherMenuPrincipal(joueurSauv, monstres, random);

                    Ennemi ennemiSauv = monstres.get(random.nextInt(monstres.size()));

                    joueurSauv.combattre(ennemiSauv);
                    // Affichez le résultat du combat
                    System.out.println("Résultat du combat : ");
                    System.out.println("Points de vie du joueur : " + joueurSauv.getPointsDeVie());
                    System.out.println("Points de vie de l'ennemi : " + ennemiSauv.getPointsDeVie());

                    // Ne retournez pas au menu principal dans ce cas, car vous sortez du jeu après le combat
                    System.out.println("Merci d'avoir joué !");
                }
                catch (Exception e){
                    System.out.println("Erreur : "+e);
                }
                break;
            default:
                System.out.println("Choisir 1 ou 2");
        }
    }
}
