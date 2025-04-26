package fr.Map.Cells;

/**
 * Classe représentant une cellule de type mur d'angle dans une grille de jeu.
 * Ce type de mur est généralement utilisé pour délimiter les coins d'une zone.
 */
public class CellWallCorner extends CellWall{

    /**
     * Construit une nouvelle cellule de type mur d'angle avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellWallCorner(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }


    /**
     * Retourne le type de la cellule, qui est "WALLCORNER".
     *
     * @return Le type de la cellule ("WALLCORNER").
     */
    @Override
    public String getType() {
        return "WALLCORNER";
    }
}
