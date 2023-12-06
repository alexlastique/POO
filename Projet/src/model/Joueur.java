package model;

import java.util.ArrayList;

public class Joueur extends Personnage{
    private ArrayList<String> inventaire= new ArrayList<>();
    public Joueur(String nom, int pointsDeVie, int force, ArrayList<String> inventaire) {
        super(nom, pointsDeVie, force);
        this.inventaire = inventaire;
    }
    public void addInventaire(String object){
        this.inventaire.add(object);
    }
    public ArrayList<String> getInventaire(){
        return this.inventaire;
    }
}
