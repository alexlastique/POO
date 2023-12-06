package model;

public class potion extends ObjetDuJeu implements interactuable{
    public potion(String nom, String description) {
        super(nom, description);
    }

    @Override
    public void interagire(Personnage personnage) {
        personnage.gainPointDeVie(3);
        System.out.println(personnage.nom+" boit "+this.nom);
    }
    @Override
    public void utiliser(){
        System.out.println(this.nom+" est utiliser");
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
