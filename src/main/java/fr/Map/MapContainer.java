package fr.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.Map.Cells.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapContainer {

    private final ArrayList<Cell> map;

    public MapContainer(String filepath){
        this.map = new ArrayList<>();
        loadMap(filepath);
    }

    private void loadMap(String filepath){


        InputStream inputStream = getClass().getResourceAsStream(filepath);
        if (inputStream == null) {
            System.err.println(STR."Erreur : Fichier \{filepath} introuvable !");
            return;
            //Remplacer avec une Exception Custom
        }

        try{
            InputStreamReader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(reader, JsonObject.class);

            JsonArray mapArray = json.getAsJsonArray("map");

            for (int y = 0; y < mapArray.size(); y++) {
                String row = mapArray.get(y).getAsString();
                for (int x = 0; x < row.length(); x++) {
                    char cellType = row.charAt(x);
                    int posX = x * 50;
                    int posY = y * 50;

                    switch (cellType) {
                        case 'W': map.add(new CellWall(posX, posY)); break;
                        case 'P': map.add(new CellPlayer(posX, posY)); break;
                        case 'E': map.add(new CellEnemy(posX, posY)); break;
                        case 'S': map.add(new CellVoid(posX, posY)); break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Cell> getMap() {
       return this.map;
    }
}
 