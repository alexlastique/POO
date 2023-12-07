package model;

public class Ennemi extends Personnage {
    private String typeDEnnemi;


    public Ennemi(String nom, int pointsDeVie, int force, String typeDEnnemi) {
        super(nom, pointsDeVie, force);
        this.typeDEnnemi = typeDEnnemi;
    }

    public String getTypeDEnnemi() {
        return typeDEnnemi;
    }


    public void actionAutoGeree(Joueur joueur) {
        joueur.pertPointDeVie(this.getForce());
        System.out.println(joueur.nom + " a perdu " + this.getForce() + " PV");
        System.out.println("Points de vie du joueur : " + joueur.getPointsDeVie());
    }
}
