package model;

public class Ennemi extends Personnage{
    private String typeDEnnemi;
    public Ennemi(String nom, int pointsDeVie, int force, String typeDEnnemi) {
        super(nom, pointsDeVie, force);
        this.typeDEnnemi=typeDEnnemi;
    }
    public String getTypeDEnnemi(){
        return typeDEnnemi;
    }
}