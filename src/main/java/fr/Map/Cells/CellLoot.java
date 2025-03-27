package fr.Map.Cells;

import fr.Utilities.Loot;

public class CellLoot extends Cell{

    private Loot loot;

    public CellLoot(int x, int y) {
        super(x, y);
        this.loot = new Loot();
    }

    @Override
    public String getType() {
        return "LOOT";
    }
}
