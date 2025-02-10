package fr.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class DrawMap extends JPanel {

    TextureAtlas textureAtlas;

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

        int x = 0;

        for(Map.Entry<String, BufferedImage> entry : textureAtlas.textures.entrySet()){
            if (entry.getValue() != null) {
                BufferedImage image = entry.getValue();
                g.drawImage(image, x, 0,100, 100, this);
            }
            x = x + 100;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image with Graphics");
        DrawMap panel = new DrawMap();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}