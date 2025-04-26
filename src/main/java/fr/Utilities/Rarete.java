package fr.Utilities;

/**
 * Énumération représentant les différents niveaux de rareté d'un objet.
 * Chaque niveau de rareté est associé à une chaîne de caractères descriptive.
 */
public enum Rarete {

    COMMUN("common"),
    UNCOMMUN("uncommon"),
    RARE("rare");

    private String rarete;

    /**
     * Construit un niveau de rareté avec une description spécifiée.
     *
     * @param r La description du niveau de rareté.
     */
    Rarete(String r){
        this.rarete = r;
    }

}

