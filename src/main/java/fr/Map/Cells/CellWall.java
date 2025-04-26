package fr.Map.Cells;

/**
 * Classe abstraite représentant une cellule de type mur dans une grille de jeu.
 * Les murs peuvent avoir différentes formes ou types, définis par les sous-classes.
 */
public abstract class CellWall extends Cell{

    /**
     * Construit une nouvelle cellule de type mur avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellWall(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }


}


