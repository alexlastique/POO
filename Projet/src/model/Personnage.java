package model;

import java.util.Scanner;

public class Personnage {
    public String nom;
    private int pointsDeVie;
    int force;

    private int forceDepart;

    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.forceDepart = force;
    }

    public void attaquer(Ennemi cible) {
        // Le joueur peut choisir d'attaquer ou de défendre
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Attaquer");
        System.out.println("2. Défendre");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                // Attaquer
                int degatsInfliges = this.force; // Vous pouvez ajuster cela selon la logique du jeu
                cible.pertPointDeVie(degatsInfliges);
                System.out.println(this.nom + " attaque " + cible.nom + " et inflige " + degatsInfliges + " points de dégâts.");
                break;
            case 2:
                // Défendre
                this.defendre();
                System.out.println(this.nom + " se défend.");
                break;
            default:
                System.out.println("Choix invalide. Veuillez choisir 1 ou 2.");
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
