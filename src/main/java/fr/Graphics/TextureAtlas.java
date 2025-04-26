package fr.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant un atlas de textures, utilisé pour charger et stocker des images à partir de fichiers.
 * Chaque texture est associée à une clé permettant de la récupérer facilement pour le rendu graphique.
 */
public class TextureAtlas {

    public HashMap<String, BufferedImage> textures = new HashMap<>();

    private HashMap<String, String> names = new HashMap<>();

    private final String wallC = "WALLCORNER";

    private final String wallB = "WALLBOTTOM";
    private final String start = "START";
    private final String end = "END";
    private final String enemy = "ENEMY";
    private final String player = "PLAYER";
    private final String loot = "LOOT";
    private final String ph = "PH";
    private final String voidPlaceHolder = "VOID";
    private  final String wp = "WORLDMAP";


    /**
     * Construit un nouvel atlas de textures en chargeant les images à partir des chemins spécifiés.
     * Chaque image est associée à une clé et stockée dans une carte (HashMap) pour un accès rapide.
     *
     * @throws IOException Si une image n'est pas trouvée ou si une erreur survient lors du chargement des images.
     */
    public TextureAtlas() throws IOException {

        names.put(wallC, "/Sprites/SpriteWallCorner.png");
        names.put(wallB, "/Sprites/SpriteWallBottom.png");
        names.put(start, "/STARTPlaceHolder.png");
        names.put(end, "/ENDPlaceholder.png");
        names.put(enemy, "/Sprites/ZombieSprite.png");
        names.put(player, "/Sprites/PlayerSprite.png");
        names.put(loot, "/Sprites/LootSprite.png");
        names.put(ph, "/placeholder.png");
        names.put(voidPlaceHolder, "/voidPlaceHolder.png");
        names.put(wp, "/Sprites/WorldMap.png");



        try {

            for (Map.Entry<String, String> entry : names.entrySet()) {
                String key = entry.getKey();
                String path = entry.getValue();

                URL resource = getClass().getResource(path);
                //System.out.println(resource);
                if (resource == null) {
                    throw new IOException("Image not found: " + path);
                }
                BufferedImage image = ImageIO.read(resource);

                textures.put(key, image);

            }
        } catch (IOException | NullPointerException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
