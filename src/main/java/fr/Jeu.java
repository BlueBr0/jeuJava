package fr;

import fr.Entities.Player;

public class Jeu {

    public Zone[] zones;
    private GUI gui; 
	private Zone zoneCourante;
    private final Player joueur = new Player("Player", 20, 1);
    
    public Jeu() {
        //creerCarte();
        gui = null;
    }

    public void setGUI( GUI g) {
        gui = g;
        afficherMessageDeBienvenue();
        creerCarte();
    }

    private void afficherMessageDeBienvenue() {
        gui.afficherTexte("Bienvenue !");
        gui.afficherTexte("Tapez '?' pour obtenir de l'aide.");
        //afficherLocalisation();
        //gui.afficheImage(zoneCourante.nomImage());
    }

    public void traiterCommande(String commandeLue) {
        switch (commandeLue.toUpperCase()) {
            case "?" : case "AIDE" :
                afficherAide();
               // gui.afficherTexte("AIDE");
                break;
            case "H" : case "HAUT" :
                gui.afficherTexte("HAUT");
                break;
            case "B" : case "BAS" :
                gui.afficherTexte("BAS");
                break;
            case "D" : case "DROITE" :
                gui.afficherTexte("DROITE");
                break;
            case "G" : case "GAUCHE" :
                gui.afficherTexte("GAUCHE");
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
            default :
                gui.afficherTexte("Commande inconnue");
                break;
        }
    }

    private void terminer() {
        gui.afficherTexte( "Au revoir...");
        gui.enable( false);
    }

    private void afficherAide() {
        gui.afficherTexte("Etes-vous perdu ?");
        gui.afficherTexte("Les commandes autorisees sont :");
        gui.afficherTexte(Commande.toutesLesDescriptions());

    }

    private void afficherJoueurStats(){
        gui.afficherTexte(this.joueur.toString());
    }

    private void afficherZoneActuelle(){
        gui.afficherTexte("Vous etes dans : " + this.zoneCourante.toString());
    }

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
    }

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
