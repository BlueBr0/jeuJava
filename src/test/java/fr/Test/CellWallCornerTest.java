package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellWallCorner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class CellWallCornerTest {

    private CellWallCorner cellWallCorner;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellWallCorner = new CellWallCorner(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellWallCorner = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "WALLCORNER"
        assertEquals("WALLCORNER", cellWallCorner.getType(), "Le type de la cellule doit être 'WALLCORNER'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellWallCorner.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellWallCorner.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellWallCorner.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellWallCorner.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellWallCorner otherCell = new CellWallCorner(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellWallCorner.setPosition(otherCell);
        assertEquals(3, cellWallCorner.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellWallCorner.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellWallCorner.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellWallCorner.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellWallCorner.setPosition(5, 6, 50, 60);
        assertEquals(5, cellWallCorner.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellWallCorner.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellWallCorner.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellWallCorner.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellWallCorner equalCell = new CellWallCorner(1, 2, 10, 20);
        assertTrue(cellWallCorner.equals(equalCell), "Les cellules doivent être égales.");

        CellWallCorner differentCell = new CellWallCorner(3, 4, 30, 40);
        assertFalse(cellWallCorner.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellWallCorner equalCell = new CellWallCorner(1, 2, 10, 20);
        assertEquals(cellWallCorner.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
