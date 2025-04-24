package fr.Utilities;

import java.util.ArrayList;
import java.util.Random;

public class Loot {

    private ArrayList<Consommable> loot = new ArrayList<Consommable>();

    public Loot(){
        Consommable c = Consommables.getRandomConsommable();
        loot.add(c);
    }
}
