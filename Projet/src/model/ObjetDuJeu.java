package model;


public class Objet {
    public String nom;
    private String description;

    public Objet(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public void utiliser(){
        System.out.println(this.nom + "est utiliser(" + this.description+")");
    }
}
