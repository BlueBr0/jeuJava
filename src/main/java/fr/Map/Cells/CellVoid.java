package fr.Map.Cells;

/**
 * Classe représentant une cellule vide dans une grille de jeu.
 * Cette cellule ne contient aucun élément interactif ou visible.
 */
public class CellVoid extends Cell{

    /**
     * Construit une nouvelle cellule vide avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellVoid(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    /**
     * Retourne le type de la cellule, qui est "VOID".
     *
     * @return Le type de la cellule ("VOID").
     */
    @Override
    public String getType() {
        return "VOID";
    }
}
