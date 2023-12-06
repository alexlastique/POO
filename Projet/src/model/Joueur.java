package model;

import java.util.ArrayList;

public class Joueur extends Personnage{
    private ArrayList inventaire;
    public Joueur(String nom, int pointsDeVie, int force, ArrayList inventaire) {
        super(nom, pointsDeVie, force);
        this.inventaire = inventaire;
    }
    public void addInventaire(String object){
        this.inventaire.add(object);
    }
}
