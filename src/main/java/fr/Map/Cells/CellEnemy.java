package fr.Map.Cells;

public class CellEnemy extends Cell{

    public CellEnemy(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "ENEMY";
    }

}
