package fr.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe utilitaire pour gérer la connexion à la base de données MySQL et effectuer des opérations CRUD.
 * Cette classe fournit des méthodes pour se connecter à la base de données, ajouter des scores et récupérer des
 * informations sur les joueurs.
 */
public class DbConnection {

    public static final String BDD = "scoreszombie_bdd";
    public static final String URL = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/" + BDD;
    public static final String USER = "400801";
    public static final String PASSWD = "G84tBuYsyJ4OyHM";

    //INSERT INTO score (nomjoueur, temps, idniveau, coderang, points) VALUES
    //('GREG', '18:00:00', 'OUT1', 'A', 210),

    /**
     * Établit une connexion à la base de données MySQL en utilisant les informations de connexion spécifiées.
     *
     * @return Un objet Connection représentant la connexion à la base de données, ou null si la connexion échoue.
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Updated driver
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connected to MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
            conn = null;
        }

        return conn;
    }

    /**
     * Ajoute un score à la table "score" dans la base de données.
     * Le score ajouté est prédéfini avec des valeurs spécifiques pour le nom du joueur, le temps,
     * l'identifiant du niveau, le code du rang et les points.
     *
     * @throws SQLException Si la connexion à la base de données échoue ou si une erreur SQL se produit.
     */
    public static void dbAddScore() {
        try {

            Connection conn = getConnection();

            if (conn != null) {
                Statement stmt = conn.createStatement();

                String sql = "INSERT INTO score (nomjoueur, temps, idniveau, coderang, points) " +
                        "VALUES ('ENZO', '18:00:00', 'OUT2', 'A', 210)";


                int rowsInserted = stmt.executeUpdate(sql);


                if (rowsInserted > 0) {
                    System.out.println("Added 1 row");
                }

                stmt.close();
                conn.close();
            } else {
                throw new SQLException("Connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred");
        }
    }


    /**
     * Récupère et affiche les informations des joueurs pour un niveau spécifique à partir de la base de données.
     * Les informations incluent le nom du joueur, les points, le code du rang, le libellé du niveau et le temps.
     *
     * @param idMap L'identifiant du niveau pour lequel récupérer les joueurs.
     * @throws SQLException Si la connexion à la base de données échoue ou si une erreur SQL se produit.
     */
    public static void dbGetPlayers(String idMap){
        try {

            Connection conn = getConnection();

            if (conn != null){
                Statement stmt = conn.createStatement();

                String sql = "SELECT nomJoueur, points, s.coderang, libelleniveau, " +
                        "TIME_FORMAT(temps, '%i:%s') as temps " +
                        "FROM score s " +
                        "JOIN niveau n ON n.idniveau = s.idniveau " +
                        "JOIN rang r ON r.coderang = s.coderang " +
                        "WHERE s.idniveau LIKE CONCAT('%', ?, '%') " +
                        "ORDER BY points DESC, temps ASC";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, idMap);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String nomJoueur = rs.getString("nomJoueur");
                    int points = rs.getInt("points");
                    String coderang = rs.getString("coderang");
                    String libelleniveau = rs.getString("libelleniveau");
                    String temps = rs.getString("temps");

                    System.out.println(nomJoueur + " | " + points + " pts | " +
                            coderang + " | " + libelleniveau + " | " + temps);
                }

                rs.close();
                stmt.close();
                conn.close();
            }
            else {
                throw new SQLException();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
        }
    }
}
