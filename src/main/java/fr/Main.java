package fr;


import java.io.IOException;


public class Main {



	public static void main(String[] args) throws IOException {
		/*Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);*/


		String BDD = "scoreszombie_bdd";
		String url = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/scoreszombie_bdd";
		String user = "400801";
		String passwd = "G84tBuYsyJ4OyHM";


		GUI gui;
		Jeu jeu = new Jeu();
		jeu.setGUI(gui = new GUI(jeu));

		//String nomCarte = "OUT";

		//DbConnection.DbAddScore();


	}

}
