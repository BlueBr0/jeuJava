package fr.Map.Cells;

public class CellStart extends Cell{

    public CellStart(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "START";
    }
}
