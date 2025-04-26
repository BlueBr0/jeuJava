package fr;

import fr.Graphics.DrawMap;
import fr.Map.Cells.Cell;
import fr.Utilities.DeleteActionWrapper;
import fr.Utilities.KeyListener;
import fr.Utilities.Loader;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.DefaultEditorKit;
import javax.swing.Action;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Classe représentant l'interface graphique du jeu.
 * Elle gère l'affichage des éléments graphiques et textuels, ainsi que l'interaction avec l'utilisateur.
 */
public class GUI implements ActionListener {

    private JFrame frame;
    private BufferedImage logo;
    private JTextField entree;
    private JTextArea texte;
    private Jeu jeuInstance;

    private final Color colorBackground = new Color(14, 14, 14);
    private final Color colorText = new Color(227, 227, 227);

    //Panels d'affichage du GUI
    //Côté droit : Entree + Texte
    private JPanel textPanel;

    //Côté gauche : Jeu
    private DrawMap drawPanel; //DEFINIR LE TRUC A AFFICHER
    private JSplitPane splitPane;

    private KeyListener listenerEntree = new KeyListener();

    //Liste des commandes valides à afficher lorque l'utilisateur utilise les flèches
    private ArrayList<String> cmdsHistory = new ArrayList<String>();


    /**
     * Construit une nouvelle interface graphique pour le jeu.
     * Initialise les composants de l'interface et associe une instance du jeu.
     *
     * @param j L'instance du jeu à associer à cette interface.
     * @throws IOException Si une erreur survient lors du chargement des ressources.
     */
    public GUI(Jeu j) throws IOException {
        creerGUI();
        this.jeuInstance = j;
    }


    /**
     * Crée et configure l'interface graphique du jeu.
     * Initialise la fenêtre principale, les panneaux, les polices et les composants d'entrée/sortie.
     *
     * @throws IOException Si une erreur survient lors du chargement des ressources.
     */
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
        Font customFont = Loader.loadFont("src/main/resources/FourPixelsFont.ttf", 16);
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
        this.drawPanel = new DrawMap("/Data/MapTest2.json", "NONE");
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
        this.entree.getActionMap().put( DefaultEditorKit.deletePrevCharAction, new DeleteActionWrapper(this.entree,
                deleteAction) );


        JScrollPane listScroller = new JScrollPane(this.texte);
        listScroller.setPreferredSize(new Dimension(200, 800));


        this.textPanel.add(listScroller, BorderLayout.CENTER);
        this.textPanel.add(this.entree, BorderLayout.SOUTH);



        this.entree.addActionListener(this);

        this.entree.addKeyListener(this.listenerEntree);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.drawPanel, this.textPanel);

        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(0);


        this.frame.setResizable(false);
        this.frame.getContentPane().add(splitPane);
        this.frame.setVisible(true);
        this.entree.requestFocus();

        this.listenerEntree.setEntree(this.entree);


        //texte.append("Player :\r\nPV : 20\r\nBULLETS: 10\r\n");
    }


    /**
     * Méthode appelée lorsqu'une action est effectuée, comme l'appui sur Entrée dans le champ de texte.
     * Exécute la commande saisie par l'utilisateur.
     *
     * @param e L'événement d'action qui a déclenché cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }

    /**
     * Affiche un texte donné dans la zone de texte de l'interface.
     *
     * @param s Le texte à afficher.
     */
    public void afficherTexte(String s){
        this.texte.append(s);
        afficher();
    }

    /**
     * Ajoute une nouvelle ligne à la zone de texte de l'interface.
     */
    public void afficher(){
        this.texte.append("\r\n");
    }

    /**
     * Active ou désactive l'édition dans le champ de texte d'entrée.
     *
     * @param ok true pour activer l'édition, false pour la désactiver.
     */
    public void enable(boolean ok) {
        this.entree.setEditable(ok);
        if ( ! ok )
            this.entree.getCaret().setBlinkRate(0);
    }

    //Gérer les commandes


    /**
     * Affiche la carte du monde dans le panneau graphique.
     */
    public void afficherCarte(){
        this.drawPanel.changeMapJSON("", "WORLDMAP");
    }

    /**
     * Affiche la carte de la boutique dans le panneau graphique.
     */
    public void afficherShop(){
        this.drawPanel.changeMapJSON("", "SHOP");
    }

    /**
     * Affiche un niveau de jeu dans le panneau graphique.
     */
    public void afficherNiveau(){
        this.drawPanel.changeMapJSON("/Data/MapsTest.json", "LEVEL");
    }

    /**
     * Exécute une commande saisie par l'utilisateur.
     * Lit la commande depuis le champ de texte, l'affiche dans la zone de texte, et la traite via l'instance du jeu.
     */
    private void executerCommande() {
        String commandeLue = entree.getText();
        if (!Objects.equals(commandeLue, "")){
            this.texte.append("> " + commandeLue);
            afficher();
            this.entree.setText("");
            entree.setText("");
            //this.cmds.add(commandeLue);
            jeuInstance.traiterCommande(commandeLue);


            listenerEntree.commandes.add(commandeLue);


        }

        //this.drawPanel.changeMap("/Data/MapsTest.json", "LEVEL");

        //jeu.traiterCommande( commandeLue);
    }


    /**
     * Met à jour l'affichage du niveau avec une nouvelle liste de cellules.
     *
     * @param list La nouvelle liste de cellules représentant le niveau.
     */
    public void redessinerLevel(ArrayList<Cell> list){
        this.drawPanel.changeMapArray(list);
    }

    /**
     * Retourne la liste des cellules du niveau actuellement affiché.
     *
     * @return La liste des cellules du niveau.
     */
    public ArrayList<Cell> getNiveau(){
        return new ArrayList<>(this.drawPanel.map.getMap());
    }
}
