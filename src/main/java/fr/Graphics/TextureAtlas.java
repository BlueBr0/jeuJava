package fr.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TextureAtlas {

    public HashMap<String, BufferedImage> textures = new HashMap<>();

    private HashMap<String, String> names = new HashMap<>();

    private final String WALLC = "WALLCORNER";

    private final String WALLB = "WALLBOTTOM";
    private final String START = "START";
    private final String END = "END";
    private final String ENEMY = "ENEMY";
    private final String PLAYER = "PLAYER";
    private final String LOOT = "LOOT";
    private final String PH = "PH";
    private final String VOID = "VOID";





    public TextureAtlas() throws IOException {

        names.put(WALLC, "/Sprites/SpriteWallCorner.png");
        names.put(WALLB, "/Sprites/SpriteWallBottom.png");
        names.put(START, "/STARTPlaceHolder.png");
        names.put(END, "/ENDPlaceholder.png");
        names.put(ENEMY, "/Sprites/ZombieSprite.png");
        names.put(PLAYER, "/Sprites/PlayerSprite.png");
        names.put(LOOT, "/Sprites/LootSprite.png");
        names.put(PH, "/placeholder.png");
        names.put(VOID, "/voidPlaceHolder.png");



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
