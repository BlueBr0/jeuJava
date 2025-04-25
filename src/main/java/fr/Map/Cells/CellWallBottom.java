package fr.Map.Cells;

public class CellWallBottom extends CellWall{
    public CellWallBottom(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
    }
    @Override
    public String getType() {
        return "WALLBOTTOM";
    }
}
