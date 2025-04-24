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
        lesConsommables.add(new Consommable("Petite trousse de soin", Rarete.COMMUN, "trousse"));
        lesConsommables.add(new Consommable("Boîte de conserve", Rarete.COMMUN, "conserve"));
        lesConsommables.add(new Consommable("Bouteille d'eau", Rarete.COMMUN, "eau"));

        lesConsommables.add(new Consommable("Kit médical", Rarete.UNCOMMUN, "kit"));
        lesConsommables.add(new Consommable("Boisson énergisante", Rarete.UNCOMMUN, "boisson"));
        lesConsommables.add(new Consommable("Antibiotiques", Rarete.UNCOMMUN, "antibio"));

        lesConsommables.add(new Consommable("Sérum de survie", Rarete.RARE, "serum"));
        lesConsommables.add(new Consommable("Injection d'adrénaline", Rarete.RARE, "adré"));
        lesConsommables.add(new Consommable("Ration militaire", Rarete.RARE, "ration"));
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
