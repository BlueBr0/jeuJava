package fr.Test;

import fr.Utilities.Loot;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellLoot;

public class CellLootTest {

    private CellLoot cellLoot;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellLoot = new CellLoot(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellLoot = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "LOOT"
        assertEquals("LOOT", cellLoot.getType(), "Le type de la cellule doit être 'LOOT'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellLoot.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellLoot.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellLoot.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellLoot.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellLoot otherCell = new CellLoot(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellLoot.setPosition(otherCell);
        assertEquals(3, cellLoot.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellLoot.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellLoot.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellLoot.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellLoot.setPosition(5, 6, 50, 60);
        assertEquals(5, cellLoot.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellLoot.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellLoot.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellLoot.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

//    @Test
//    public void testLootInitialization() {
//        // Vérifie que l'objet Loot est correctement initialisé
//        assertNotNull(cellLoot.loot, "L'objet Loot doit être initialisé.");
//    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellLoot equalCell = new CellLoot(1, 2, 10, 20);
        assertTrue(cellLoot.equals(equalCell), "Les cellules doivent être égales.");

        CellLoot differentCell = new CellLoot(3, 4, 30, 40);
        assertFalse(cellLoot.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellLoot equalCell = new CellLoot(1, 2, 10, 20);
        assertEquals(cellLoot.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
