package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellPlayer;

public class CellPlayerTest {

    private CellPlayer cellPlayer;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellPlayer = new CellPlayer(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellPlayer = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "PLAYER"
        assertEquals("PLAYER", cellPlayer.getType(), "Le type de la cellule doit être 'PLAYER'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellPlayer.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellPlayer.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellPlayer.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellPlayer.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellPlayer otherCell = new CellPlayer(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellPlayer.setPosition(otherCell);
        assertEquals(3, cellPlayer.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellPlayer.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellPlayer.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellPlayer.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellPlayer.setPosition(5, 6, 50, 60);
        assertEquals(5, cellPlayer.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellPlayer.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellPlayer.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellPlayer.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellPlayer equalCell = new CellPlayer(1, 2, 10, 20);
        assertTrue(cellPlayer.equals(equalCell), "Les cellules doivent être égales.");

        CellPlayer differentCell = new CellPlayer(3, 4, 30, 40);
        assertFalse(cellPlayer.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellPlayer equalCell = new CellPlayer(1, 2, 10, 20);
        assertEquals(cellPlayer.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
