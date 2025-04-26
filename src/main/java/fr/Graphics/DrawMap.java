package fr.Graphics;

import fr.Map.Cells.Cell;
import fr.Map.MapLoader;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe responsable du dessin de la carte sur un JPanel.
 * Elle charge la carte à partir d'un fichier JSON ou d'une liste de cellules,
 * et utilise un atlas de textures pour dessiner les différents éléments de la carte.
 */
public class DrawMap extends JPanel {

    public MapLoader map;

    private TextureAtlas textureAtlas;
    private String currentType = "NONE";

    //Taille par défaut
    private final int scale = 50;

    /**
     * Construit un nouvel objet DrawMap pour dessiner une carte à partir d'un fichier JSON.
     * Initialise également l'atlas de textures utilisé pour dessiner les éléments de la carte.
     *
     * @param mapJsonFile Le chemin du fichier JSON contenant les données de la carte.
     * @param type Le type de carte à dessiner ("LEVEL" ou "WORLDMAP").
     */
    public DrawMap(String mapJsonFile, String type) {
        try {
            this.currentType = type;
            map = new MapLoader(mapJsonFile, scale, type);
            textureAtlas = new TextureAtlas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Change la carte actuellement dessinée en chargeant un nouveau fichier JSON.
     * Met à jour le type de carte et redessine le panneau.
     *
     * @param mapJsonFile Le chemin du nouveau fichier JSON contenant les données de la carte.
     * @param type Le type de la nouvelle carte.
     */
    public void changeMapJSON(String mapJsonFile, String type){
        this.currentType = type;
        map = new MapLoader(mapJsonFile, scale, type);
        repaint();
    }

    /**
     * Change la carte actuellement dessinée en utilisant une liste de cellules.
     * Met à jour la carte et redessine le panneau.
     *
     * @param list La liste des cellules représentant la nouvelle carte.
     */
    public void changeMapArray(ArrayList<Cell> list){
        this.map.setMap(list);
        repaint();
    }

    /**
     * Dessine la carte sur le JPanel en utilisant les textures appropriées pour chaque type de cellule.
     * Si le type de carte est "LEVEL", dessine chaque cellule individuellement.
     * Si le type de carte est "WORLDMAP", dessine une image unique pour la carte du monde.
     *
     * @param g L'objet Graphics utilisé pour dessiner sur le JPanel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.println("TEST PAINT");

        if (this.currentType.equals("LEVEL")){
            //System.out.println("TEST PAINT2");
            for (Cell c : map.getMap()){
                //System.out.println(c.toString());
                BufferedImage image;
                switch (c.getType()){
                    case "WALLBOTTOM":
                        image = textureAtlas.textures.get("WALLBOTTOM");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                    case "WALLCORNER":
                        image = textureAtlas.textures.get("WALLCORNER");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                    case "ENEMY":
                        image = textureAtlas.textures.get("ENEMY");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                    case "PLAYER":
                        image = textureAtlas.textures.get("PLAYER");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                    case "LOOT":
                        image = textureAtlas.textures.get("LOOT");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                    default:
                        image = textureAtlas.textures.get("VOID");
                        g.drawImage(image, c.getXPosition(), c.getYPosition(), scale, scale, this);
                        break;
                }
            }
        }
        else if (this.currentType.equals("WORLDMAP")){
            BufferedImage image = textureAtlas.textures.get("WORLDMAP");
            g.drawImage(image, 0, 0, 720, 720, this);
        }


    }

    /*
    //A DEPLACER DANS LA CLASSE LOADER
    public static Font loadCustomFont(String path, float size) {
        try {
            File fontFile = new File(path);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font: " + e.getMessage());
            return null; // Return null if font fails to load
        }
    }*/


}