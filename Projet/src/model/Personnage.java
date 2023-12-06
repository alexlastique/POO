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
    public void attaquer(Ennemi cible){
        System.out.println(this.nom + " attaque "+cible.nom);
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
    public void gainPointDeVie(int nbr){
        this.pointsDeVie+=nbr;
    }
}
