package fr.Entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        // Initialisation avant chaque test
        player = new Player("TestPlayer", 100);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        player = null;
    }

    @Test
    public void testGetHealth() {
        // Vérifie que la santé initiale est correcte
        assertEquals(100, player.getHealth(), "La santé initiale doit être 100.");
    }

    @Test
    public void testSetHealth() {
        // Modifie la santé et vérifie que la nouvelle valeur est correcte
        player.setHealth(80);
        assertEquals(80, player.getHealth(), "La santé doit être mise à jour à 80.");
    }

    @Test
    public void testToString() {
        // Vérifie que la méthode toString retourne la représentation correcte du joueur
        String expected = "TestPlayer\r\nPV : 100\r\nMUNITIONS : 10";
        assertEquals(expected, player.toString(), "La représentation sous forme de chaîne doit être correcte.");
    }
}
