package model;

public class Arme {
    public String nom;
    private int degat;
    private String rareter;
    private int durabiliter;

    public Arme(String nom, int degat, String rareter, int durabiliter) {
        this.nom = nom;
        this.degat = degat;
        this.rareter = rareter;
        this.durabiliter = durabiliter;
    }
    public void VerrifierCasser(){
        if (this.durabiliter<=0){
            System.out.println(this.nom + " a casser");
        }
        else {
            System.out.println(this.nom + " pas casser");
        }
    }
}
