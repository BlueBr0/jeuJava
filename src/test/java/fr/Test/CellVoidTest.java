package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellVoid;

public class CellVoidTest {

    private CellVoid cellVoid;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellVoid = new CellVoid(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellVoid = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "VOID"
        assertEquals("VOID", cellVoid.getType(), "Le type de la cellule doit être 'VOID'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellVoid.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellVoid.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellVoid.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellVoid.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellVoid otherCell = new CellVoid(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellVoid.setPosition(otherCell);
        assertEquals(3, cellVoid.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellVoid.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellVoid.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellVoid.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellVoid.setPosition(5, 6, 50, 60);
        assertEquals(5, cellVoid.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellVoid.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellVoid.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellVoid.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellVoid equalCell = new CellVoid(1, 2, 10, 20);
        assertTrue(cellVoid.equals(equalCell), "Les cellules doivent être égales.");

        CellVoid differentCell = new CellVoid(3, 4, 30, 40);
        assertFalse(cellVoid.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellVoid equalCell = new CellVoid(1, 2, 10, 20);
        assertEquals(cellVoid.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
