package fr.Map.Cells;

public class CellLoot extends Cell{

    //private Loot loot;

    public CellLoot(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "LOOT";
    }
}
