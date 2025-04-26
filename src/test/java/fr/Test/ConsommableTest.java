package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Utilities.Consommable;
import fr.Utilities.Rarete;

public class ConsommableTest {

    private Consommable consommable;
    private Rarete rarete;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un objet Consommable avant chaque test
        rarete = Rarete.COMMUN; // Supposons que Rarete est une énumération avec une valeur COMMUN
        consommable = new Consommable("Potion", rarete, "Pot.");
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        consommable = null;
    }

    @Test
    public void testGetNomConsommale() {
        // Vérifie que le nom de l'objet consommable est correct
        assertEquals("Potion", consommable.getNomConsommale(), "Le nom de l'objet consommable doit être 'Potion'.");
    }

    @Test
    public void testGetRarete() {
        // Vérifie que la rareté de l'objet consommable est correcte
        assertEquals(rarete, consommable.getRarete(), "La rareté de l'objet consommable doit être 'COMMUN'.");
    }

    @Test
    public void testGetDiminutif() {
        // Vérifie que le diminutif de l'objet consommable est correct
        assertEquals("Pot.", consommable.getDiminutif(), "Le diminutif de l'objet consommable doit être 'Pot.'.");
    }
}
