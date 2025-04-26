package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellEnd;

public class CellEndTest {

    private CellEnd cellEnd;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellEnd = new CellEnd(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellEnd = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "END"
        assertEquals("END", cellEnd.getType(), "Le type de la cellule doit être 'END'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellEnd.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellEnd.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellEnd.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellEnd.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellEnd otherCell = new CellEnd(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellEnd.setPosition(otherCell);
        assertEquals(3, cellEnd.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellEnd.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellEnd.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellEnd.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellEnd.setPosition(5, 6, 50, 60);
        assertEquals(5, cellEnd.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellEnd.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellEnd.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellEnd.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellEnd equalCell = new CellEnd(1, 2, 10, 20);
        assertTrue(cellEnd.equals(equalCell), "Les cellules doivent être égales.");

        CellEnd differentCell = new CellEnd(3, 4, 30, 40);
        assertFalse(cellEnd.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellEnd equalCell = new CellEnd(1, 2, 10, 20);
        assertEquals(cellEnd.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}