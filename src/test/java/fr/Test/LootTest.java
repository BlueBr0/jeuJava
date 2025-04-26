package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.reflect.Field;

import fr.Utilities.Consommable;
import fr.Utilities.Loot;

public class LootTest {

    private Loot loot;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un objet Loot avant chaque test
        loot = new Loot();
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        loot = null;
    }

    @Test
    public void testLootInitialization() throws IllegalAccessException, NoSuchFieldException {
        // Utilise la réflexion pour accéder à la liste privée de loot
        Field field = Loot.class.getDeclaredField("loot");
        field.setAccessible(true);
        ArrayList<Consommable> lootList = (ArrayList<Consommable>) field.get(loot);

        // Vérifie que la liste de loot contient un objet consommable
        assertEquals(1, lootList.size(), "La liste de butin doit contenir un objet consommable.");

        // Vérifie que l'objet consommable est valide
        Consommable consommable = lootList.get(0);
        assertNotNull(consommable, "L'objet consommable ne doit pas être nul.");
        assertNotNull(consommable.getNomConsommale(), "Le nom de l'objet consommable ne doit pas être nul.");
        assertNotNull(consommable.getRarete(), "La rareté de l'objet consommable ne doit pas être nulle.");
        assertNotNull(consommable.getDiminutif(), "Le diminutif de l'objet consommable ne doit pas être nul.");
    }
}
