package fr.Utilities;

import java.util.ArrayList;
import java.util.Random;

public class Loot {

    private ArrayList<Consommable> loot = new ArrayList<Consommable>();

    public Loot(){
        Random r = new Random();
        for(int i = 0; i < r.nextInt(3);i++){
            Consommable c = Consommables.getRandomConsommable();
            loot.add(c);
        }
    }
}
