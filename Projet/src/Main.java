import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> inventaire=new ArrayList<>();
        inventaire.add("potion");
        Ennemi gobelin =new Ennemi("gobelin",5,2,"bipede");
        Joueur player = new Joueur("test 1",10,5,inventaire);
        potion potion=new potion("potion de vie","redonne 3 point de vie");
        Arme epee=new Arme("Master Sword","épée du chevalier link",4,"Légendaire",1);

        // potion.interagire(player);
        // potion.utiliser();
        // System.out.println(player.getPointsDeVie()+" "+gobelin.getPointsDeVie());
        // System.out.println(epee.getDescription());
        // epee.VerrifierCasser();
        // epee.interagire(gobelin);
        // System.out.println(player.getPointsDeVie()+" "+gobelin.getPointsDeVie());
        // epee.VerrifierCasser();


    }
}