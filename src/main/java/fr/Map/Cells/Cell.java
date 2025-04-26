package fr.Map.Cells;

import java.util.Objects;

public abstract class Cell {

    private int x;

    private int y;

    private int xGame;

    private int yGame;

    public Cell(int x, int y, int xg, int yg){
        this.x = x;
        this.y = y;
        this.xGame = xg;
        this.yGame = yg;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public int getXGamePosition() {
        return xGame;
    }

    public int getYGamePosition() {
        return yGame;
    }

    public void setPosition(Cell other) {
        this.x = other.x;
        this.y = other.y;
        this.xGame = other.xGame;
        this.yGame = other.yGame;
    }

    public void setPosition(int x, int y, int xGame, int yGame) {
        this.x = x;
        this.y = y;
        this.xGame = xGame;
        this.yGame = yGame;
    }

    public abstract String getType();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xGame == cell.xGame && yGame == cell.yGame;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xGame, yGame);
    }
}
