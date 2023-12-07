package model;

public class Ennemi extends Personnage {
    private String typeDEnnemi;

    private int gold;

    public Ennemi(String nom, int pointsDeVie, int force, String typeDEnnemi, int gold) {
        super(nom, pointsDeVie, force);
        this.typeDEnnemi = typeDEnnemi;
        this.gold = gold;
    }

    public String getTypeDEnnemi() {
        return typeDEnnemi;
    }


    public void actionAutoGeree(Joueur joueur) {
        joueur.pertPointDeVie(this.getForce());
        System.out.println("Points de vie du joueur : " + joueur.getPointsDeVie());
    }
    public int getGold() {
        return this.gold;
    }
}
