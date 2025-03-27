package fr.Utilities;

import java.util.ArrayList;
import java.util.Random;

public class Consommables {

    private static ArrayList<Consommable> lesConsommables = new ArrayList<Consommable>();

    private static Consommable defaultLoot;

    public Consommables(){
        //Charger les consommables via un fichier json
    }

    public static Consommable getRandomConsommable(){
        if(!lesConsommables.isEmpty()){
            Random r = new Random();
            return lesConsommables.get(r.nextInt(lesConsommables.size()));
        }
        else{
            return defaultLoot;
        }
    }
}
