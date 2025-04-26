package fr.Map.Cells;

/**
 * Classe représentant une cellule de type mur inférieur dans une grille de jeu.
 * Ce type de mur est généralement utilisé pour délimiter les bords inférieurs d'une zone.
 */
public class CellWallBottom extends CellWall{

    /**
     * Construit une nouvelle cellule de type mur inférieur avec des coordonnées spécifiées dans la grille et dans
     * le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellWallBottom(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    /**
     * Retourne le type de la cellule, qui est "WALLBOTTOM".
     *
     * @return Le type de la cellule ("WALLBOTTOM").
     */
    @Override
    public String getType() {
        return "WALLBOTTOM";
    }
}
