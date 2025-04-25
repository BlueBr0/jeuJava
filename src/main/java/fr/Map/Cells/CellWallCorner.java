package fr.Map.Cells;

public class CellWallCorner extends CellWall{
    public CellWallCorner(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }


    @Override
    public String getType() {
        return "WALLCORNER";
    }
}
