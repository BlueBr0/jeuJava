package fr.Map.Cells;

public class CellWallBottom extends CellWall{
    public CellWallBottom(int x, int y) {
        super(x, y);
    }
    @Override
    public String getType() {
        return "WALLBOTTOM";
    }
}
