package fr.Map.Cells;

public class CellEnd extends Cell{

    public CellEnd(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "END";
    }
}
