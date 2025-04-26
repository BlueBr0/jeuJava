package fr.Test;

import fr.Entities.Ennemy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Map.Cells.CellEnemy;

public class CellEnemyTest {

    private CellEnemy cellEnemy;

    @BeforeEach
    public void setUp() {
        // Initialisation de la cellule avant chaque test
        cellEnemy = new CellEnemy(1, 2, 10, 20);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        cellEnemy = null;
    }

    @Test
    public void testGetType() {
        // Vérifie que la méthode getType retourne "ENEMY"
        assertEquals("ENEMY", cellEnemy.getType(), "Le type de la cellule doit être 'ENEMY'.");
    }

    @Test
    public void testGetPositions() {
        // Vérifie les coordonnées initiales de la cellule
        assertEquals(1, cellEnemy.getXPosition(), "La coordonnée x doit être 1.");
        assertEquals(2, cellEnemy.getYPosition(), "La coordonnée y doit être 2.");
        assertEquals(10, cellEnemy.getXGamePosition(), "La coordonnée x dans le jeu doit être 10.");
        assertEquals(20, cellEnemy.getYGamePosition(), "La coordonnée y dans le jeu doit être 20.");
    }

    @Test
    public void testSetPositionFromOtherCell() {
        // Crée une autre cellule pour tester la copie des coordonnées
        CellEnemy otherCell = new CellEnemy(3, 4, 30, 40);

        // Modifie la position de la cellule en copiant une autre cellule
        cellEnemy.setPosition(otherCell);
        assertEquals(3, cellEnemy.getXPosition(), "La coordonnée x doit être mise à jour à 3.");
        assertEquals(4, cellEnemy.getYPosition(), "La coordonnée y doit être mise à jour à 4.");
        assertEquals(30, cellEnemy.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 30.");
        assertEquals(40, cellEnemy.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 40.");
    }

    @Test
    public void testSetPositionWithCoordinates() {
        // Modifie la position de la cellule avec des coordonnées spécifiées
        cellEnemy.setPosition(5, 6, 50, 60);
        assertEquals(5, cellEnemy.getXPosition(), "La coordonnée x doit être mise à jour à 5.");
        assertEquals(6, cellEnemy.getYPosition(), "La coordonnée y doit être mise à jour à 6.");
        assertEquals(50, cellEnemy.getXGamePosition(), "La coordonnée x dans le jeu doit être mise à jour à 50.");
        assertEquals(60, cellEnemy.getYGamePosition(), "La coordonnée y dans le jeu doit être mise à jour à 60.");
    }

    @Test
    public void testSetRandomEnemy() {
        // Vérifie que l'ennemi est initialisé avec un nom correct et une santé aléatoire entre 1 et 5
        Ennemy enemy = cellEnemy.zombie;
        assertTrue(enemy.getHealth() >= 1 && enemy.getHealth() <= 5, "La santé de l'ennemi doit être entre 1 et 5.");
    }

    @Test
    public void testEquals() {
        // Vérifie que deux cellules avec les mêmes coordonnées dans le jeu sont égales
        CellEnemy equalCell = new CellEnemy(1, 2, 10, 20);
        assertTrue(cellEnemy.equals(equalCell), "Les cellules doivent être égales.");

        CellEnemy differentCell = new CellEnemy(3, 4, 30, 40);
        assertFalse(cellEnemy.equals(differentCell), "Les cellules ne doivent pas être égales.");
    }

    @Test
    public void testHashCode() {
        // Vérifie que deux cellules égales ont le même code de hachage
        CellEnemy equalCell = new CellEnemy(1, 2, 10, 20);
        assertEquals(cellEnemy.hashCode(), equalCell.hashCode(), "Les codes de hachage doivent être égaux.");
    }
}
