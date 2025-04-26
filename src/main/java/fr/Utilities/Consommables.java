package fr.Utilities;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe gérant une collection d'objets consommables.
 * Elle permet de charger une liste d'objets consommables et de sélectionner un objet aléatoire parmi eux.
 */
public class Consommables {

    private static ArrayList<Consommable> lesConsommables = new ArrayList<Consommable>();

    private static Consommable defaultLoot = new Consommable("Vieille canette vide", Rarete.COMMUN, "canette");

    /**
     * Construit un nouvel objet Consommables et charge la liste des objets consommables.
     */
    public Consommables() {
        chargerConsommables();
    }

    /**
     * Charge une liste d'objets consommables avec des noms, des raretés et des diminutifs prédéfinis.
     * Les objets sont ajoutés à la liste des consommables disponibles.
     */
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

    /**
     * Retourne un objet consommable aléatoire parmi la liste des consommables disponibles.
     * Si la liste est vide, retourne un objet consommable par défaut.
     *
     * @return Un objet consommable aléatoire ou un objet par défaut si la liste est vide.
     */
    public static Consommable getRandomConsommable() {
        if (!lesConsommables.isEmpty()) {
            Random r = new Random();
            return lesConsommables.get(r.nextInt(lesConsommables.size()));
        } else {
            return defaultLoot;
        }
    }
}
