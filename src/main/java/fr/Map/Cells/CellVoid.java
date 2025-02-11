package fr.Map.Cells;

public class CellVoid extends Cell{
    public CellVoid(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "VOID";
    }
}
