package model;

public class potion extends ObjetDuJeu implements interactuable {
    public potion(String nom, String description) {
        super(nom, description);
    }

    @Override
    public void interagire(Personnage personnage) {
        System.out.println(personnage.nom+" boit une potion de "+this.nom);
        if (this.nom == "vie"){
            personnage.gainPointDeVie(3);
        } else if (this.nom == "force") {
            personnage.gainForce(3);
        }
    }

    @Override
    public void utiliser() {
        System.out.println(this.nom + " est utilisée");
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
