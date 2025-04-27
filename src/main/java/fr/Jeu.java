package fr;

import fr.Entities.Player;
import fr.Map.Cells.Cell;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe principale représentant le jeu.
 * Elle gère l'état du jeu, les interactions avec l'interface graphique, et les commandes du joueur.
 */
public class Jeu {

    public Zone[] zones;
    private GUI gui; 
	private Zone zoneCourante;
    private final Player joueur = new Player("Player", 10);

    //Player State

    private boolean inLevel = false;
    private boolean inMenu = true;
    private boolean inWorldMap = false;
    private boolean inCamp = false;
    private boolean inCombat = false;

    private ArrayList<Cell> currentLevelCells;

    /**
     * Construit une nouvelle instance du jeu sans interface graphique associée.
     */
    public Jeu() {
        gui = null;
    }

    /**
     * Associe une interface graphique au jeu et initialise l'affichage.
     *
     * @param g L'interface graphique à associer.
     */
    public void setGUI( GUI g) {
        gui = g;
        afficherMessageDeBienvenue();
        creerCarte();
    }



    /**
     * Affiche un message de bienvenue dans l'interface graphique.
     */
    private void afficherMessageDeBienvenue() {
        gui.afficherTexte("Bienvenue !");
        gui.afficherTexte("Tapez '?' pour obtenir de l'aide.");
        gui.afficherTexte("\nEcrivez 'commencer' pour commencer votre aventure.");
        //afficherLocalisation();
    }

    /**
     * Traite une commande saisie par l'utilisateur.
     * Exécute l'action correspondante en fonction de la commande.
     *
     * @param commandeLue La commande saisie par l'utilisateur.
     */
    public void traiterCommande(String commandeLue) {
        switch (commandeLue.toUpperCase()) {
            case "?" : case "AIDE" :
                afficherAide();
               // gui.afficherTexte("AIDE");
                break;
            case "H" : case "HAUT" :
                gui.afficherTexte("HAUT");
                faireCommande(commandeLue);
                break;
            case "B" : case "BAS" :
                gui.afficherTexte("BAS");
                faireCommande(commandeLue);
                break;
            case "D" : case "DROITE" :
                gui.afficherTexte("DROITE");
                faireCommande(commandeLue);
                break;
            case "G" : case "GAUCHE" :
                gui.afficherTexte("GAUCHE");
                faireCommande(commandeLue);
                break;
            case "Q" : case "QUITTER" :
                terminer();
                break;
            case "Z" : case "ZONE":
                afficherZoneActuelle();
                break;
            case "P" : case "PLAYER":
                afficherJoueurStats();
                break;
            case "CAMP" :
                allerDansZone(this.zones[0]);
                break;
            case "OUTSKIRTS" :
                allerDansZone(this.zones[1]);
                break;
            case "FOREST" :
                allerDansZone(this.zones[2]);
                break;
            case "NO MAN'S LAND" :
                allerDansZone(this.zones[3]);
                break;
            case "GHOST VILLAGE" :
                allerDansZone(this.zones[4]);
                break;
            case "WASTELAND" :
                allerDansZone(this.zones[5]);
                break;
            case "COMMENCER" : //AFFICHER CARTE
                commencer();
                break;
            default :
                gui.afficherTexte("Commande inconnue");
                break;
        }
    }

    /**
     * Retourne la cellule où se trouve le joueur dans le niveau actuel.
     *
     * @return La cellule du joueur, ou null si non trouvée.
     */
    private Cell getPlayerCell(){
        Cell cell = null;
        for (Cell c : currentLevelCells){
            if (c.getType().equals("PLAYER")){
                cell = c;
                break;
            }
        }
        return cell;
    }

    /**
     * Retourne la cellule suivante en fonction des coordonnées spécifiées.
     *
     * @param x La coordonnée x de la cellule suivante.
     * @param y La coordonnée y de la cellule suivante.
     * @return La cellule suivante, ou null si non trouvée.
     */
    private Cell getNextCell(int x, int y){
        Cell cell = null;
        for (Cell c : currentLevelCells){
            if (x == c.getXGamePosition() && y == c.getYGamePosition()){
                cell = c;
                break;
            }
        }
        return cell;
    }

    /**
     * Démarre un combat. (Méthode non implémentée)
     */
    public void beginCombat(){

    }

    /**
     * Échange les positions de deux cellules dans la liste des cellules du niveau actuel.
     *
     * @param index1 L'index de la première cellule.
     * @param index2 L'index de la deuxième cellule.
     */
    private void swapCells(int index1, int index2){
        Cell cell1 = currentLevelCells.get(index1);
        Cell cell2 = currentLevelCells.get(index2);

        Collections.swap(this.currentLevelCells, index1, index2);

        int tmpX = cell1.getXPosition();
        int tmpY = cell1.getYPosition();
        int tmpXG = cell1.getXGamePosition();
        int tmpYG = cell1.getYGamePosition();

        cell1.setPosition(cell2.getXPosition(), cell2.getYPosition(), cell2.getXGamePosition(),
                cell2.getYGamePosition());

        cell2.setPosition(tmpX, tmpY, tmpXG, tmpYG);
    }

    /**
     * Retourne l'index d'une cellule dans la liste des cellules du niveau actuel.
     *
     * @param rc La cellule dont on veut obtenir l'index.
     * @return L'index de la cellule, ou -1 si non trouvée.
     */
    private int getCellIndex(Cell rc){
        for (int i = 0; i<this.currentLevelCells.size(); i++){
            if (this.currentLevelCells.get(i).equals(rc)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Effectue le mouvement du joueur vers une cellule suivante.
     * Gère les interactions avec les différents types de cellules (murs, ennemis, butin, etc.).
     *
     * @param playerCell La cellule actuelle du joueur.
     * @param nextCell La cellule suivante vers laquelle le joueur souhaite se déplacer.
     */
    private void doMovement(Cell playerCell, Cell nextCell){

        System.out.println("test");
        switch (nextCell.getType()){
            case "WALL" : case "WALLBOTTOM" : case "WALLCORNER" :
                gui.afficherTexte("Vous ne pouvez pas aller ici !");
                break;
            case "VOID":
                //gui.afficherTexte("Movement");
                int playerCellIndex = getCellIndex(playerCell);

                int nextCellIndex = getCellIndex(nextCell);


                swapCells(playerCellIndex, nextCellIndex);
                gui.redessinerLevel(this.currentLevelCells);

                Cell playerCellNext = getPlayerCell();
                System.out.println(playerCellNext.getXGamePosition() + " : " + playerCellNext.getYGamePosition());
                break;
            case "ENEMY" :
                gui.afficherTexte("Combat start");
                beginCombat();
                break;
            case "LOOT" :
                gui.afficherTexte("Get loot");
                break;
            default:
                gui.afficherTexte("Action indisponible");
                break;
        }
    }

    /**
     * Exécute une commande de mouvement si le joueur est dans un niveau.
     * Met à jour la position du joueur en fonction de la commande.
     *
     * @param comm La commande de mouvement.
     */
    private void faireCommande(String comm){
        if (this.inLevel){
            Cell playerCell = getPlayerCell();
            System.out.println(playerCell.getXGamePosition() + " : " + playerCell.getYGamePosition());

            int xNext = playerCell.getXGamePosition();
            int yNext = playerCell.getYGamePosition();


            switch (comm.toUpperCase()) {
                case "H" : case "HAUT" :
                    //gui.afficherTexte("HAUT");
                    yNext--;

                    break;
                case "B" : case "BAS" :
                    //gui.afficherTexte("BAS");
                    yNext++;
                    break;
                case "D" : case "DROITE" :
                    //gui.afficherTexte("DROITE");
                    xNext++;
                    break;
                case "G" : case "GAUCHE" :
                    //gui.afficherTexte("GAUCHE");
                    xNext--;
                    break;
            }

            Cell nextCell = getNextCell(xNext, yNext);

            doMovement(playerCell, nextCell);


            System.out.println(xNext + " : " + yNext);

        }
        else {
            gui.afficherTexte("Vous ne pouvez pas faire ca ici !");
        }

    }

    /**
     * Déplace le joueur vers une zone spécifiée si elle est déverrouillée et si le joueur est sur la carte du monde.
     *
     * @param z La zone vers laquelle le joueur souhaite se déplacer.
     */
    private void allerDansZone(Zone z){
        if (this.inWorldMap){
            if (z.isLoocked()){
                gui.afficherTexte("Vous n'avez pas encore debloque cette zone !");
            }
            else {
                gui.afficherTexte("Vous entrez dans " + z.description);
                gui.afficherNiveau();
                this.currentLevelCells = gui.getNiveau();

                this.inWorldMap = false;
                this.inCamp = false;
                this.inLevel = true;
                this.inMenu = false;
                this.inCombat = false;
            }
        }
        else {
            gui.afficherTexte("VOus ne pouvez pas faire ca ici !");
        }

    }

    /**
     * Termine le jeu en affichant un message d'au revoir et en désactivant l'interface graphique.
     */
    private void terminer() {
        gui.afficherTexte( "Au revoir...");
        gui.enable( false);
    }

    /**
     * Commence le jeu en affichant la carte du monde si le joueur est dans le menu principal.
     */
    private void commencer(){
        if (this.inMenu){
            gui.afficherCarte();
            gui.afficherTexte("Choississez une carte pour debuter un niveau !");

            this.inWorldMap = true;
            this.inCamp = false;
            this.inLevel = false;
            this.inMenu = false;
            this.inCombat = false;
        }
        else {
            gui.afficherTexte("VOus ne pouvez pas faire ca ici !");
        }

    }

    /**
     * Réinitialise tous les états du jeu à false, sauf un état spécifié.
     *
     * @param a L'état à définir sur true.
     */
    private void setAllFalseBut(boolean a){
        this.inWorldMap = false;
        this.inCamp = false;
        this.inLevel = false;
        this.inMenu = false;

        a = true;
    }

    /**
     * Affiche les commandes disponibles et leurs descriptions dans l'interface graphique.
     */
    private void afficherAide() {
        gui.afficherTexte("Etes-vous perdu ?");
        gui.afficherTexte("Les commandes autorisees sont :");
        gui.afficherTexte(Commande.toutesLesDescriptions());

    }

    /**
     * Affiche les statistiques du joueur dans l'interface graphique.
     */
    private void afficherJoueurStats(){
        gui.afficherTexte(this.joueur.toString());
    }

    /**
     * Affiche la zone actuelle du joueur dans l'interface graphique.
     */
    private void afficherZoneActuelle(){
        gui.afficherTexte("Vous etes dans : " + this.zoneCourante.toString());
    }

    /**
     * Initialise les zones du jeu et définit la zone courante.
     */
    private void creerCarte() {
        this.zones = new Zone [7];
        this.zones[0] = new Zone("SHOP", false);
        this.zones[1] = new Zone("OUTSKIRTS", false);
        this.zones[2] = new Zone("FOREST", true);
        this.zones[3] = new Zone("NO MAN'S LAND", true);
        this.zones[4] = new Zone("GHOST VILLAGE", true);
        this.zones[5] = new Zone("WASTELAND", true);
        this.zones[6] = new Zone("WORLDMAP", false);
        this.zoneCourante = zones[6];

        this.zones[1].setUnlocks(this.zones[2]);
        this.zones[2].setUnlocks(this.zones[3]);
        this.zones[3].setUnlocks(this.zones[4]);
        this.zones[4].setUnlocks(this.zones[5]);
    }

    /**
     * Affiche la zone spécifiée. (Méthode non implémentée)
     *
     * @param z La zone à afficher.
     */
    private void afficherCurrentZone(Zone z){

    }



    /*
    
    private void creerCarte() {
        Zone [] zones = new Zone [4];
        zones[0] = new Zone("le couloir", "Couloir.jpg" );
        zones[1] = new Zone("l'escalier", "Escalier.jpg" );
        zones[2] = new Zone("la grande salle", "GrandeSalle.jpg" );
        zones[3] = new Zone("la salle à manger", "SalleAManger.jpg" );
        zones[0].ajouteSortie(Sortie.EST, zones[1]);
        zones[1].ajouteSortie(Sortie.OUEST, zones[0]);
        zones[1].ajouteSortie(Sortie.EST, zones[2]);
        zones[2].ajouteSortie(Sortie.OUEST, zones[1]);
        zones[3].ajouteSortie(Sortie.NORD, zones[1]);
        zones[1].ajouteSortie(Sortie.SUD, zones[3]);
        zoneCourante = zones[1]; 
    }

    private void afficherLocalisation() {
            gui.afficher( zoneCourante.descriptionLongue());
            gui.afficher();
    }


    




    private void allerEn(String direction) {
    	Zone nouvelle = zoneCourante.obtientSortie( direction);
    	if ( nouvelle == null ) {
        	gui.afficher( "Pas de sortie " + direction);
    		gui.afficher();
    	}
        else {
        	zoneCourante = nouvelle;
        	gui.afficher(zoneCourante.descriptionLongue());
        	gui.afficher();
        	gui.afficheImage(zoneCourante.nomImage());
        }
    }
    
    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
    */

}
