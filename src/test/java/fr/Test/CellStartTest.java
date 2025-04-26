package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellStart;

public class CellStartTest {

    private CellStart cellStart;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellStart = new CellStart(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellStart = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "START"
        assertEquals("START", cellStart.getType(), "Le type de la cellule doit être 'START'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellStart.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellStart.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellStart.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellStart.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellStart otherCell = new CellStart(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellStart.setPosition(otherCell);
        assertEquals(3, cellStart.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellStart.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellStart.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellStart.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellStart.setPosition(5, 6, 50, 60);
        assertEquals(5, cellStart.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellStart.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellStart.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellStart.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellStart equalCell = new CellStart(1, 2, 10, 20);
        assertTrue(cellStart.equals(equalCell), "Les cellules doivent être égales.");

        CellStart differentCell = new CellStart(3, 4, 30, 40);
        assertFalse(cellStart.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellStart equalCell = new CellStart(1, 2, 10, 20);
        assertEquals(cellStart.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
