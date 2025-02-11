package fr.Map.Cells;

public class CellPlayer extends Cell{

    public CellPlayer(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "PLAYER";

    }

}
