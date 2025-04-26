package fr.Utilities;

import java.util.ArrayList;

/**
 * Classe représentant un objet de butin, contenant une liste d'objets consommables.
 * Lors de sa création, un objet consommable aléatoire est ajouté à la liste.
 */
public class Loot {

    private ArrayList<Consommable> loot = new ArrayList<Consommable>();

    /**
     * Construit un nouvel objet de butin en ajoutant un objet consommable aléatoire à la liste.
     */
    public Loot(){
        Consommable c = Consommables.getRandomConsommable();
        loot.add(c);
    }
}
