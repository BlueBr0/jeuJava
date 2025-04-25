package fr.Map.Cells;

public class CellVoid extends Cell{
    public CellVoid(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }

    @Override
    public String getType() {
        return "VOID";
    }
}
