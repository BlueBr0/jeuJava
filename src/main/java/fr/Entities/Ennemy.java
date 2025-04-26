package fr.Entities;

/**
 * Classe représentant un ennemi, héritant de la classe Entity.
 * Un ennemi possède un nom et un niveau de santé, et peut avoir des comportements spécifiques définis dans cette
 * classe ou ses sous-classes.
 */
public class Ennemy extends Entity{

    /**
     * Construit un nouvel ennemi avec un nom et un niveau de santé spécifiés.
     *
     * @param name Le nom de l'ennemi.
     * @param health Le niveau de santé initial de l'ennemi.
     */
    public Ennemy(String name, int health) {
        super(name, health);
    }


}
