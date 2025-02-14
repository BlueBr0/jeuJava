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

        for(Cell c : map.getMap()){
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
                case "VOID":
                    image = textureAtlas.textures.get("VOID");
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

    public static Font loadCustomFont(String path, float size) {
        try {
            File fontFile = new File(path);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font: " + e.getMessage());
            return null; // Return null if font fails to load
        }
    }

    //Méthode de tests
    /*
    public void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 790);

        URL resource = getClass().getResource("/LogoJJ.png");
        //System.out.println(resource);
        BufferedImage image;
        if (resource == null) {
            throw new IOException("Image not found: " + "/LogoJJ.png");
        }
        else {
            image = ImageIO.read(resource);
        }


        frame.setIconImage(image);

        Color colorBackground = new Color(14,14,14);
        Color colorText = new Color(227,227,227);

        //Load Pixel Font
        Font customFont = loadCustomFont("src/main/resources/FourPixelsFont.ttf", 16);
        if (customFont == null) {
            customFont = new Font("Arial", Font.BOLD, 16);
        }

        // Border
        //Border logBorder = BorderFactory.createLineBorder(colorText, 3);
        //Border inputBorder = BorderFactory.createLineBorder(colorText, 3);
        Border logBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorText, 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        Border inputBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorText, 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );



        // Left side: Graphics Panel
        DrawMap drawPanel = new DrawMap();
        drawPanel.setPreferredSize(new Dimension(600, 800));

        drawPanel.setBackground(colorBackground);

        // Right side: Text Input & Log
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextField entree = new JTextField();
        JTextArea texte = new JTextArea();



        texte.setEditable(false);
        texte.setLineWrap(true);
        texte.setWrapStyleWord(true);

        texte.setFont(customFont);
        entree.setFont(customFont);

        texte.setForeground(colorText);
        texte.setBackground(colorBackground);

        entree.setForeground(colorText);
        entree.setBackground(colorBackground);

        texte.setBorder(logBorder);
        entree.setBorder(inputBorder);

        entree.setCaretColor(colorText);
        DefaultCaret caret = (DefaultCaret) entree.getCaret();
        caret.setBlinkRate(500);

        //Enlève le bruit quand on supprime trop du texte
        Action deleteAction = entree.getActionMap().get(DefaultEditorKit.deletePrevCharAction);
        entree.getActionMap().put( DefaultEditorKit.deletePrevCharAction, new DeleteActionWrapper(entree, deleteAction) );


        JScrollPane listScroller = new JScrollPane(texte);
        listScroller.setPreferredSize(new Dimension(200, 800));

        textPanel.add(listScroller, BorderLayout.CENTER);
        textPanel.add(entree, BorderLayout.SOUTH);



        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, drawPanel, textPanel);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);


        frame.setResizable(false);
        frame.getContentPane().add(splitPane);
        frame.setVisible(true);
        entree.requestFocus();


        texte.append("Player :\r\nPV : 20\r\nBULLETS: 10\r\n");

    }*/
}