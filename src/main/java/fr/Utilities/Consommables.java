package fr.Utilities;

import java.util.ArrayList;
import java.util.Random;

public class Consommables {

    private static ArrayList<Consommable> lesConsommables = new ArrayList<Consommable>();

    private static Consommable defaultLoot = new Consommable("Vieille canette vide", Rarete.COMMUN, "canette");

    public Consommables() {
        chargerConsommables();
    }

    private void chargerConsommables() {
        lesConsommables.add(new Consommable("Petite trousse de soin", Rarete.COMMUN, "TS"));
        lesConsommables.add(new Consommable("Boîte de conserve", Rarete.COMMUN, "BC"));
        lesConsommables.add(new Consommable("Bouteille d'eau", Rarete.COMMUN, "BE"));

        lesConsommables.add(new Consommable("Kit médical", Rarete.UNCOMMUN, "KIT"));
        lesConsommables.add(new Consommable("Boisson énergisante", Rarete.UNCOMMUN, "BEN"));
        lesConsommables.add(new Consommable("Antibiotiques", Rarete.UNCOMMUN, "AN"));

        lesConsommables.add(new Consommable("Balles", Rarete.RARE, "AMO"));
        lesConsommables.add(new Consommable("Injection d'adrénaline", Rarete.RARE, "AD"));
        lesConsommables.add(new Consommable("Ration militaire", Rarete.RARE, "RA"));
    }

    public static Consommable getRandomConsommable() {
        if (!lesConsommables.isEmpty()) {
            Random r = new Random();
            return lesConsommables.get(r.nextInt(lesConsommables.size()));
        } else {
            return defaultLoot;
        }
    }
}
