package fr.Map.Cells;

import fr.Utilities.Loot;

/**
 * Classe représentant une cellule contenant un objet de butin (loot) dans une grille de jeu.
 * Cette cellule est associée à un objet de butin qui peut être récupéré par le joueur.
 */
public class CellLoot extends Cell{

    private Loot loot;

    /**
     * Construit une nouvelle cellule contenant un objet de butin avec des coordonnées spécifiées dans la grille et
     * dans le jeu.
     * Initialise également un objet de butin.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellLoot(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
        this.loot = new Loot();
    }

    /**
     * Retourne le type de la cellule, qui est "LOOT".
     *
     * @return Le type de la cellule ("LOOT").
     */
    @Override
    public String getType() {
        return "LOOT";
    }
}
