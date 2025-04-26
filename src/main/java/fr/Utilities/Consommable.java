package fr.Utilities;

/**
 * Classe représentant un objet consommable avec un nom, une rareté et un diminutif.
 * Les objets consommables peuvent être utilisés dans le jeu pour divers effets.
 */
public class Consommable {

    private String nomConsommale;
    private Rarete rarete;
    private String diminutif;

    /**
     * Construit un nouvel objet consommable avec un nom, une rareté et un diminutif spécifiés.
     *
     * @param nom Le nom de l'objet consommable.
     * @param rarete La rareté de l'objet consommable.
     * @param diminutif Le diminutif de l'objet consommable.
     */
    public Consommable(String nom, Rarete rarete, String diminutif) {
        this.nomConsommale = nom;
        this.rarete = rarete;
        this.diminutif = diminutif;
    }

    /**
     * Retourne le nom de l'objet consommable.
     *
     * @return Le nom de l'objet consommable.
     */
    public String getNomConsommale() {
        return nomConsommale;
    }

    /**
     * Retourne la rareté de l'objet consommable.
     *
     * @return La rareté de l'objet consommable.
     */
    public Rarete getRarete() {
        return rarete;
    }

    /**
     * Retourne le diminutif de l'objet consommable.
     *
     * @return Le diminutif de l'objet consommable.
     */
    public String getDiminutif() {
        return diminutif;
    }
}
