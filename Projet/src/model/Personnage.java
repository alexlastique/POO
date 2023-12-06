package model;

public class Personnage {
    public String nom;
    private int pointsDeVie;
    private  int force;

    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }
    public void attaquer(){
        System.out.println(this.nom + " attaque");
    }
    public void defendre(){
        System.out.println(this.nom + "defend");
    }
    public int getPointsDeVie(){
        return this.pointsDeVie;
    }
    public void updatePointDeVie(int nbr){
        this.pointsDeVie=nbr;
    }

    public void pertPointDeVie(int nbr){
        this.pointsDeVie-=nbr;
    }
}
