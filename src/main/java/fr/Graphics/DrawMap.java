package fr.Graphics;

import fr.Map.Cells.Cell;
import fr.Map.MapContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawMap extends JPanel {

    TextureAtlas textureAtlas;
    MapContainer map = new MapContainer("/Data/MapTest.json");

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

        int scale = 50;



        //g.drawRect(0,0,799,799);


        for(Cell c : map.getMap()){
            //System.out.println(c.toString());
            BufferedImage image;
            switch (c.getType()){
                case "WALL":
                    image = textureAtlas.textures.get("WALL");
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
                case "VOID":
                    image = textureAtlas.textures.get("VOID");
                    g.drawImage(image, c.getXPosition(), c.getYPosition(),scale, scale, this);
                    break;
            }

        }

    }

    //Méthode de tests
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image with Graphics");
        DrawMap panel = new DrawMap();

        //JTextField entree = new JTextField(34);

        JTextArea texte = new JTextArea();
        texte.setEditable(false);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}