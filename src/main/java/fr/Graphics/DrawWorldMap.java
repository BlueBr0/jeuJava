package fr.Graphics;


import fr.Map.Cells.Cell;
import fr.Map.MapLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawWorldMap extends JPanel {


    TextureAtlas textureAtlas;
    MapLoader map;

    private final int scale = 50;

    public DrawWorldMap(String mapJsonFile){
        try{
            map = new MapLoader(mapJsonFile,scale);
            textureAtlas = new TextureAtlas();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void changeMap(){
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for(Cell c : map){

        }
    }

}
