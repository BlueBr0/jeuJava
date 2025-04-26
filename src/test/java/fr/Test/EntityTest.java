package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Entities.Entity;

public class EntityTest {

    private Entity entity;

    @BeforeEach
    public void setUp() {
        // Initialisation avant chaque test
        entity = new Entity("TestEntity", 100);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        entity = null;
    }

    @Test
    public void testGetHealth() {
        // Vérifie que la santé initiale est correcte
        assertEquals(100, entity.getHealth(), "La santé initiale doit être 100.");
    }

    @Test
    public void testSetHealth() {
        // Modifie la santé et vérifie que la nouvelle valeur est correcte
        entity.setHealth(80);
        assertEquals(80, entity.getHealth(), "La santé doit être mise à jour à 80.");
    }
}