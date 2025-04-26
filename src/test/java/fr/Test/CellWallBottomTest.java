package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellWallBottom;

public class CellWallBottomTest {

    private CellWallBottom cellWallBottom;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellWallBottom = new CellWallBottom(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellWallBottom = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "WALLBOTTOM"
        assertEquals("WALLBOTTOM", cellWallBottom.getType(), "Le type de la cellule doit être 'WALLBOTTOM'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellWallBottom.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellWallBottom.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellWallBottom.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellWallBottom.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellWallBottom otherCell = new CellWallBottom(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellWallBottom.setPosition(otherCell);
        assertEquals(3, cellWallBottom.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellWallBottom.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellWallBottom.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellWallBottom.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellWallBottom.setPosition(5, 6, 50, 60);
        assertEquals(5, cellWallBottom.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellWallBottom.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellWallBottom.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellWallBottom.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellWallBottom equalCell = new CellWallBottom(1, 2, 10, 20);
        assertTrue(cellWallBottom.equals(equalCell), "Les cellules doivent être égales.");

        CellWallBottom differentCell = new CellWallBottom(3, 4, 30, 40);
        assertFalse(cellWallBottom.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellWallBottom equalCell = new CellWallBottom(1, 2, 10, 20);
        assertEquals(cellWallBottom.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
