package fr.Utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Loader {

    public static boolean loadJson(){
        return true;
    }

    public static boolean loadSprite(){
        return true;
    }

    public static Font loadFont(String path, float size){
        try {
            File fontFile = new File(path);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font: " + e.getMessage());
            return null; // Return null if font fails to load
        }
    }


}
