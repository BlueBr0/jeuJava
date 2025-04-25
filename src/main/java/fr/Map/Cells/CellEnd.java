package fr.Map.Cells;

public class CellEnd extends Cell{

    public CellEnd(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    @Override
    public String getType() {
        return "END";
    }
}
