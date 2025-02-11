package fr.Map.Cells;

public abstract class Cell {


    private int x;

    private int y;

    public Cell(int x, int y){
       this.x = x;
       this.y = y;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }


    public abstract String getType();


}
