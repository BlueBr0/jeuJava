package fr.Map.Cells;

/**
 * Classe représentant une cellule de type "départ" dans une grille de jeu.
 * Cette cellule marque généralement le point de départ d'un niveau ou d'une section du jeu.
 */
public class CellStart extends Cell{

    /**
     * Construit une nouvelle cellule de type "départ" avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellStart(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    /**
     * Retourne le type de la cellule, qui est "START".
     *
     * @return Le type de la cellule ("START").
     */
    @Override
    public String getType() {
        return "START";
    }
}
