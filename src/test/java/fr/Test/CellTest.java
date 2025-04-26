package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.Cell;

public class CellTest {

    private ConcreteCell cell;
    private ConcreteCell otherCell;

    @BeforeEach
    public void setUp() {
        // Initialisation des cellules avant chaque test
        cell = new ConcreteCell(1, 2, 10, 20);
        otherCell = new ConcreteCell(3, 4, 30, 40);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cell = null;
        otherCell = null;
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cell.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cell.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cell.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cell.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Modifie la position de la cellule en copiant une autre cellule
        cell.setPosition(otherCell);
        assertEquals(3, cell.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cell.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cell.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cell.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cell.setPosition(5, 6, 50, 60);
        assertEquals(5, cell.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cell.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cell.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cell.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        ConcreteCell equalCell = new ConcreteCell(1, 2, 10, 20);
        assertTrue(cell.equals(equalCell), "Les cellules doivent être égales.");
        assertFalse(cell.equals(otherCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        ConcreteCell equalCell = new ConcreteCell(1, 2, 10, 20);
        assertEquals(cell.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }

    // Sous-classe concrète pour les besoins du test
    private static class ConcreteCell extends Cell {
        public ConcreteCell(int x, int y, int xg, int yg) {
            super(x, y, xg, yg);
        }

        @Override
        public String getType() {
            return "CONCRETE";
        }
    }
}
