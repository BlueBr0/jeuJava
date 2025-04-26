package fr.Utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * Classe utilitaire pour charger diverses ressources telles que des fichiers JSON, des sprites et des polices de
 * caractères.
 */
public class Loader {

    /**
     * Charge un fichier JSON.
     * Cette méthode est une ébauche et retourne toujours true.
     *
     * @return true si le fichier JSON est chargé avec succès.
     */
    public static boolean loadJson(){
        return true;
    }

    /**
     * Charge un sprite.
     * Cette méthode est une ébauche et retourne toujours true.
     *
     * @return true si le sprite est chargé avec succès.
     */
    public static boolean loadSprite(){
        return true;
    }

    /**
     * Charge une police de caractères à partir d'un fichier situé au chemin spécifié.
     *
     * @param path Le chemin du fichier de police.
     * @param size La taille de la police à définir.
     * @return La police chargée avec la taille spécifiée, ou null si le chargement échoue.
     */
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
