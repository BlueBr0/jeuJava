package fr.Map.Cells;

import fr.Entities.Ennemy;

import java.util.Random;

public class CellEnemy extends Cell{

    public Ennemy zombie;

    public CellEnemy(int x, int y, int xg, int yg) {
        super(x, y, xg, yg);
        setRandomEnemy();
    }

    public void setRandomEnemy(){
        Random random = new Random();
        int vie = random.nextInt(5) + 1; // de 1 à 5

        this.zombie = new Ennemy("Zombie", vie);
    }

    @Override
    public String getType() {
        return "ENEMY";
    }

}
