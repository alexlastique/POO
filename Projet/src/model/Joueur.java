package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur extends Personnage {

    private int gold;
    private ArrayList<potion> inventaire = new ArrayList<>();

    public Joueur(String nom, int pointsDeVie, int force, ArrayList<potion> inventaire) {
        super(nom, pointsDeVie, force);
        this.inventaire = inventaire;
    }

    public void addInventaire(potion object) {
        this.inventaire.add(object);
    }

    public ArrayList<potion> getInventaire() {
        return this.inventaire;
    }

    public void combattre(Ennemi ennemi) {
        System.out.println("Combat contre " + ennemi.getTypeDEnnemi() + " commence !");

        while (this.getPointsDeVie() > 0 && ennemi.getPointsDeVie() > 0) {
            // Tour du joueur

            Random typeDeCoup = new Random();

            // Génération d'un nombre aléatoire entre 0 et 2
            int nombreAleatoire = typeDeCoup.nextInt(3);

            this.attaquer(ennemi,nombreAleatoire+1,this);
            if (ennemi.getPointsDeVie() <= 0) {
                break; // Si l'ennemi est vaincu, sortir de la boucle
            }
        }

        if (this.getPointsDeVie() <= 0) {
            System.out.println("Vous avez perdu le combat contre " + ennemi.getTypeDEnnemi() + ". Retour au menu principal.");
            System.exit(0); // Ajout de cette ligne pour arrêter le jeu en cas de défaite
        } else {
            this.addGold(ennemi.getGold());
            System.out.println("Vous avez vaincu " + ennemi.getTypeDEnnemi() + "! Vous gagnez " + this.gold + "G");
            System.out.println("Votre solde est désormais de "+this.gold + "G");
        }

        // Afficher les points de vie à la fin du combat
        System.out.println("Points de vie du joueur : " + this.getPointsDeVie());
        System.out.println("Points de vie de l'ennemi : " + ennemi.getPointsDeVie());
    }

    public void acheterObjet(ObjetDuJeu objet) {
        // Ajoutez ici la logique pour acheter un objet
    }

    public void afficherInventaire() {
        System.out.println("Inventaire du joueur : ");
        int tailleInventaire = inventaire.size();
        for (int i=0;i<tailleInventaire;i++){
            System.out.println(inventaire.get(i).nom);
        }
    }

    public String getNom() {
        return this.nom;
    }

    public int getGold() {
        return this.gold;
    }

    public void addGold(int nbr) {
        this.gold += nbr;
    }

    public int removeGold(int nbr) {
        // Assurez-vous que le joueur a suffisamment d'or avant de retirer
        if (nbr > 0 && nbr <= this.gold) {
            this.gold -= nbr;
            return nbr;
        } else {
            this.gold=0;
            return 0;
        }
    }
}
