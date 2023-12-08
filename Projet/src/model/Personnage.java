package model;

import java.util.Objects;
import java.util.Scanner;

public class Personnage {
    public String nom;
    private int pointsDeVie;
    private int force;

    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }

    public void attaquer(Ennemi cible, int typeDeCoup, Joueur joueur) {
        // Le joueur peut choisir le type d'attaque
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Coup vertical");
        System.out.println("2. Coup horizontal");
        System.out.println("3. Coup d'estoc");
        System.out.println("4. Accéder au sac");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                if (typeDeCoup==2){
                    // Attaquer
                    int degatsInfliges = this.force;
                    cible.pertPointDeVie(degatsInfliges);
                    System.out.println(this.nom + " attaque " + cible.nom + " , l'ennemie perd " + degatsInfliges + " PV.");
                    System.out.println("Points de vie de l'ennemi : " + cible.getPointsDeVie());
                    break;

                } else if (typeDeCoup==1) {
                    System.out.println("Les coup s'entrechoque");
                    break;
                }
                else {
                    System.out.println(cible.nom + " part " + this.nom + " avec faciliter, "+ this.nom+" perd " + cible.getForce() + " PV.");
                    cible.actionAutoGeree(joueur);
                    break;
                }
            case 2:
                if (typeDeCoup==3){
                    // Attaquer
                    int degatsInfliges = this.force;
                    cible.pertPointDeVie(degatsInfliges);
                    System.out.println(this.nom + " attaque " + cible.nom + " , l'ennemie perd " + degatsInfliges + " PV.");
                    System.out.println("Points de vie de l'ennemi : " + cible.getPointsDeVie());
                    break;
                } else if (typeDeCoup==2) {
                    System.out.println("Les coup s'entrechoque");
                    break;
                }
                else {
                    System.out.println(cible.nom + " part " + this.nom + " avec faciliter, "+ this.nom+" perd " + cible.getForce() + " PV.");
                    cible.actionAutoGeree(joueur);
                    break;
                }
            case 3:
                if (typeDeCoup==1){
                    // Attaquer
                    int degatsInfliges = this.force;
                    cible.pertPointDeVie(degatsInfliges);
                    System.out.println(this.nom + " attaque " + cible.nom + " , l'ennemie perd " + degatsInfliges + " PV.");
                    System.out.println("Points de vie de l'ennemi : " + cible.getPointsDeVie());
                    break;
                } else if (typeDeCoup==3) {
                    System.out.println("Les coup s'entrechoque");
                    break;
                }
                else {
                    System.out.println(cible.nom + " part " + this.nom + " avec faciliter, "+ this.nom+" perd " + cible.getForce() + " PV.");
                    cible.actionAutoGeree(joueur);
                    break;
                }
            case 4:
                joueur.afficherInventaire();
                int inventaireSize = joueur.getInventaire().size();
                System.out.println("que voulez-vous utiliser entre:");
                System.out.println("1. Potion de vie");
                System.out.println("2. Potion de force");
                System.out.println("3. Potion de mana");
                System.out.println("4. Retour");
                int choixItem = scanner.nextInt();
                int potionIndex =-1;
                switch (choixItem) {
                    case 1:
                        for (int i = 0;i<inventaireSize;i++){
                            if (Objects.equals(joueur.getInventaire().get(i).nom, "vie")){
                                potionIndex = i;
                                break;
                            }
                        }
                        if (potionIndex!=-1){
                            joueur.getInventaire().get(potionIndex).interagire(joueur);
                            joueur.getInventaire().remove(potionIndex);
                        }
                        else {
                            System.out.println("Vous n'avez pas d'exemplaire de cette potion");
                        }
                        break;
                    case 2:
                        for (int i = 0;i<inventaireSize;i++){
                            if (Objects.equals(joueur.getInventaire().get(i).nom, "force")){
                                potionIndex = i;
                                break;
                            }
                        }
                        if (potionIndex!=-1){
                            joueur.getInventaire().get(potionIndex).interagire(joueur);
                            joueur.getInventaire().remove(potionIndex);
                        }
                        else {
                            System.out.println("Vous n'avez pas d'exemplaire de cette potion");
                        }
                        break;
                    case 3:
                        for (int i = 0;i<=inventaireSize;i++){
                            if (Objects.equals(joueur.getInventaire().get(i).nom, "mana")){
                                potionIndex = i;
                                break;
                            }
                        }
                        if (potionIndex!=-1){
                            joueur.getInventaire().get(potionIndex).interagire(joueur);
                            joueur.getInventaire().remove(potionIndex);
                        }
                        else {
                            System.out.println("Vous n'avez pas d'exemplaire de cette potion");
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir 1, 2 , 3 ou 4.");
                }
                break;
            default:
                System.out.println("Choix invalide. Veuillez choisir 1, 2 ou 3.");
        }
    }


    public int getForce() {
        return this.force;
    }
    public void defendre() {
        System.out.println(this.nom + " défend");
    }

    public int getPointsDeVie() {
        return this.pointsDeVie;
    }

    public void updatePointDeVie(int nbr) {
        this.pointsDeVie = nbr;
    }

    public void pertPointDeVie(float nbr) {
        // Vérifier si les points de vie seront négatifs après la soustraction
        if (this.pointsDeVie - nbr < 0) {
            this.pointsDeVie = 0; // Si oui, mettre les points de vie à zéro
        } else {
            this.pointsDeVie -= nbr;
        }
    }

    public void gainPointDeVie(int nbr) {
        this.pointsDeVie += nbr;
    }
    public void gainForce(int nbr) {
        this.force += nbr;
    }
}
