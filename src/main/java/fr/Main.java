package fr;


import fr.DataBase.DbConnection;

import java.io.IOException;

import java.awt.EventQueue;
import java.sql.*;


public class Main {

	public static void main(String[] args) throws IOException {



		String BDD = "scoreszombie_bdd";
		String url = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/scoreszombie_bdd";
		String user = "400801";
		String passwd = "G84tBuYsyJ4OyHM";

		Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);


		//DbConnection.DbAddScore();



	}


}
