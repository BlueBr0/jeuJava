package fr;

import fr.Graphics.DrawMap;
import fr.Utilities.DeleteActionWrapper;
import fr.Utilities.KeyListener;
import fr.Utilities.Loader;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class GUI implements ActionListener {

    private JFrame frame;
    private BufferedImage logo;
    private JTextField entree;
    private JTextArea texte;

    private final Color colorBackground = new Color(14,14,14);
    private final Color colorText = new Color(227,227,227);

    //Panels d'affichage du GUI
    //Côté droit : Entree + Texte
    private JPanel textPanel;

    //Côté gauche : Jeu
    private DrawMap drawPanel;
    private JSplitPane splitPane;

    private KeyListener ListenerEntree = new KeyListener();

    //Liste des commandes valides à afficher lorque l'utilisateur utilise les flèches
    private ArrayList<String> cmdsHistory = new ArrayList<String>();


    public GUI() throws IOException {
        creerGUI();
    }


    //Ajouter la classe Loader
    public void creerGUI() throws IOException {
        frame = new JFrame("Jeu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 790);

        URL resource = Main.class.getResource("/LogoJJ.png");
        //System.out.println(resource);
        this.logo = null;
        if (resource == null) {
            System.err.println("Image not found: " + "/LogoJJ.png");
        }
        else {
            logo = ImageIO.read(resource);
            frame.setIconImage(logo);
        }



        //Load Pixel Font
        Font customFont = Loader.LoadFont("src/main/resources/FourPixelsFont.ttf", 16);
        if (customFont == null) {
            customFont = new Font("Arial", Font.BOLD, 16);
        }

        // Border
        Border logBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(this.colorText, 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        Border inputBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(this.colorText, 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );



        // Left side: Graphics Panel
        this.drawPanel = new DrawMap("/Data/MapTest2.json");
        this.drawPanel.setPreferredSize(new Dimension(600, 800));
        this.drawPanel.setBackground(this.colorBackground);

        // Right side: Text Input & Log
        this.textPanel = new JPanel(new BorderLayout());
        this.entree = new JTextField();
        this.texte = new JTextArea();



        this.texte.setEditable(false);
        this.texte.setLineWrap(true);
        this.texte.setWrapStyleWord(true);

        this.texte.setFont(customFont);
        this.entree.setFont(customFont);

        this.texte.setForeground(this.colorText);
        this.texte.setBackground(this.colorBackground);

        this.entree.setForeground(this.colorText);
        this.entree.setBackground(this.colorBackground);

        this.texte.setBorder(logBorder);
        this.entree.setBorder(inputBorder);

        this.entree.setCaretColor(this.colorText);

        //Enlève le bruit quand on supprime trop du texte
        Action deleteAction = this.entree.getActionMap().get(DefaultEditorKit.deletePrevCharAction);
        this.entree.getActionMap().put( DefaultEditorKit.deletePrevCharAction, new DeleteActionWrapper(this.entree, deleteAction) );


        JScrollPane listScroller = new JScrollPane(this.texte);
        listScroller.setPreferredSize(new Dimension(200, 800));


        this.textPanel.add(listScroller, BorderLayout.CENTER);
        this.textPanel.add(this.entree, BorderLayout.SOUTH);



        this.entree.addActionListener(this);

        this.entree.addKeyListener(this.ListenerEntree);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.drawPanel, this.textPanel);

        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);


        this.frame.setResizable(false);
        this.frame.getContentPane().add(splitPane);
        this.frame.setVisible(true);
        this.entree.requestFocus();


        //texte.append("Player :\r\nPV : 20\r\nBULLETS: 10\r\n");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }

    private void afficher(){
        this.texte.append("\r\n");
    }

    public void enable(boolean ok) {
        this.entree.setEditable(ok);
        if ( ! ok )
            this.entree.getCaret().setBlinkRate(0);
    }


    private void executerCommande() {
        String commandeLue = entree.getText();
        if(!Objects.equals(commandeLue, "")){
            this.texte.append("> " + commandeLue);
            afficher();
            this.entree.setText("");
            entree.setText("");
            //this.cmds.add(commandeLue);
        }

        this.drawPanel.changeMap("/Data/MapTest.json");

        //jeu.traiterCommande( commandeLue);
    }
}
