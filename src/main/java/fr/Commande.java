package fr;
import java.util.ArrayList;
import java.util.List;

/**
 * Énumération représentant les différentes commandes disponibles dans le jeu.
 * Chaque commande est associée à une abréviation et une description.
 */
public enum Commande {
	NORD("D", "D : Aller a droite"),
	SUD("G", "G : Aller a gauche"),
	EST("H", "H : Aller en haut)"),
	OUEST("B", "B : Aller en bas"),
	AIDE("?", "? : Aide"),
	QUITTER("Q", "Q : Quitter "),
	ACHETER("BUY", "BUY : Acheter"),
	ZONEACTUELLE("Z", "Z : Zone actuelle"),
	PLAYERSTATS("P", "P : Afficher les statistiques du joueur");

    private String abreviation;
    private String description;

	/**
	 * Construit une commande avec une abréviation et une description spécifiées.
	 *
	 * @param c L'abréviation de la commande.
	 * @param d La description de la commande.
	 */
	private Commande(String c, String d ) {
		abreviation = c;
	    description = d;
	}

	/**
	 * Retourne le nom de la commande sous forme de chaîne de caractères.
	 *
	 * @return Le nom de la commande.
	 */
	@Override
	public String toString() { 
		return name();
	}

	/**
	 * Retourne une chaîne de caractères contenant toutes les descriptions des commandes.
	 * Chaque description est séparée par un retour à la ligne.
	 *
	 * @return Une chaîne de caractères contenant toutes les descriptions des commandes.
	 */
	public static String toutesLesDescriptions() {
		String resultat = "";
		for (Commande c : values()) {
			resultat += ( c.description + "\r\n");
		}
		return resultat;
	}

	/**
	 * Retourne une liste contenant toutes les abréviations des commandes.
	 *
	 * @return Une liste des abréviations des commandes.
	 */
	public static List<String> toutesLesAbreviations() {
		ArrayList<String> resultat = new ArrayList<String>();
		for (Commande c : values()) {
			resultat.add( c.abreviation);
		}
		return resultat;
	}

	/**
	 * Retourne une liste contenant tous les noms des commandes.
	 *
	 * @return Une liste des noms des commandes.
	 */
	public static List<String> tousLesNoms() {
		ArrayList<String> resultat = new ArrayList<String>();
		for (Commande c : values()) {
			resultat.add( c.name());
		}
		return resultat;
	}

}
