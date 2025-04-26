package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Entities.Ennemy;

public class EnnemyTest {

    private Ennemy ennemy;

    @BeforeEach
    public void setUp() {
        // Initialisation avant chaque test
        ennemy = new Ennemy("TestEnnemy", 100);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        ennemy = null;
    }

    @Test
    public void testGetHealth() {
        // Vérifie que la santé initiale est correcte
        assertEquals(100, ennemy.getHealth(), "La santé initiale doit être 100.");
    }

    @Test
    public void testSetHealth() {
        // Modifie la santé et vérifie que la nouvelle valeur est correcte
        ennemy.setHealth(80);
        assertEquals(80, ennemy.getHealth(), "La santé doit être mise à jour à 80.");
    }
}