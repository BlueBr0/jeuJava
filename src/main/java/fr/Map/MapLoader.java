package fr.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.Map.Cells.Cell;
import fr.Map.Cells.CellPlayer;
import fr.Map.Cells.CellWallBottom;
import fr.Map.Cells.CellEnemy;
import fr.Map.Cells.CellWallCorner;
import fr.Map.Cells.CellVoid;
import fr.Map.Cells.CellLoot;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Random;

/**
 * Classe responsable du chargement et de la gestion des cartes de jeu à partir de fichiers JSON ou de listes
 * de cellules.
 * Elle permet de créer une carte composée de différentes cellules et de la parcourir.
 */
public class MapLoader implements Iterable<Cell>{

    private ArrayList<Cell> map;

    private int scale;

    /**
     * Construit un nouvel objet MapLoader en chargeant une carte à partir d'un fichier JSON spécifié.
     *
     * @param filepath Le chemin du fichier JSON contenant les données de la carte.
     * @param scale L'échelle de la carte, utilisée pour déterminer la taille des cellules.
     * @param type Le type de carte à charger ("LEVEL" ou "WORLDMAP").
     */
    public MapLoader(String filepath, int scale, String type){
        this.map = new ArrayList<>();
        this.scale = scale;
        loadMap(filepath, type);
    }

    /**
     * Construit un nouvel objet MapLoader en utilisant une liste de cellules existante.
     *
     * @param list La liste des cellules composant la carte.
     * @param scale L'échelle de la carte, utilisée pour déterminer la taille des cellules.
     */
    public MapLoader(ArrayList<Cell> list, int scale){
        this.map = new ArrayList<>(list);
        this.scale = scale;
    }


    /**
     * Charge une carte à partir d'un fichier JSON en fonction du type spécifié.
     * Si le type est "LEVEL", la carte est construite en parsant le JSON et en créant les cellules correspondantes.
     *
     * @param filepath Le chemin du fichier JSON contenant les données de la carte.
     * @param type Le type de carte à charger ("LEVEL" ou "WORLDMAP").
     */
    private void loadMap(String filepath, String type){


        InputStream inputStream = getClass().getResourceAsStream(filepath);
        if (inputStream == null) {
            System.err.println("Erreur : Fichier " + "filepath " + " introuvable !");
            return;
            //Remplacer avec une Exception Custom
        }

        if (type.equals("LEVEL")) {
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

    /**
     * Retourne la liste des cellules composant la carte.
     *
     * @return La liste des cellules de la carte.
     */
    public ArrayList<Cell> getMap() {
       return this.map;
    }

    /**
     * Définit une nouvelle liste de cellules pour la carte.
     *
     * @param c La nouvelle liste de cellules à utiliser pour la carte.
     */
    public void setMap (ArrayList<Cell> c) {
        this.map = c;
    }


    /**
     * Retourne un itérateur pour parcourir les cellules de la carte.
     *
     * @return Un itérateur sur les cellules de la carte.
     */
    @Override
    public Iterator<Cell> iterator() {
        return this.map.iterator();
    }
}
 