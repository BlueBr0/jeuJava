package fr;
import java.util.ArrayList;
import java.util.List;

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
	private Commande(String c, String d ) { 
		abreviation = c;
		description = d; 
	}
	@Override
	public String toString() { 
		return name();
	}
	
	public static String toutesLesDescriptions() {
		String resultat = "";
		for(Commande c : values()) {
			resultat+=( c.description + "\r\n");
		}
		return resultat;
	}
	
	public static List<String> toutesLesAbreviations() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.abreviation);
		}
		return resultat;
	}
	
	public static List<String> tousLesNoms() { 
		ArrayList<String> resultat = new ArrayList<String>();
		for(Commande c : values()) {
			resultat.add( c.name());
		}
		return resultat;
	}

}
