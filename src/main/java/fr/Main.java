package fr;


import fr.DataBase.DbConnection;

import java.io.IOException;

import java.awt.EventQueue;
import java.sql.*;


public class Main {



	public static void main(String[] args) throws IOException {
		/*Jeu jeu = new Jeu();
		GUI gui = new GUI( jeu);
		jeu.setGUI( gui);*/


		String BDD = "scoreszombie_bdd";
		String url = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/scoreszombie_bdd";
		String user = "400801";
		String passwd = "G84tBuYsyJ4OyHM";



		//GUI2 gui = new GUI2();

		//String nomCarte = "OUT";

		DbConnection.DbAddScore();





	}


}
