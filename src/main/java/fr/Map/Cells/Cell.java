package fr.Map.Cells;

import java.util.Objects;

/**
 * Classe abstraite représentant une cellule dans une grille de jeu.
 * Chaque cellule possède des coordonnées dans la grille et dans le jeu,
 * et peut être de différents types définis par les sous-classes.
 */
public abstract class Cell {

    private int x;

    private int y;

    private int xGame;

    private int yGame;

    /**
     * Construit une nouvelle cellule avec des coordonnées spécifiées dans la grille et dans le jeu.
     *
     * @param x La coordonnée x de la cellule dans la grille.
     * @param y La coordonnée y de la cellule dans la grille.
     * @param xg La coordonnée x de la cellule dans le jeu.
     * @param yg La coordonnée y de la cellule dans le jeu.
     */
    public Cell(int x, int y, int xg, int yg){
        this.x = x;
        this.y = y;
        this.xGame = xg;
        this.yGame = yg;
    }

    /**
     * Récupère la coordonnée x de la cellule dans la grille.
     *
     * @return La coordonnée x de la cellule.
     */
    public int getXPosition() {
        return x;
    }

    /**
     * Récupère la coordonnée y de la cellule dans la grille.
     *
     * @return La coordonnée y de la cellule.
     */
    public int getYPosition() {
        return y;
    }

    /**
     * Récupère la coordonnée x de la cellule dans le jeu.
     *
     * @return La coordonnée x de la cellule dans le jeu.
     */
    public int getXGamePosition() {
        return xGame;
    }

    /**

     * Récupère la coordonnée y de la cellule dans le jeu.
     *
     * @return La coordonnée y de la cellule dans le jeu.
     */
    public int getYGamePosition() {
        return yGame;
    }

    /**
     * Définit la position de la cellule en copiant les coordonnées d'une autre cellule.
     *
     * @param other La cellule dont les coordonnées doivent être copiées.
     */
    public void setPosition(Cell other) {
        this.x = other.x;
        this.y = other.y;
        this.xGame = other.xGame;
        this.yGame = other.yGame;
    }

    /**
     * Définit la position de la cellule avec des coordonnées spécifiées.
     *
     * @param x La nouvelle coordonnée x de la cellule dans la grille.
     * @param y La nouvelle coordonnée y de la cellule dans la grille.
     * @param xGame La nouvelle coordonnée x de la cellule dans le jeu.
     * @param yGame La nouvelle coordonnée y de la cellule dans le jeu.
     */
    public void setPosition(int x, int y, int xGame, int yGame) {
        this.x = x;
        this.y = y;
        this.xGame = xGame;
        this.yGame = yGame;
    }

    /**
     * Retourne le type de la cellule sous forme de chaîne de caractères.
     * Cette méthode doit être implémentée par les sous-classes.
     *
     * @return Le type de la cellule.
     */
    public abstract String getType();

    /**
     * Vérifie si cette cellule est égale à un autre objet.
     * Deux cellules sont considérées égales si elles ont les mêmes coordonnées dans le jeu.
     *
     * @param o L'objet à comparer avec cette cellule.
     * @return true si les cellules sont égales, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xGame == cell.xGame && yGame == cell.yGame;
    }

    /**
     * Retourne une valeur de hachage pour la cellule basée sur ses coordonnées dans le jeu.
     *
     * @return La valeur de hachage de la cellule.
     */
    @Override
    public int hashCode() {
        return Objects.hash(xGame, yGame);
    }
}
