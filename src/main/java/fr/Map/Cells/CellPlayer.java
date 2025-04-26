package fr.Map.Cells;

/**
 * Classe représentant une cellule contenant un joueur dans une grille de jeu.
 * Cette cellule marque la position du joueur sur la carte.
 */
public class CellPlayer extends Cell{

    /**
     * Construit une nouvelle cellule contenant un joueur avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public CellPlayer(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    /**
     * Retourne le type de la cellule, qui est "PLAYER".
     *
     * @return Le type de la cellule ("PLAYER").
     */
    @Override
    public String getType() {
        return "PLAYER";

    }

}
