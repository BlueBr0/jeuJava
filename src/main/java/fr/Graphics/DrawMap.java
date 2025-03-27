package fr.Graphics;

import fr.Map.Cells.Cell;
import fr.Map.MapLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawMap extends JPanel {

    TextureAtlas textureAtlas;
    MapLoader map;

    //Taille par défaut
    private final int scale = 50;

    public DrawMap(String mapJsonFile) {
        try {
            map = new MapLoader(mapJsonFile, scale);
            textureAtlas = new TextureAtlas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeMap(String mapJsonFile){
        map = new MapLoader(mapJsonFile, scale);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Cell c : map){
            //System.out.println(c.toString());
            BufferedImage image;
            switch (c.getType()){
                case "WALLBOTTOM":
                    image = textureAtlas.textures.get("WALLBOTTOM");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
                case "WALLCORNER":
                    image = textureAtlas.textures.get("WALLCORNER");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
                case "ENEMY":
                    image = textureAtlas.textures.get("ENEMY");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
                case "PLAYER":
                    image = textureAtlas.textures.get("PLAYER");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
                case "LOOT":
                    image = textureAtlas.textures.get("LOOT");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
                default:
                    image = textureAtlas.textures.get("VOID");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
            }

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