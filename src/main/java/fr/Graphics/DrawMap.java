package fr.Graphics;

import fr.Map.Cells.Cell;
import fr.Map.MapContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class DrawMap extends JPanel {

    TextureAtlas textureAtlas;

    MapContainer map = new MapContainer();

    public DrawMap() {
        try {
            textureAtlas = new TextureAtlas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        for(Cell c : map.getMap()){
            //System.out.println(c.toString());
            BufferedImage image;
            switch (c.getType()){
                case "WALL":
                    image = textureAtlas.textures.get("WALL");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),100, 100, this);
                    break;
                case "ENEMY":
                    image = textureAtlas.textures.get("ENEMY");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),100, 100, this);
                    break;
                case "PLAYER":
                    image = textureAtlas.textures.get("PLAYER");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),100, 100, this);
                    break;
            }

        }


        /*

         int x = 0;
        for(Map.Entry<String, BufferedImage> entry : textureAtlas.textures.entrySet()){

            if (entry.getValue() != null) {
                BufferedImage image = entry.getValue();
                g.drawImage(image, x, 0,100, 100, this);
            }
            x = x + 100;
        }
        */

    }

    //Méthode de tests
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image with Graphics");
        DrawMap panel = new DrawMap();

        JTextField entree = new JTextField(34);

        JTextArea texte = new JTextArea();
        texte.setEditable(false);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}