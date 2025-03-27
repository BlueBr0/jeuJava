package fr.Map.Cells;

import fr.Entities.Ennemy;

public class CellEnemy extends Cell{

    public Ennemy zombie;

    public CellEnemy(int x, int y) {
        super(x, y);
    }


    @Override
    public String getType() {
        return "ENEMY";
    }

}
