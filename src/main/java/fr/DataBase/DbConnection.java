package fr.DataBase;

import java.sql.*;

public class DbConnection {

    public static final String BDD = "scoreszombie_bdd";
    public static final String url = "jdbc:mysql://mysql-scoreszombie.alwaysdata.net:3306/" + BDD;
    public static final String user = "400801";
    public static final String passwd = "G84tBuYsyJ4OyHM";

    //INSERT INTO score (nomjoueur, temps, idniveau, coderang, points) VALUES
    //('GREG', '18:00:00', 'OUT1', 'A', 210),

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Updated driver
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connected to MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
            conn = null;
        }

        return conn;
    }

    public static void DbAddScore() {
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


    public static void DbGetPlayers(String idMap){
        try {

            Connection conn = getConnection();

            if(conn != null){
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
            else{
                throw new SQLException();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
        }
    }
}
