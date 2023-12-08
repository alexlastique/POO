package model;


public abstract class ObjetDuJeu {
    public String nom;
    public String description;

    public ObjetDuJeu(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    abstract void utiliser();
    abstract String getDescription();
}
