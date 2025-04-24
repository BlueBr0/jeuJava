package fr.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.Map.Cells.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class MapLoader implements Iterable<Cell>{

    private  ArrayList<Cell> map;

    private int scale;

    public MapLoader(String filepath, int scale, String type){
        this.map = new ArrayList<>();
        this.scale = scale;
        loadMap(filepath, type);
    }

    private void loadMap(String filepath, String type){


        InputStream inputStream = getClass().getResourceAsStream(filepath);
        if (inputStream == null) {
            System.err.println("Erreur : Fichier " + "filepath " + " introuvable !");
            return;
            //Remplacer avec une Exception Custom
        }

        if(type.equals("LEVEL")) {
            try {
                InputStreamReader reader = new InputStreamReader(inputStream);
                Gson gson = new Gson();
                JsonObject json = gson.fromJson(reader, JsonObject.class);

                JsonArray mapArray = json.getAsJsonArray("map");

                for (int y = 0; y < mapArray.size(); y++) {
                    String row = mapArray.get(y).getAsString();
                    for (int x = 0; x < row.length(); x++) {
                        char cellType = row.charAt(x);
                        int posX = x * scale;
                        int posY = y * scale;

                        switch (cellType) {
                            case 'W':
                                map.add(new CellWallCorner(posX, posY));
                                break;
                            case 'P':
                                map.add(new CellPlayer(posX, posY));
                                break;
                            case 'E':
                                map.add(new CellEnemy(posX, posY));
                                break;
                            case 'S':
                                map.add(new CellVoid(posX, posY));
                                break;
                            case 'B':
                                map.add(new CellWallBottom(posX, posY));
                                break;
                            case 'L':
                                map.add(new CellLoot(posX, posY));
                                break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public ArrayList<Cell> getMap() {
       return new ArrayList<Cell>(this.map);
    }


    @Override
    public Iterator<Cell> iterator() {
        return this.map.iterator();
    }
}
 