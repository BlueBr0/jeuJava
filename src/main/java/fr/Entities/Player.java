package fr.Entities;

/**
 * Classe représentant un joueur, héritant de la classe Entity.
 * Un joueur possède un nom, un niveau de santé, et un nombre de munitions.
 */
public class Player extends Entity{

    private final int baseAmo = 10;

    private int amo;

    /**
     * Construit un nouveau joueur avec un nom et un niveau de santé spécifiés.
     * Initialise également les munitions du joueur à une valeur de base.
     *
     * @param name Le nom du joueur.
     * @param health Le niveau de santé initial du joueur.
     */
    public Player(String name, int health) {
        super(name, health);
        this.amo = baseAmo;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du joueur,
     * incluant son nom, ses points de vie (PV) et ses munitions.
     *
     * @return Une chaîne de caractères représentant l'état actuel du joueur.
     */
    @Override
    public String toString(){
        return name + "\r\nPV : " + health + "\r\nMUNITIONS : " + amo;
    }

}
