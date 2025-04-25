package fr.Map.Cells;

public class CellStart extends Cell{

    public CellStart(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    @Override
    public String getType() {
        return "START";
    }
}
