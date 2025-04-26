package fr;

/**
 * Classe représentant une zone dans le jeu.
 * Chaque zone possède une description, un état de verrouillage, et peut déverrouiller une autre zone.
 */
public class Zone {

    public String description;
    public Zone unlocks;

    private boolean isLoocked;

    /**
     * Construit une nouvelle zone avec une description et un état de verrouillage spécifiés.
     *
     * @param description La description de la zone.
     * @param b L'état de verrouillage de la zone (true si verrouillée, false sinon).
     */
    public Zone(String description, boolean b) {
        this.description = description;
        this.isLoocked = b;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la zone, qui est sa description.
     *
     * @return La description de la zone.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Vérifie si la zone est verrouillée.
     *
     * @return true si la zone est verrouillée, false sinon.
     */
    public boolean isLoocked(){
        return this.isLoocked;
    }

    /**
     * Définit la zone que cette zone déverrouille.
     *
     * @param u La zone qui sera déverrouillée par cette zone.
     */
    public void setUnlocks(Zone u ){
        this.unlocks = u;
    }

//    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
//        sorties.put(sortie.name(), zoneVoisine);
//    }
//
//    public String nomImage() {
//        return nomImage;
//    }
//
//    public String toString() {
//        return description;
//    }
//
//    public String descriptionLongue()  {
//        return "Vous êtes dans " + description + "\nSorties : " + sorties();
//    }
//
//    private String sorties() {
//        return sorties.keySet().toString();
//    }
//
//    public Zone obtientSortie(String direction) {
//    	return sorties.get(direction);
//    }
}

