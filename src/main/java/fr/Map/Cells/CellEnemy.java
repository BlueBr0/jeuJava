package fr.Map.Cells;

import fr.Entities.Ennemy;

import java.util.Random;

/**
 * Classe représentant une cellule contenant un ennemi dans une grille de jeu.
 * Cette cellule associe un ennemi avec des caractéristiques aléatoires.
 */
public class CellEnemy extends Cell{

    public Ennemy zombie;

    /**
     * Construit une nouvelle cellule contenant un ennemi avec des coordonnées spécifiées dans la grille et dans le jeu.
     * Initialise également un ennemi avec des caractéristiques aléatoires.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellEnemy(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
        setRandomEnemy();
    }

    /**
     * Définit un ennemi aléatoire pour cette cellule.
     * L'ennemi est initialisé avec un nom fixe ("Zombie") et un niveau de santé aléatoire compris entre 1 et 5.
     */
    public void setRandomEnemy(){
        Random random = new Random();
        int vie = random.nextInt(5) + 1; // de 1 à 5

        this.zombie = new Ennemy("Zombie", vie);
    }

    /**
     * Retourne le type de la cellule, qui est "ENEMY".
     *
     * @return Le type de la cellule ("ENEMY").
     */
    @Override
    public String getType() {
        return "ENEMY";
    }

}
