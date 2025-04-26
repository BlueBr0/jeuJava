package fr.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import fr.Utilities.Calcul;

public class CalculTest {

    private Calcul calcul;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un objet Calcul avec un niveau de difficulté avant chaque test
        calcul = new Calcul(5);
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        calcul = null;
    }

    @Test
    public void testGenererNouvelleOperation() {
        // Vérifie que l'opération générée est valide
        String operationText = calcul.getOperationText();
        assertNotNull(operationText, "L'opération générée ne doit pas être nulle.");

        // Vérifie que les nombres sont dans la plage attendue
        assertTrue(calcul.getNombre1() >= 1 && calcul.getNombre1() <= 10, "Le premier nombre doit être entre 1 et 10.");
        assertTrue(calcul.getNombre2() >= 1 && calcul.getNombre2() <= 10, "Le second nombre doit être entre 1 et 10.");

        // Vérifie que l'opérateur est valide
        char operation = calcul.getOperation();
        assertTrue("+-*/".indexOf(operation) >= 0, "L'opérateur doit être l'un des suivants : '+', '-', '*', '/'.");
    }

    @Test
    public void testVerifierReponse() {
        // Vérifie que la méthode verifierReponse fonctionne correctement
        double resultat = calcul.getResultat();
        assertTrue(calcul.verifierReponse(resultat), "La méthode verifierReponse doit retourner true pour le résultat correct.");
        assertFalse(calcul.verifierReponse(resultat + 1), "La méthode verifierReponse doit retourner false pour un résultat incorrect.");
    }

    @Test
    public void testGetOperationText() {
        // Vérifie que la méthode getOperationText retourne une chaîne non vide
        String operationText = calcul.getOperationText();
        assertNotNull(operationText, "Le texte de l'opération ne doit pas être nul.");
        assertFalse(operationText.isEmpty(), "Le texte de l'opération ne doit pas être vide.");
    }

    @Test
    public void testGetResultat() {
        // Vérifie que le résultat est calculé correctement
        double resultat = calcul.getResultat();
        assertTrue(calcul.verifierReponse(resultat), "Le résultat doit être correct.");
    }

    @Test
    public void testGetNombre1() {
        // Vérifie que le premier nombre est dans la plage attendue
        int nombre1 = calcul.getNombre1();
        assertTrue(nombre1 >= 1 && nombre1 <= 10, "Le premier nombre doit être entre 1 et 10.");
    }

    @Test
    public void testGetNombre2() {
        // Vérifie que le second nombre est dans la plage attendue
        int nombre2 = calcul.getNombre2();
        assertTrue(nombre2 >= 1 && nombre2 <= 10, "Le second nombre doit être entre 1 et 10.");
    }

    @Test
    public void testGetOperation() {
        // Vérifie que l'opérateur est valide
        char operation = calcul.getOperation();
        assertTrue("+-*/".indexOf(operation) >= 0, "L'opérateur doit être l'un des suivants : '+', '-', '*', '/'.");
    }
}
