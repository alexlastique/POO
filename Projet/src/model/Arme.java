package model;

public class Arme extends ObjetDuJeu implements interactuable {
    private float degat;
    private String rareter;

    public Arme(String nom, String description, float degat, String rareter) {
        super(nom, description);
        this.degat = degat;
        this.rareter = rareter;
    }



    @Override
    public void utiliser() {
        System.out.println(this.nom + " est utilisée");
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void interagire(Personnage personnage) {
        personnage.pertPointDeVie(this.degat);
        System.out.println(personnage.nom + " a perdu " + this.degat + " PV");
    }
}