package fr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    private int posX;
    private int posY;

    public ImagePanel(String path,int x,int y) {
        try {
            URL resource = getClass().getResource(path);
            if (resource == null) {
                throw new IOException("Image not found: " + path);
            }
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.posX = x;
        this.posY = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        if (image != null) {
            g.drawImage(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT), this.posX, this.posY, this);
            g.drawImage(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT), 100, this.posY, this);
        }
    }
}
