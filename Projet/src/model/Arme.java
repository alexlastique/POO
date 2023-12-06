package model;

public class Arme extends ObjetDuJeu implements interactuable{
    private int degat;
    private String rareter;
    private int durabiliter;

    public Arme(String nom, String description,int degat,String rareter,int durabiliter) {
        super(nom, description);
        this.degat=degat;
        this.rareter=rareter;
        this.durabiliter=durabiliter;
    }


    public void VerrifierCasser(){
        if (this.durabiliter<=0){
            System.out.println(this.nom + " a casser");
        }
        else {
            System.out.println(this.nom + " pas casser");
        }
    }
    public void pertDurabiliter(){
        this.durabiliter-=1;
    }

    @Override
    public void utiliser() {
        System.out.println(this.nom+" est utiliser");
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void interagire(Personnage personnage) {
        personnage.pertPointDeVie(this.degat);
        this.durabiliter-=1;
        System.out.println(personnage.nom+" a perdu "+this.degat+" PV");
    }
}
