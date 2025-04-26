package fr.Entities;

/**
 * Classe de base représentant une entité avec un nom et un niveau de santé.
 * Cette classe peut être étendue pour créer des entités spécifiques comme des ennemis ou des joueurs.
 */
public class Entity {

    protected int health;

    protected String name;

    /**
     * Construit une nouvelle entité avec un nom et un niveau de santé spécifiés.
     *
     * @param name Le nom de l'entité.
     * @param health Le niveau de santé initial de l'entité.
     */
    public Entity( String name, int health){
        this.health = health;
        this.name = name;
    }

    /**
     * Récupère le niveau de santé actuel de l'entité.
     *
     * @return Le niveau de santé de l'entité.
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Définit un nouveau niveau de santé pour l'entité.
     *
     * @param h Le nouveau niveau de santé à attribuer à l'entité.
     */
    public void setHealth(int h){
        this.health = h;
    }


}
