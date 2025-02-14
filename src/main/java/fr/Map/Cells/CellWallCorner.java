package fr.Map.Cells;

public class CellWallCorner extends CellWall{
    public CellWallCorner(int x, int y) {
        super(x, y);
    }
    @Override
    public String getType() {
        return "WALLCORNER";
    }
}
