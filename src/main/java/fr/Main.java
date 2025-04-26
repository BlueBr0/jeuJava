package fr;



import java.io.IOException;



/**
 * Classe principale contenant le point d'entrée du programme.
 * Elle initialise et lance le jeu avec son interface graphique.
 */
public class Main {

	/**
	 * Point d'entrée principal du programme.
	 * Initialise une instance du jeu et de l'interface graphique, et les associe.
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés).
	 * @throws IOException Si une erreur survient lors de l'initialisation de l'interface graphique.
	 */
	public static void main(String[] args) throws IOException {



		String bdd = "scoreszombie_bdd";
		String url = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/scoreszombie_bdd";
		String user = "400801";
		String passwd = "G84tBuYsyJ4OyHM";

		Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);


		//DbConnection.DbAddScore();



	}


}
