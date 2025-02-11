package fr.Map;

import fr.Map.Cells.Cell;
import fr.Map.Cells.CellEnemy;
import fr.Map.Cells.CellWall;
import fr.Map.Cells.CellPlayer;
import java.util.ArrayList;

public class MapContainer {


    private ArrayList<Cell> map = new ArrayList<Cell>();

    public MapContainer(){
        this.map.add(new CellWall(0,0));
        this.map.add(new CellWall(100,0));
        this.map.add(new CellWall(200,0));
        this.map.add(new CellWall(300,0));
        this.map.add(new CellWall(400,0));
        this.map.add(new CellWall(0,100));
        this.map.add(new CellPlayer(100,100));
        this.map.add(new CellEnemy(200,100));
        this.map.add(new CellWall(400,100));
        this.map.add(new CellWall(0,200));
        this.map.add(new CellWall(100,200));
        this.map.add(new CellWall(200,200));
        this.map.add(new CellWall(300,200));
        this.map.add(new CellWall(400,200));
    }

    public ArrayList<Cell> getMap() {
       return this.map;
    }

}
 