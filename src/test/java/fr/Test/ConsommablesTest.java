package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.reflect.Field;

import fr.Utilities.Consommable;
import fr.Utilities.Consommables;

public class ConsommablesTest {

    private Consommables consommables;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un objet Consommables avant chaque test
        consommables = new Consommables();
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        consommables = null;
    }

    @Test
    public void testChargerConsommables() throws IllegalAccessException, NoSuchFieldException {
        // Utilise la réflexion pour accéder à la liste privée des consommables
        Field field = Consommables.class.getDeclaredField("lesConsommables");
        field.setAccessible(true);
        ArrayList<Consommable> lesConsommables = (ArrayList<Consommable>) field.get(null);

        // Vérifie que la liste des consommables est correctement chargée
        assertEquals(9, lesConsommables.size(), "La liste doit contenir 9 objets consommables.");

        // Vérifie que les objets consommables ont les bonnes valeurs
        assertTrue(lesConsommables.get(0).getNomConsommale().equals("Petite trousse de soin"), "Le premier objet doit être 'Petite trousse de soin'.");
        assertTrue(lesConsommables.get(1).getDiminutif().equals("BC"), "Le deuxième objet doit avoir le diminutif 'BC'.");
    }

    @Test
    public void testGetRandomConsommable() throws IllegalAccessException, NoSuchFieldException {
        // Vérifie que la méthode getRandomConsommable retourne un objet consommable
        Consommable randomConsommable = Consommables.getRandomConsommable();
        assertNotNull(randomConsommable, "L'objet consommable aléatoire ne doit pas être nul.");

        // Utilise la réflexion pour accéder à la liste privée des consommables
        Field field = Consommables.class.getDeclaredField("lesConsommables");
        field.setAccessible(true);
        ArrayList<Consommable> lesConsommables = (ArrayList<Consommable>) field.get(null);

        // Vérifie que l'objet retourné est dans la liste des consommables
        assertTrue(lesConsommables.contains(randomConsommable), "L'objet consommable aléatoire doit être dans la liste des consommables.");
    }

    @Test
    public void testGetRandomConsommableWithEmptyList() throws IllegalAccessException, NoSuchFieldException {
        // Utilise la réflexion pour accéder et vider la liste privée des consommables
        Field field = Consommables.class.getDeclaredField("lesConsommables");
        field.setAccessible(true);
        field.set(null, new ArrayList<>());

        // Vérifie que la méthode retourne l'objet consommable par défaut
        Consommable randomConsommable = Consommables.getRandomConsommable();
        assertEquals("Vieille canette vide", randomConsommable.getNomConsommale(), "L'objet consommable par défaut doit être 'Vieille canette vide'.");
    }
}