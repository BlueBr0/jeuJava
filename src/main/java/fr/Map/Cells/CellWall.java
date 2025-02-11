package fr.Map.Cells;

public class CellWall extends Cell{

    public CellWall(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "WALL";
    }

}
