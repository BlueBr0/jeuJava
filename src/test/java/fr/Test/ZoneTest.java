package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Zone;

public class ZoneTest {

    private Zone zone;
    private Zone unlockedZone;

    @BeforeEach
    public void setUp() {
        // Initialisation d'une zone verrouillée et d'une zone déverrouillée avant chaque test
        zone = new Zone("Forest", true);
        unlockedZone = new Zone("Outskirts", false);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        zone = null;
        unlockedZone = null;
    }

    @Test
    public void testIsLocked() {
        // Vérifie que l'état de verrouillage est correct
        assertTrue(zone.isLoocked(), "La zone doit être verrouillée.");
        assertFalse(unlockedZone.isLoocked(), "La zone ne doit pas être verrouillée.");
    }

    @Test
    public void testToString() {
        // Vérifie que la méthode toString retourne la description correcte
        assertEquals("Forest", zone.toString(), "La description de la zone doit être 'Forest'.");
        assertEquals("Outskirts", unlockedZone.toString(), "La description de la zone doit être 'Outskirts'.");
    }

    @Test
    public void testSetUnlocks() {
        // Définit une zone à déverrouiller
        zone.setUnlocks(unlockedZone);

        // Vérifie que la zone à déverrouiller est correctement définie
        assertEquals(unlockedZone, zone.unlocks, "La zone à déverrouiller doit être 'Outskirts'.");
    }
}
