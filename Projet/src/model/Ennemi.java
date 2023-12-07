package model;

public class Ennemi extends Personnage {
    private String typeDEnnemi;
    private ObjetDuJeu objet;

    public Ennemi(String nom, int pointsDeVie, int force, String typeDEnnemi, ObjetDuJeu objet) {
        super(nom, pointsDeVie, force);
        this.typeDEnnemi = typeDEnnemi;
        this.objet = objet;
    }

    public String getTypeDEnnemi() {
        return typeDEnnemi;
    }

    public ObjetDuJeu getObjet() {
        return objet;
    }

    public void actionAutoGeree(Joueur joueur) {
        joueur.pertPointDeVie(this.force);
        System.out.println(joueur.nom + " a perdu " + this.force + " PV");
    }
}
