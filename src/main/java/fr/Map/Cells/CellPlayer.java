package fr.Map.Cells;

public class CellPlayer extends Cell{

    public CellPlayer(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }
    @Override
    public String getType() {
        return "PLAYER";

    }

}
