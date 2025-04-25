package fr.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.Map.Cells.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

public class MapLoader implements Iterable<Cell>{

    private ArrayList<Cell> map;

    private int scale;

    public MapLoader(String filepath, int scale, String type){
        this.map = new ArrayList<>();
        this.scale = scale;
        loadMap(filepath, type);
    }

    public MapLoader(ArrayList<Cell> list, int scale){
        this.map = new ArrayList<>(list);
        this.scale = scale;
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

                // Récupère les cartes depuis "maps"
                JsonArray mapsArray = json.getAsJsonArray("maps");

                // Choisir une carte aléatoirement (ou un index précis)
                Random rand = new Random();
                JsonArray mapArray = mapsArray.get(rand.nextInt(mapsArray.size())).getAsJsonArray();

                for (int y = 0; y < mapArray.size(); y++) {
                    String row = mapArray.get(y).getAsString();
                    for (int x = 0; x < row.length(); x++) {
                        char cellType = row.charAt(x);
                        int posX = x * scale;
                        int posY = y * scale;

                        switch (cellType) {
                            case 'W':
                                map.add(new CellWallCorner(posX, posY, x + 1, y + 1));
                                break;
                            case 'P':
                                map.add(new CellPlayer(posX, posY, x + 1, y + 1));
                                break;
                            case 'E':
                                map.add(new CellEnemy(posX, posY, x + 1, y + 1));
                                break;
                            case 'S':
                                map.add(new CellVoid(posX, posY, x + 1, y + 1));
                                break;
                            case 'B':
                                map.add(new CellWallBottom(posX, posY, x + 1, y + 1));
                                break;
                            case 'L':
                                map.add(new CellLoot(posX, posY, x + 1, y + 1));
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
       return this.map;
    }

    public void setMap (ArrayList<Cell> c) {
        this.map = c;
    }


    @Override
    public Iterator<Cell> iterator() {
        return this.map.iterator();
    }
}
 